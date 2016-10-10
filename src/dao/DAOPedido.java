package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import Modelo.Cliente;
import Modelo.Pedido;

public class DAOPedido extends DAO<Pedido> {
	
	public DAOPedido() {
		super();
	}
	
	public List<Pedido> listaTodosPedidos() {
		try {
			Query a = manager.createQuery("select p from Pedido p");	
			List<Pedido> listaPedidos = a.getResultList();	
			return listaPedidos;
		} catch (NoResultException e) {
			return null;
		}
	}
	public List<Pedido> listadados(int mat) {
		try {
			Query a = manager.createQuery("select p from Pedido p where exists( select f from Funcionario f where p.funcionario.id = f.id and f.mat = '"+mat+"') ");	
			List<Pedido> listadados = a.getResultList();
			return listadados;
		} catch (NoResultException e) {
			return null;
		}
	}
}
