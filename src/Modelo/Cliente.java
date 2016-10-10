package Modelo;

import java.util.ArrayList;

import javax.persistence.*;

import Modelo.Carro;

@Entity
//@DiscriminatorValue("Cliente")
public class Cliente extends Pessoa {
	
	@Column(name="RG_CLIENTE")
	private int rg;
	

	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private ArrayList <Carro> carros = new ArrayList<Carro>();
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval=true)
	ArrayList <Pedido> pedidos = new ArrayList<Pedido>();
	
	
	public Cliente(){
		super();
	}
	
	public Cliente(String nome, int cpf,int rg) {
		super(nome, cpf);
		this.rg = rg;
	}
	
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public ArrayList<Carro> getCarro() {
		return carros;
	}
	public void setCarro(ArrayList<Carro> carro) {
		this.carros = carro;
	}
	public void adicionarVeiculo(Carro c){
		carros.add(c);
		c.setCliente(this);
	}
/*	public void adicionarCarro(Carro c){
		carros.add(c);
		c.setCarro(this);
	}*/

	
	@Override
	public String toString() {
		//return "RG = " + super.toString();// + " Rg ="+ rg;
		return super.toString() + "    "+"Rg cliente= "+ rg;
	}
	
	
	
	

}
