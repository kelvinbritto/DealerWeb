package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class FourOfAKind {

	public Boolean temUmFourOfAKind(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();

		Carta carta1 = cartasComunitarias.get(0);
		Carta carta2 = cartasComunitarias.get(1);
		Carta carta3 = cartasComunitarias.get(2);
		Carta carta4 = cartasComunitarias.get(3);
		Carta carta5 = cartasComunitarias.get(4);

		for (Carta carta : cartasComunitarias) {
			if ((carta.getNumero() == carta1.getNumero() && carta.getId() != carta1.getId())
					|| (carta.getNumero() == carta2.getNumero() && carta.getId() != carta2.getId())
					|| (carta.getNumero() == carta3.getNumero() && carta.getId() != carta3.getId())
					|| (carta.getNumero() == carta4.getNumero() && carta.getId() != carta4.getId())
					|| (carta.getNumero() == carta5.getNumero() && carta.getId() != carta5.getId())) {

				cartas.add(carta);
			}
		}

		if (cartas.size() == 4 || cartas.size() == 0) {
			return false;
		} else {
			if (cartas.size() == 3) {

				if (cartas.get(1).getNumero() == player.getCarta1().getNumero()
						|| cartas.get(1).getNumero() == player.getCarta2().getNumero()) {
					return true;
				}
			} else {
				if (cartas.size() == 2) {
					if (cartas.get(1).getNumero() == player.getCarta1().getNumero()
							&& cartas.get(1).getNumero() == player.getCarta2().getNumero()) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
