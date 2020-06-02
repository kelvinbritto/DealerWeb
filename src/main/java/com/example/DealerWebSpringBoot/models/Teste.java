package com.example.DealerWebSpringBoot.models;

import com.example.DealerWebSpringBoot.validadores.Validadora;

public class Teste {

	public static void main(String[] args) {

		boolean valida = false;
		Validadora validadora = new Validadora();
		int i = 0;
		while (valida == false) {

			Mesa mesa = new Mesa();

			Player player = new Player("Kelvin", mesa.aleatoriaCarta(), mesa.aleatoriaCarta());

			mesa.gravarPlayer(player);

			mesa.flop();
			mesa.turn();
			mesa.river();

			if (validadora.valida(player, mesa.getComunitarias()) != "Royal Flush") {
				valida = false;
				i++;
				System.out.println(i);
			} else {

				System.out.println(mesa.getPlayers().get(0).getCarta1().getNome() + " "
						+ mesa.getPlayers().get(0).getCarta2().getNome());

				mesa.getComunitarias().forEach(carta -> System.out.println(carta));
				valida = true;

			}
		}

	}
}
