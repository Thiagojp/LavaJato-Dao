package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Modelo.*;



@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;	
	double valor;
	@ManyToOne
	private Pessoa funcionario;
	@ManyToOne
	private Carro carro;
	@ManyToOne
	private Pessoa cliente;
	@Temporal(TemporalType.DATE)
	private Date dtcadastro = new Date();

	public Pedido() {
	super();
    }
	public Pedido(Cliente cliente,Funcionario funcionario,Carro carro,double valor ) {
		super();	
		this.cliente=(Cliente)cliente;
		this.funcionario = (Funcionario) funcionario;
		this.carro = carro;
		this.valor=valor;
		
	}
	
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Pessoa getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Date getDtcadastro() {
		return dtcadastro;
	}
	public void setDtcadastro(Date dtcadastro) {
		this.dtcadastro = dtcadastro;
	}
	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return "----DADOS DO PEDIDO DE ID: "+id+"----"+"\n"+"Nome do cliente: " + cliente.getNome() + "\n"+ "Nome do funcionario: " + funcionario.getNome() +  "\n"+"Valor do pedido: " + valor+"\n"+
				"Placa do veiculo: "+carro.getPlaca()+"\n"+"Data do pedido: " +f.format(dtcadastro.getTime()); 
	}
	
	
}