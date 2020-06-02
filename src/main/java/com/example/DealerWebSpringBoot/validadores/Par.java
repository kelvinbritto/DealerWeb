package com.example.DealerWebSpringBoot.validadores;

import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Par {

	public Boolean temUmPar(Player player, List<Carta> cartasComunitarias) {

		for (Carta carta : cartasComunitarias) {
			if (carta.getNumero() == player.getCarta1().getNumero()
					|| carta.getNumero() == player.getCarta2().getNumero()) {
				return true;
			}
		}
		return false;
	}
}
