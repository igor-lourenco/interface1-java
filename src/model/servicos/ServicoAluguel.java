package model.servicos;

import model.entidade.Aluguel;
import model.entidade.Fatura;

public class ServicoAluguel {

	private Double precoPorDia;
	private Double precoPorHora;
	
	private TaxaServico taxaServico;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServico taxaServico) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	public void processoFatura(Aluguel aluguel) {
		long t1 = aluguel.getStart().getTime();
		long t2 = aluguel.getFinish().getTime();
		double horas = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double pagamentoBasico;
		if(horas <= 12.0)
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		else
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		
		double taxa = taxaServico.taxa(pagamentoBasico);
		aluguel.setFatuta(new Fatura(pagamentoBasico, taxa));
	}
}
