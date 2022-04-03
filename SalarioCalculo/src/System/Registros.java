package System;

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Registros {
	
 double horasPorMes;
		
 double ganhoPorHora;
		

 void informacao() {
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Olá, bem vindo!\n\nDigite o quanto você GANHA POR HORA em seu trabalho:");
			System.out.print("R$");
			String ganhoHoraF = entrada.next().replace(",", ".");
			double gHF = Double.parseDouble(ganhoHoraF);
			this.ganhoPorHora = gHF;
			
			System.out.println("\nDigite a quantidade de horas trabalhadas no mês:");
			this.horasPorMes = entrada.nextDouble();
			
			entrada.close();
		}
 
 
 BinaryOperator<Double> calcS = (x,y) -> {return x * y;};
 BinaryOperator<Double> iR = (x,y) -> {return (x / 100.0) * y;};
 BinaryOperator<Double> salarioLiquido = (x,y) -> {return x-y;};
 
 
 
 void descontos() {
	 
	 System.out.printf("\nSalario bruto: %.2f \nImposto de Renda(IR): %.2f \nINSS: %.2f \nSindicato: %.2f",
			             calcS.apply(this.horasPorMes, this.ganhoPorHora),
			             iR.apply(calcS.apply(this.horasPorMes, this.ganhoPorHora), 11.0),
			             iR.apply(calcS.apply(this.horasPorMes, this.ganhoPorHora), 8.0),
			             iR.apply(calcS.apply(this.horasPorMes, this.ganhoPorHora),5.0));
	 
	 double salarioL = salarioLiquido.apply((this.horasPorMes * this.ganhoPorHora),(iR.apply(calcS.apply(this.horasPorMes, this.ganhoPorHora), 11.0)) +
			                               iR.apply(calcS.apply(this.horasPorMes, this.ganhoPorHora), 8.0) + iR.apply(calcS.apply(this.horasPorMes, this.ganhoPorHora),5.0));
	 
	 System.out.printf("\nSalario liquido: %.2f" , salarioL);
	 
	 
 }


	}



