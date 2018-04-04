package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_PACIENTE")
public class Paciente {

	@Id
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_paciente", nullable=false, length=200)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;
	
	@Column(name="st_doador")
	private boolean doador;

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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isDoador() {
		return doador;
	}

	public void setDoador(boolean doador) {
		this.doador = doador;
	}
}
