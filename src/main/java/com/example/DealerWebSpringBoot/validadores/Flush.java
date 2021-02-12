package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Flush {
	
	Suporte suporte = new Suporte();

	public Boolean temUmFlush(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();
		List<Carta> cartasSequencia = new ArrayList<Carta>();

		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());
		cartas.addAll(cartasComunitarias);

		cartas.sort(Comparator.comparing(carta -> suporte.getNaipeCarta(carta)));

		Carta carta1 = cartas.get(0);
		Carta carta2 = cartas.get(1);
		Carta carta3 = cartas.get(2);
		Carta carta4 = cartas.get(3);
		Carta carta5 = cartas.get(4);

		if (carta1.getNaipe() == carta2.getNaipe() && carta2.getNaipe() == carta3.getNaipe()
				&& carta3.getNaipe() == carta4.getNaipe() && carta4.getNaipe() == carta5.getNaipe()) {
			cartasSequencia.add(carta1);
			cartasSequencia.add(carta2);
			cartasSequencia.add(carta3);
			cartasSequencia.add(carta4);
			cartasSequencia.add(carta5);
			if (suporte.temCartaPlayer(player, carta1, carta2, carta3, carta4, carta5)) {
				return true;
			}
		} else {
			carta1 = cartas.get(1);
			carta2 = cartas.get(2);
			carta3 = cartas.get(3);
			carta4 = cartas.get(4);
			carta5 = cartas.get(5);
			if (carta1.getNaipe() == carta2.getNaipe() && carta2.getNaipe() == carta3.getNaipe()
					&& carta3.getNaipe() == carta4.getNaipe() && carta4.getNaipe() == carta5.getNaipe()) {
				cartasSequencia.add(carta1);
				cartasSequencia.add(carta2);
				cartasSequencia.add(carta3);
				cartasSequencia.add(carta4);
				cartasSequencia.add(carta5);
				if (suporte.temCartaPlayer(player, carta1, carta2, carta3, carta4, carta5)) {
					return true;
				}
			} else {
				carta1 = cartas.get(2);
				carta2 = cartas.get(3);
				carta3 = cartas.get(4);
				carta4 = cartas.get(5);
				carta5 = cartas.get(6);
				if (carta1.getNaipe() == carta2.getNaipe() && carta2.getNaipe() == carta3.getNaipe()
						&& carta3.getNaipe() == carta4.getNaipe() && carta4.getNaipe() == carta5.getNaipe()) {
					cartasSequencia.add(carta1);
					cartasSequencia.add(carta2);
					cartasSequencia.add(carta3);
					cartasSequencia.add(carta4);
					cartasSequencia.add(carta5);
					if (suporte.temCartaPlayer(player, carta1, carta2, carta3, carta4, carta5)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
