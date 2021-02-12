package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class DoisPares {

	public Boolean temDoisPares(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();

		cartas.addAll(cartasComunitarias);
		
		int i = 5;
		
		for (Carta carta : cartas) {
			if(carta.getNumero() == player.getCarta1().getNumero()) {
				i--;
			}
		}
		
		if(i == 5) {
			return false;
		}
		
		for (Carta carta : cartas) {
			if(carta.getNumero() == player.getCarta2().getNumero()) {
				return true;
			}
		}
		return false;
	}

}
