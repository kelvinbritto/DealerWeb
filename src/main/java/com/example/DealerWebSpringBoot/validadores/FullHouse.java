package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class FullHouse {

	Suporte suporte = new Suporte();

	public Boolean temUmFullHouse(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();

		Set<Carta> sequencia = new HashSet<Carta>();

		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());

		cartas.addAll(cartasComunitarias);

		cartas.sort(Comparator.comparing(carta -> suporte.calculaId(carta)));

		Trinca three = new Trinca();

		List<Carta> trinca = three.achaTrinca(player, cartasComunitarias);
		if (trinca == null) {
			return false;
		}

		for (Carta carta : trinca) {
			sequencia.add(carta);
		}

		for (Carta carta : cartasComunitarias) {
			if (carta.getNumero() == player.getCarta1().getNumero()) {
				if (trinca.contains(player.getCarta1()) == true) {
					return false;
				} else {
					return true;
				}
			}
			if (carta.getNumero() == player.getCarta2().getNumero()) {
				if (trinca.contains(player.getCarta2()) == true) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}
}
