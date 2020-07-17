package model.entidade;

import java.util.Date;

public class Aluguel {

	private Date start;
	private Date finish;
	
	private Fatura fatuta;
	private Veiculo veiculo;
	
	public Aluguel() {
	}

	public Aluguel(Date start, Date finish, Veiculo veiculo) {
		this.start = start;
		this.finish = finish;
		this.veiculo = veiculo;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Fatura getFatuta() {
		return fatuta;
	}

	public void setFatuta(Fatura fatuta) {
		this.fatuta = fatuta;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
	
}
