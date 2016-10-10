package dao;

import java.util.List;


import javax.persistence.NoResultException;
import javax.persistence.Query;

import Modelo.*;
import fachada.Sistema;



public class DAOCarro extends DAO<Carro> {
	
	public DAOCarro() {
		super();
	}
		public Carro localizarCarropelaPlacaCli(String placa,String nome) {
			try {
				
				Query q = manager.createQuery("select c from Carro c  Join Cliente cli where c.cliente.id = cli.id and c.placa = '"+placa+"' and cli.nome='"+nome+"'");



				return (Carro) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
			
		}
		
		public Carro localizarCarropelaPlaca(String placa) {
			try {
				Query q = manager.createQuery("select car from Carro car where car.placa = '" + placa + "'");		
				
				return (Carro) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		}
		
		public List<Carro> listaTodosCarros() {
			try {
				Query a = manager.createQuery("select c from Carro c");	
				List<Carro> listaCarros = a.getResultList();	
				return listaCarros;
			} catch (NoResultException e) {
				return null;
			}
		}
	}