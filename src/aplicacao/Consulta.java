package aplicacao;

import Modelo.Carro;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.Pedido;
import fachada.Sistema;

public class Consulta {

	public Consulta() {
		try {
			
			Sistema.inicializar();

	


		
	    //	System.out.println(Sistema.listnomecar("Corsa"));
			System.out.println(Sistema.listmedetotal(3268));
           
			
			
			       
			       
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Sistema.finalizar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Consulta();
	}
}
