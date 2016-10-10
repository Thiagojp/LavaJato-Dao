package dao;


import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;


public class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;

	public DAO(){}
	
	public static void abrir(){
		if(manager==null){
			//propriedades do persistence.xml			
			HashMap<String,String> properties = new HashMap<String,String>();		
//			properties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver" );	
//			properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://127.0.0.1:3306/lavajato");
//			properties.put(PersistenceUnitProperties.JDBC_USER, "root");
//			properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "");
//			properties.put(PersistenceUnitProperties.DDL_GENERATION, "create-tables");
//			properties.put(PersistenceUnitProperties.DDL_GENERATION_MODE, "database");
//			properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "fine");
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("lavajato",properties);
			manager = factory.createEntityManager();
		}
	}
	public static void fechar(){
		if(manager != null)
			manager = null;
	}
	

	public void persistir(T obj){
		manager.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public T localizar(Object chave){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chave);
	}
	
	public T atualizar(T obj){
		return manager.merge(obj);
	}
	public void apagar(T obj) {
		manager.remove(obj);
	}
	public void reler(T obj){
		manager.refresh(obj);
	}	
	@SuppressWarnings("unchecked")
	public List<T> listar(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();

	}

	//----------------------- TRANSA��O   ----------------------
	public static void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// esvaziar o cache de objetos
		}
	}
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}
	public static void flush(){	//commit parcial
		manager.flush();
	}

}