package com.br.desafio.bean;

import java.util.Date;

public class Hospede {
	
	private Integer codigo;
    private String nome;
    private String documento;
    private String telefone;
    
    private double valor;
    private Date entrada;
    private Date saida;
    private boolean vagaGaragem;

    public Hospede(String nome, String documento, String telefone) {
    	this.nome = nome;
    	this.documento = documento;
    	this.telefone = telefone;
    }
    
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	
	public Date getEntrada() {
		return entrada;
	}
	
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	
	public Date getSaida() {
		return saida;
	}
	
	public void setVagaGaragem(boolean vagaGaragem) {
		this.vagaGaragem = vagaGaragem;
	}
	
	public boolean getVagaGaragem() {
		return vagaGaragem;
	}
	
}
