package com.example.DealerWebSpringBoot.models;

public class Player {

	private String nome;
	private Carta carta1;
	private Carta carta2;
	private String resultado;
	
	public Player() {

	}

	public Player(String nome, Carta carta1, Carta carta2) {
		this.nome = nome;
		this.carta1 = carta1;
		this.carta2 = carta2;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	@Override
//	public String toString() {
//		
//		return "Jogador " + this.nome + " Carta1 = " + this.carta1.getNome() + " e " + 
//				"Carta2 = " + this.carta2.getNome();
//	}

	public String getNome() {
		return nome;
	}
	
	public Carta getCarta1() {
		return carta1;
	}

	public Carta getCarta2() {
		return carta2;
	}
	
	public String getResultado() {
		return resultado;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
