package aplicacao;

import java.util.Scanner;

import fachada.Sistema;
import Modelo.*;

public class Atualizacao {
	

	public Atualizacao() {
		try {
			
			Sistema.inicializar();

	


//  		    System.out.println(Sistema.listarPedidos());
//		    System.out.println(Sistema.listarCarro());
//			 System.out.println(Sistema.listarFuncionarios());
//			 System.out.println(Sistema.listarCliente());
//			 Sistema.atualizarrg(1275642,123);
			 
		 //Sistema.atualizarnomefunc("Pedro","Gabriel");
			 
			
		//	Sistema.removerCarro("EFG");
			   // Sistema.removerfunc(123456);

	   
			
			
			       
			       
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Sistema.finalizar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Atualizacao();
	}
}