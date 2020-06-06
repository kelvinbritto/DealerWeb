package com.example.DealerWebSpringBoot.models;

import java.util.List;

import com.example.DealerWebSpringBoot.validadores.Validadora;

public class Teste {

	public static void main(String[] args) {

		Mesa mesa = new Mesa();

		Validadora validadora = new Validadora();

		Player kelvin = new Player("Kelvin", mesa.selecionaCartaId(3), mesa.selecionaCartaId(4));

		List<Carta> comunitarias = mesa.comunitariasManual(18, 19, 20, 21, 22);

		System.out.println(mesa.getComunitarias());
		System.out.println(kelvin.getCarta1());
		System.out.println(kelvin.getCarta2());

		System.out.println(validadora.valida(kelvin, comunitarias));
		
	}

}
