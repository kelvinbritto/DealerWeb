package com.example.DealerWebSpringBoot.models;

import com.example.DealerWebSpringBoot.validadores.Validadora;

public class Teste {

	public static void main(String[] args) {
		Baralho baralho = new Baralho();
		Mesa mesa = new Mesa();
		int i = 0;
		
		while(i < 100000) {
		
		mesa = new Mesa();
		
		Player player = new Player("Kelvin", baralho.AleatoriaCarta(), baralho.AleatoriaCarta());
		Validadora validadora = new Validadora();
		
		mesa.flop();
		mesa.turn();
		mesa.river();
		
		System.out.println(player.getCarta1() + " " + player.getCarta2());
		System.out.println(mesa.getCarta1());
		System.out.println(mesa.getCarta2());
		System.out.println(mesa.getCarta3());
		System.out.println(mesa.getCarta4());
		System.out.println(mesa.getCarta5());
		System.out.println("");
		System.out.println(validadora.valida(player, mesa.getComunitarias()));
		
		i++;
		}
		
	}
}
