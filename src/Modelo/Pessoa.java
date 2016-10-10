package Modelo;

//import java.text.SimpleDateFormat;

import javax.persistence.*;
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorValue("Pessoa")
public class Pessoa {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int cpf;
		public Pessoa (){}
		
		public Pessoa(String nome, int cpf) {
			this.nome = nome;
			this.cpf = cpf;
			
		}		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		

		public int getCpf() {
			return cpf;
		}

		public void setCpf(int cpf) {
			this.cpf = cpf;
		}

		@Override
		public String toString() {
			return id + ", nome =" + nome + "cpf = " + cpf;
		}
		
}