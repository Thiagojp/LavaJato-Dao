package aplicacao;

import java.util.Scanner;

import fachada.Sistema;
import Modelo.*;

public class Cadastro {
	static Scanner teclado = new Scanner (System.in);

	public Cadastro() {
		try {
			Carro car;
			Funcionario fun;
			Cliente cli;
			Pedido ped;
			Sistema.inicializar();
//
//       		fun = Sistema.cadastrarFuncionario("Joao", 1234,3268);
//			fun = Sistema.cadastrarFuncionario("Pedro", 12345,1247);
//			cli = Sistema.cadastrarCliente("Diego", 123 ,124562);
//			cli = Sistema.cadastrarCliente("Camila", 1234 ,1275642);
//
//			car = Sistema.cadastrarCarro("EFG", "Corsa","Diego");
//
//			car = Sistema.cadastrarCarro("ABC", "Chevette","Camila");

			ped= Sistema.cadastrarPedido("Camila",3268,"AEF",10);










		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Sistema.finalizar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Cadastro();
	}
}