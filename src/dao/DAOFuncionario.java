package dao;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import Modelo.Funcionario;


public class DAOFuncionario extends DAO<Funcionario> {
		
	public DAOFuncionario() {
		super();
	}
	public Funcionario localizarFuncPelaMatricula(int mat) {
		try {
			Query q = manager.createQuery("select fun from Funcionario fun where fun.mat = '" + mat + "'");	
			//List<Aluno> lista = q.getResultList();
			return (Funcionario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Funcionario> listaTodosFuncionarios() {
		try {
			Query a = manager.createQuery("select f from Funcionario f");	
			List<Funcionario> listaFuncionarios = a.getResultList();
			return listaFuncionarios;
		} catch (NoResultException e) {
			return null;
		}
	}
}
