package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import Modelo.*;


@Entity 
public class Carro {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;		
	private String placa;
	private String modelo;
//	@OneToMany(mappedBy="carro", cascade=CascadeType.ALL)
//	private ArrayList <Pedido> pedidos = new ArrayList<Pedido>();	
	@ManyToOne 
	private Cliente cliente;
	@OneToMany(mappedBy="carro",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
   
	
	
	public Carro(String placa, String modelo,Cliente cliente) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.cliente = cliente;
	}
	public Carro() {
		super();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
//	 public ArrayList<Pedido> getPedidos() {
//			return pedidos;
//		}
//
//		public void setPedidos(ArrayList<Pedido> pedidos) {
//			this.pedidos = pedidos;
//		}
//		--------------------RELACIONAMENTO--------------------------------
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
			
		}

		@Override
		public String toString() {
			return "----DADOS DO CARRO---"+"\n"+"Dono do carro =" + cliente.getNome() + "\n"+ "Placa do carro=" + placa +  "\n"+"Modelo da placa=" + modelo+  "\n"  ;
		}
}
