package com.example.DealerWebSpringBoot.validadores;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Suporte {

	public String getNaipeCarta(Carta carta) {
		return carta.getNaipe();
	}

	public Boolean temCartaPlayer(Player player, Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {

		if (carta1 == player.getCarta1() || carta2 == player.getCarta1() || carta3 == player.getCarta1()
				|| carta4 == player.getCarta1() || carta5 == player.getCarta1()) {
			return true;
		} else {
			if (carta1 == player.getCarta2() || carta2 == player.getCarta2() || carta3 == player.getCarta2()
					|| carta4 == player.getCarta2() || carta5 == player.getCarta2()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Integer calculaId(Carta carta) {

		Integer i = carta.getId();

		while (i > 1) {
			i -= 13;
		}
		i += 13;
		return i;
	}

	public Boolean testaIguais(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {

		String[] nome = { carta1.getNaipe(), carta2.getNaipe(), carta3.getNaipe(), carta4.getNaipe(),
				carta5.getNaipe() };

		String primeiroElemento = carta1.getNaipe();
		boolean tudoIgual = true;

		for (int i = 0; i < nome.length; i++) {
			if (i == 0) {
				primeiroElemento = nome[i];
			}
			if (!nome[i].equals(primeiroElemento)) {
				tudoIgual = false;
			}
		}

		if (tudoIgual) {
			return true;
		} else {
			return false;
		}
	}
}
