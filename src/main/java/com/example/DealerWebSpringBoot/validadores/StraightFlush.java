package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class StraightFlush {

	Suporte suporte = new Suporte();

	public Boolean temUmStraightFlush(Player player, List<Carta> cartasComunitarias) {
		List<Carta> cartas = new ArrayList<Carta>();
		List<Carta> cartasSequencia = new ArrayList<Carta>();

		Straight sequencia = new Straight();

		if (sequencia.ehUmaSequencia(player, cartasComunitarias) == false) {
			return false;
		}

		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());
		cartas.addAll(cartasComunitarias);

		cartas.sort(Comparator.comparing(c -> suporte.calculaId(c)));

		Integer carta1 = suporte.calculaId(cartas.get(0));
		Integer carta2 = suporte.calculaId(cartas.get(1));
		Integer carta3 = suporte.calculaId(cartas.get(2));
		Integer carta4 = suporte.calculaId(cartas.get(3));
		Integer carta5 = suporte.calculaId(cartas.get(4));
		Integer carta6 = suporte.calculaId(cartas.get(5));
		Integer carta7 = suporte.calculaId(cartas.get(6));

		Boolean v1 = ((carta1 + 1) == carta2);
		if (v1) {
			cartasSequencia.add(cartas.get(0));
			cartasSequencia.add(cartas.get(1));
		}

		Boolean v2 = ((carta2 + 1) == carta3);
		if (v2) {
			if (cartasSequencia.contains(cartas.get(1))) {
				cartasSequencia.add(cartas.get(2));
			} else {
				cartasSequencia.add(cartas.get(1));
				cartasSequencia.add(cartas.get(2));
			}
		}

		Boolean v3 = ((carta3 + 1) == carta4);
		if (v3) {
			if (cartasSequencia.contains(cartas.get(2))) {
				cartasSequencia.add(cartas.get(3));
			} else {
				cartasSequencia.add(cartas.get(2));
				cartasSequencia.add(cartas.get(3));
			}
		}

		Boolean v4 = ((carta4 + 1) == carta5);
		if (v4) {
			if (cartasSequencia.contains(cartas.get(3))) {
				cartasSequencia.add(cartas.get(4));
			} else {
				cartasSequencia.add(cartas.get(3));
				cartasSequencia.add(cartas.get(4));
			}
		}

		Boolean v5 = ((carta5 + 1) == carta6);
		if (v5) {
			if (cartasSequencia.contains(cartas.get(4))) {
				cartasSequencia.add(cartas.get(5));
			} else {
				cartasSequencia.add(cartas.get(4));
				cartasSequencia.add(cartas.get(5));
			}
		}

		Boolean v6 = ((carta6 + 1) == carta7);
		if (v6) {
			if (cartasSequencia.contains(cartas.get(5))) {
				cartasSequencia.add(cartas.get(6));
			} else {
				cartasSequencia.add(cartas.get(5));
				cartasSequencia.add(cartas.get(6));
			}
		}

		try {
			String cart1 = cartasSequencia.get(0).getNaipe();
			String cart2 = cartasSequencia.get(1).getNaipe();
			String cart3 = cartasSequencia.get(2).getNaipe();
			String cart4 = cartasSequencia.get(3).getNaipe();
			String cart5 = cartasSequencia.get(4).getNaipe();

			Integer valorCart1 = suporte.calculaId(cartasSequencia.get(0));
			Integer valorCart2 = suporte.calculaId(cartasSequencia.get(1));
			Integer valorCart3 = suporte.calculaId(cartasSequencia.get(2));
			Integer valorCart4 = suporte.calculaId(cartasSequencia.get(3));
			Integer valorCart5 = suporte.calculaId(cartasSequencia.get(4));

			Carta c1 = cartasSequencia.get(0);
			Carta c2 = cartasSequencia.get(1);
			Carta c3 = cartasSequencia.get(2);
			Carta c4 = cartasSequencia.get(3);
			Carta c5 = cartasSequencia.get(4);

			if (cart1 == cart2 && cart2 == cart3 && cart3 == cart4 && cart4 == cart5 && ((valorCart1 + 1) == valorCart2)
					&& ((valorCart2 + 1) == valorCart3) && ((valorCart3 + 1) == valorCart4)
					&& (valorCart4 + 1) == valorCart5) {
				if (suporte.temCartaPlayer(player, c1, c2, c3, c4, c5)) {
					return true;
				}
			} else {
				cart1 = cartasSequencia.get(1).getNaipe();
				cart2 = cartasSequencia.get(2).getNaipe();
				cart3 = cartasSequencia.get(3).getNaipe();
				cart4 = cartasSequencia.get(4).getNaipe();
				cart5 = cartasSequencia.get(5).getNaipe();

				valorCart1 = suporte.calculaId(cartasSequencia.get(1));
				valorCart2 = suporte.calculaId(cartasSequencia.get(2));
				valorCart3 = suporte.calculaId(cartasSequencia.get(3));
				valorCart4 = suporte.calculaId(cartasSequencia.get(4));
				valorCart5 = suporte.calculaId(cartasSequencia.get(5));

				c1 = cartasSequencia.get(1);
				c2 = cartasSequencia.get(2);
				c3 = cartasSequencia.get(3);
				c4 = cartasSequencia.get(4);
				c5 = cartasSequencia.get(5);

				if (cart1 == cart2 && cart2 == cart3 && cart3 == cart4 && cart4 == cart5
						&& ((valorCart1 + 1) == valorCart2) && ((valorCart2 + 1) == valorCart3)
						&& ((valorCart3 + 1) == valorCart4) && (valorCart4 + 1) == valorCart5) {
					if (suporte.temCartaPlayer(player, c1, c2, c3, c4, c5)) {
						return true;
					}
				} else {
					cart1 = cartasSequencia.get(2).getNaipe();
					cart2 = cartasSequencia.get(3).getNaipe();
					cart3 = cartasSequencia.get(4).getNaipe();
					cart4 = cartasSequencia.get(5).getNaipe();
					cart5 = cartasSequencia.get(6).getNaipe();

					valorCart1 = suporte.calculaId(cartasSequencia.get(2));
					valorCart2 = suporte.calculaId(cartasSequencia.get(3));
					valorCart3 = suporte.calculaId(cartasSequencia.get(4));
					valorCart4 = suporte.calculaId(cartasSequencia.get(5));
					valorCart5 = suporte.calculaId(cartasSequencia.get(6));

					c1 = cartasSequencia.get(2);
					c2 = cartasSequencia.get(3);
					c3 = cartasSequencia.get(4);
					c4 = cartasSequencia.get(5);
					c5 = cartasSequencia.get(6);

					if (cart1 == cart2 && cart2 == cart3 && cart3 == cart4 && cart4 == cart5
							&& ((valorCart1 + 1) == valorCart2) && ((valorCart2 + 1) == valorCart3)
							&& ((valorCart3 + 1) == valorCart4) && (valorCart4 + 1) == valorCart5) {
						if (suporte.temCartaPlayer(player, c1, c2, c3, c4, c5)) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
