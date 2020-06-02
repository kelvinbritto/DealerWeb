package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class CartaAlta{

	Suporte suporte = new Suporte();

	public Boolean temUmaCartaAlta(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();

		cartas.addAll(cartasComunitarias);
		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());

		cartas.sort(Comparator.comparing(carta -> suporte.calculaId(carta)));

		if (cartas.get(6) == player.getCarta1() || cartas.get(6) == player.getCarta2()) {
			return true;
		}
		return false;
	}
}
