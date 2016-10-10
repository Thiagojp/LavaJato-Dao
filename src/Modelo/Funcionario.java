package Modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Funcionario extends Pessoa {
	@Column(name="MATRICULA_FUNC")
	private int mat;
	
	@OneToMany(mappedBy="funcionario", cascade=CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval=true)
	private ArrayList <Pedido> pedidos = new ArrayList<Pedido>();
	
	public Funcionario(){}
	public Funcionario(String nome, int cpf,int mat) {
		super(nome, cpf);
		this.mat = mat;
		
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
//	public int getCpf() {
//		return cpf;
//	}
//	public void setCpf(int cpf) {
//		this.cpf = cpf;
//	}
	@Override
	public String toString() {
		return "Matrícula = " + super.toString() ;// " Cpf=" +cpf;// +" Matricula ="+ mat+;
	}
	
	
}
