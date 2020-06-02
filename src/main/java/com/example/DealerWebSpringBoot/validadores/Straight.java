package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Straight {

	Suporte suporte = new Suporte();

	public Boolean ehUmaSequencia(Player player, List<Carta> cartasComunitarias) {
		List<Carta> cartas = new ArrayList<Carta>();

		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());
		cartas.addAll(cartasComunitarias);

		cartas.sort(Comparator.comparing(c -> suporte.calculaId(c)));

		Carta card1 = cartas.get(0);
		Carta card2 = cartas.get(1);
		Carta card3 = cartas.get(2);
		Carta card4 = cartas.get(3);
		Carta card5 = cartas.get(4);
		Carta card6 = cartas.get(5);
		Carta card7 = cartas.get(6);

		Integer carta1 = suporte.calculaId(cartas.get(0));
		Integer carta2 = suporte.calculaId(cartas.get(1));
		Integer carta3 = suporte.calculaId(cartas.get(2));
		Integer carta4 = suporte.calculaId(cartas.get(3));
		Integer carta5 = suporte.calculaId(cartas.get(4));
		Integer carta6 = suporte.calculaId(cartas.get(5));
		Integer carta7 = suporte.calculaId(cartas.get(6));

		if ((carta1 + 1) == carta2 && ((carta2 + 1) == carta3) && ((carta3 + 1) == carta4 && (carta4 + 1) == carta5)) {
			if (suporte.temCartaPlayer(player, card1, card2, card3, card4, card5)) {
				return true;
			}
		} else {
			if ((carta2 + 1) == carta3 && ((carta3 + 1) == carta4)
					&& ((carta4 + 1) == carta5 && (carta5 + 1) == carta6)) {
				if (suporte.temCartaPlayer(player, card2, card3, card4, card5, card6)) {
					return true;
				}
			} else {
				if ((carta3 + 1) == carta4 && ((carta4 + 1) == carta5)
						&& ((carta5 + 1) == carta6 && (carta6 + 1) == carta7)) {
					if (suporte.temCartaPlayer(player, card3, card4, card5, card6, card7)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
