/*Uma locadora brasileira de carros cobra um valor por hora para loca��es de at�
12 horas. Por�m, se a dura��o da loca��o ultrapassar 12 horas, a loca��o ser�
cobrada com base em um valor di�rio. Al�m do valor da loca��o, � acrescido no
pre�o o valor do imposto conforme regras do pa�s que, no caso do Brasil, � 20%
para valores at� 100.00, ou 15% para valores acima de 100.00. Fazer um
programa que l� os dados da loca��o (modelo do carro, instante inicial e final da
loca��o), bem como o valor por hora e o valor di�rio de loca��o. O programa
deve ent�o gerar a nota de pagamento (contendo valor da loca��o, valor do
imposto e valor total do pagamento) e informar os dados na tela. Veja os
exemplos.
 */

package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidade.Aluguel;
import model.entidade.Veiculo;
import model.servicos.ServicoAluguel;
import model.servicos.TaxaServicoBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Insira os dados do aluguel: ");
		System.out.print("Modelo carro: ");
		String modelo = sc.nextLine();
		System.out.print("Data da retirada do carro (dd/MM/yyyy hh:ss):");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Data do retornoln (dd/MM/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		Aluguel cr = new Aluguel(start, finish, new Veiculo(modelo)); 
		
		System.out.print("Digite o pre�o por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Digite o preco por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorDia, precoPorHora, new TaxaServicoBrasil());
		
		servicoAluguel.processoFatura(cr);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento B�sico: " + String.format("%.2f", cr.getFatuta().getPagamentoBasico()));
		System.out.println("Taxa : " + String.format("%.2f", cr.getFatuta().getTaxa()));
		System.out.println("Pagamento Total: " + String.format("%.2f", cr.getFatuta().getPagamentoTotal()));
		
		sc.close();

	}

}
