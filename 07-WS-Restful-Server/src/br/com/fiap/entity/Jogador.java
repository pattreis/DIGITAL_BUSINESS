package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_JOGADOR")
@SequenceGenerator(name="jogador", sequenceName="SQ_T_JOGADOR")
public class Jogador {
	
	@Id
	@Column(name="cd_jogador")
	@GeneratedValue(generator="jogador", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Column(name="nm_jogador", nullable=false, length=200)
	private String nome;
	
	@Column(name="nr_jogador")
	private int numero;
	
	@Column(name="st_titular")
	private boolean titular;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}
	
	

}
