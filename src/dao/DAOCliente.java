package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import Modelo.Cliente;
import Modelo.Funcionario;

public class DAOCliente extends DAO<Cliente> {
	public DAOCliente() {
		super();
	}
	public Cliente localizarClientepeloNome(String nome) {
		try {
			Query q = manager.createQuery("select c from Cliente c where c.nome = '" + nome + "'");	
			//List<Aluno> lista = q.getResultList();
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Cliente localizarClientepeloRg(int rg) {
		try {
			Query q = manager.createQuery("select c from Cliente c where c.rg = '" + rg + "'");	
			//List<Aluno> lista = q.getResultList();
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public List<Cliente> listaTodosClientes() {
		try {
			Query a = manager.createQuery("select cli from Cliente cli");	
			List<Cliente> listaClientes = a.getResultList();
			return listaClientes;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Cliente> listaTodosCarcli(String modelo) {
		try {
			Query a = manager.createQuery("select c.cliente from Carro c  where c.modelo = '"+modelo+"'" );	
			List<Cliente> listaCarrosCli = a.getResultList();
			return listaCarrosCli;
		} catch (NoResultException e) {
			return null;
		}
	}
}



