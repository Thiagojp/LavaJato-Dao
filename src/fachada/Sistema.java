package fachada;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.Query;

import Modelo.Carro;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.Pedido;
import dao.DAO;
import dao.DAOCarro;
import dao.DAOCliente;
import dao.DAOFuncionario;
import dao.DAOPedido;





public class Sistema {
	
	private static DAOCarro daoCarro = new DAOCarro();
	private static DAOCliente daoCliente = new DAOCliente();
	private static DAOFuncionario daoFuncionario = new DAOFuncionario ();
	private static DAOPedido daoPedido = new DAOPedido();
	
	public static void inicializar(){
		DAO.abrir();
	}
	
	public static void finalizar(){
		DAO.fechar();
	}
	
		
		//////////////////CADASTRO DE FUNCIONARIOS/////////////////
		public static Funcionario cadastrarFuncionario(String nome,int cpf, int mat)throws Exception{
			DAO.begin();
			
			Funcionario fun = daoFuncionario.localizarFuncPelaMatricula(mat);		
			if(fun != null) {
				throw new Exception("Funcionário ja cadastrado" + mat);			
			} 
			Funcionario novo = new Funcionario(nome, cpf,mat);			
			daoFuncionario.persistir(novo);			
			DAO.commit();			
			return novo;
			
		}
	    //////////////////CADASTRO DE CLIENTES/////////////////
		public static Cliente cadastrarCliente(String nome, int cpf ,int rg)throws Exception{
			DAO.begin();
			Cliente cli= daoCliente.localizarClientepeloNome(nome);		
			if(cli != null) {
				throw new Exception("Cliente ja cadastrado" + nome);			
			} 
			Cliente novo = new Cliente(nome, cpf,rg);
			daoCliente.persistir(novo);			
			DAO.commit();
			return novo;
			
		} 
		
		//////////////////CADASTRO DE PEDIDO/////////////////
		public static Pedido cadastrarPedido(String nome,int mat, String placa, double valor)throws Exception{	
		
		DAO.begin();	
		//SELECIONA O NOME DO CLIENTE
		
		Cliente cli= daoCliente.localizarClientepeloNome(nome);		
		if(cli == null) {
			throw new Exception("Cliente não existe" + nome);			
		}
		
		//SELECIONA A MATRICULA DO FUNCIONARIO
		Funcionario fun = daoFuncionario.localizarFuncPelaMatricula(mat);		
		if(fun == null) {
			throw new Exception("Funcionário não existe" + mat);			
		}
		
		//SELECIONA A PLACA DO CARRO
		
		Carro car = daoCarro.localizarCarropelaPlacaCli(placa,nome);		
		if( car == null) {		
			throw new Exception("A placa informada "+placa+" não pertence ao cliente: "+nome);
		}
		
		Pedido pedido = new Pedido(cli, fun,car ,valor);
		daoPedido.persistir(pedido);
		DAO.commit();
						
		return pedido;		
		}
			
	    //////////////////CADASTRO DE CARRO/////////////////	
		public static Carro cadastrarCarro(String placa, String modelo, String nome) throws Exception{
		
		DAO.begin();
		
		//SELECIONA A PLACA DO CARRO	
		Carro car = daoCarro.localizarCarropelaPlaca(placa);		
		if( car != null) {
		throw new Exception("Placa ja cadastrada" + placa);			
		}
				
	
		//SELECIONA O NOME DO CLIENTE
		
				Cliente cli= daoCliente.localizarClientepeloNome(nome);		
				if(cli == null) {
					throw new Exception("Cliente não existe" + nome);			
				}
		
		Carro carr = new Carro(placa, modelo,cli);
		daoCarro.persistir(carr);
		DAO.commit();
		
		return carr;
		}
		
	    //////////////////LISTAGEM DE FUNCIONARIOS/////////////////
		public static String listarFuncionarios() throws Exception{
			
			if (daoFuncionario.listaTodosFuncionarios().isEmpty()) {
				throw new Exception("Não existe Alunos cadastrados");
			}
			int i = 1;
			String texto = "";
			
			for (Funcionario funcionario: daoFuncionario.listaTodosFuncionarios()) {			
				texto +=  "#" + i +  " Matricula: " + funcionario.getMat() + " | Nome: " + funcionario.getNome() + " | Cpf: " + funcionario.getCpf();
				texto += "\n";
				i++;
			}
			return texto;
		}
		
