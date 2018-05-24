package br.com.fiap.ws.to;

public class Imovel {
	
	private int codigo;
	
	private String endereco;
	
	private double preco;
	
	private boolean residencial;

	
	
	public Imovel() {
		super();
		
	}

	public Imovel(String endereco, double preco, boolean residencial) {
		super();
		this.endereco = endereco;
		this.preco = preco;
		this.residencial = residencial;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isResidencial() {
		return residencial;
	}

	public void setResidencial(boolean residencial) {
		this.residencial = residencial;
	}
	
	

}
