package com.example.DealerWebSpringBoot.models.form;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class PlayerForm {

	private String nome;
	private Integer carta1;
	private Integer carta2;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCarta1() {
		return carta1;
	}

	public void setCarta1(Integer carta1) {
		this.carta1 = carta1;
	}

	public Integer getCarta2() {
		return carta2;
	}

	public void setCarta2(Integer carta2) {
		this.carta2 = carta2;
	}

	public Player converter(Carta carta1, Carta carta2) {
		return new Player(this.nome, carta1, carta2);
	}

}