	    //////////////////LISTAGEM DE CLIENTES/////////////////
		public static String listarCliente() throws Exception{
			
			if (daoCliente.listaTodosClientes().isEmpty()) {
				throw new Exception("Não existe Clientes cadastrados");
			}
			int i = 1;
			String texto = "";
			
			for (Cliente cli: daoCliente.listaTodosClientes()) {			
				texto +=  "#" + i +  " Nome: " + cli.getNome() + " | Cpf: " + cli.getCpf() + " | Rg: " + cli.getRg();
				texto += "\n";
				i++;
			}
			return texto;
		}
		
		//////////////////LISTAGEM DE CARROS/////////////////
		public static String listarCarro() throws Exception{
			String texto = "===========LISTAGEM DOS CARROS========== \n";
			
			if (daoCarro.listaTodosCarros().isEmpty()) 
				throw new Exception("Não existe Carros cadastrados");
			
			else{
			
			for (Carro car: daoCarro.listaTodosCarros()) {			
				texto += "\n" + car;
			}			
		}
			return texto;
		}
		
		//////////////////LISTAGEM DE PEDIDOS/////////////////
		public static String listarPedidos() throws Exception{

			String texto = "===========LISTAGEM DOS PEDIDOS========== \n";
			
	 			if (daoPedido.listaTodosPedidos().isEmpty()) 
					throw new Exception("Não existem Pedidos cadastrados");
				
	 			else{
				
				for (Pedido p: daoPedido.listaTodosPedidos()) {			
					texto += "\n" + p;
					
				}				
			}
	 			return texto;
		}
 

		
        //////////////////ALTERAR RG DO CLIENTE/////////////////
		public static void atualizarrg(int rg, int novorg) throws  Exception{
			DAO.begin();
			
			Cliente cli = daoCliente.localizarClientepeloRg(rg);		
			if(cli == null) {
				throw new Exception("Rg nao cadastrado: " + rg);
			} 
			
			cli.setRg(novorg);
			daoCliente.atualizar(cli);
			DAO.commit();
			
		}
				

       //////////////////REMOVER CARRO PELA PLACA/////////////////
		public static void removerCarro(String placa) throws Exception {
			
			DAO.begin();
			
			Carro car = daoCarro.localizarCarropelaPlaca(placa);		
			if( car == null) {
			throw new Exception("Placa não existe" + placa);			
			}
			
			daoCarro.apagar(car);
			DAO.commit();
			
		}
		
		////////////////LISTAR NOME DOS CARROS PERTENCENTES AO CLIENTE(PARAMETRO NOME CLIENTE)/////////////////
		public static String listnomecar(String modelo)throws  Exception{
		String texto = "===========LISTAGEM DOS NOMES DOS CLIENTES========== \n";
				
		if (daoCliente.listaTodosCarcli(modelo).isEmpty()) 
			throw new Exception("Não existem clientes com o modelo do carro informado");
		
			else{
		
		for (Cliente cli: daoCliente.listaTodosCarcli(modelo)) {			
			texto += "\n" + cli.getNome();
			
		}				
	}
			return texto;
}
		
		//////////////////LISTAR MEDIA E TOTAL DE VENDAS DO  RECEBENDO MATRICULA DO FUNCIONARIO POR MATRICULA /////////////////
		public static String listmedetotal(int mat)throws  Exception{
		String texto = "";	
		int count=0;
		double media= 0.0;
		if (daoPedido.listadados(mat).isEmpty()) 
			throw new Exception("Não existem pedidos para a matricula informada");
		else{
//		Query q = manager.createQuery("select p from Pedido p where exists( select f from Funcionario f where p.funcionario.id = f.id and f.mat = '"+mat+"') ");
//		//Query q = manager.createQuery("select p from Pedido p Join Funcionario f where p.funcionario.id = f.id and f.mat = '"+mat+"'" ); 
//		
		for (Pedido p : daoPedido.listadados(mat)){
			//texto += p.getValor();
			//texto+="-";
			media+=p.getValor();
			count++;
			
		}
		texto+= " ***** Total de vendas-> "+ media+"  ****** Média das vendas->"+media/count;
		 }
		
		return texto;
		}
}