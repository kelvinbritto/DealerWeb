package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Royal {
	Suporte suporte = new Suporte();

	public boolean temUmRoyal(Player player, List<Carta> cartasComunitarias) {
		
		Straight sequencia = new Straight();
		
		if (sequencia.ehUmaSequencia(player, cartasComunitarias) == false) {
			return false;
		}

		List<Carta> cards = new ArrayList<Carta>();
		List<Carta> cardsSequencia = new ArrayList<Carta>();

		cards.add(player.getCarta1());
		cards.add(player.getCarta2());

		for (Carta carta : cartasComunitarias) {
			cards.add(carta);
		}

		cards.sort(Comparator.comparing(c -> suporte.calculaId(c)));

		Boolean card10 = false;
		Boolean cardJ = false;
		Boolean cardQ = false;
		Boolean cardK = false;
		Boolean cardA = false;

		for (Carta carta : cards) {

			switch (suporte.calculaId(carta)) {
			case 10:
				card10 = true;
				cardsSequencia.add(carta);
				break;
			case 11:
				cardJ = true;
				cardsSequencia.add(carta);
				break;

			case 12:
				cardQ = true;
				cardsSequencia.add(carta);
				break;

			case 13:
				cardK = true;
				cardsSequencia.add(carta);
				break;
			case 14:
				cardA = true;
				cardsSequencia.add(carta);
				break;
			}

		}

		if (card10 == true & cardJ == true & cardQ == true & cardK == true & cardA == true) {

			cardsSequencia.sort(Comparator.comparing(c -> c.getId()));

			if (cardsSequencia.size() == 5) {

				Carta carta10 = cardsSequencia.get(0);
				Carta cartaJ = cardsSequencia.get(1);
				Carta cartaQ = cardsSequencia.get(2);
				Carta cartaK = cardsSequencia.get(3);
				Carta cartaA = cardsSequencia.get(4);

				if (carta10.getNaipe() == cartaJ.getNaipe() && cartaJ.getNaipe() == cartaQ.getNaipe()
						&& cartaQ.getNaipe() == cartaK.getNaipe() && cartaK.getNaipe() == cartaA.getNaipe()) {
					return true;
				}
			} else {

				Carta carta1 = cardsSequencia.get(0);
				Carta carta2 = cardsSequencia.get(1);
				Carta carta3 = cardsSequencia.get(2);
				Carta carta4 = cardsSequencia.get(3);
				Carta carta5 = cardsSequencia.get(4);

				if (carta1.getNumero() == "10") {
					if (carta1.getNaipe() == carta2.getNaipe() && carta2.getNaipe() == carta3.getNaipe()
							&& carta3.getNaipe() == carta4.getNaipe() && carta4.getNaipe() == carta5.getNaipe()) {
						return true;
					} else {
						try {
							carta1 = cardsSequencia.get(0 + 1);
							carta2 = cardsSequencia.get(1 + 1);
							carta3 = cardsSequencia.get(2 + 1);
							carta4 = cardsSequencia.get(3 + 1);
							carta5 = cardsSequencia.get(4 + 1);
							if (carta1.getNaipe() == carta2.getNaipe() && carta2.getNaipe() == carta3.getNaipe()
									&& carta3.getNaipe() == carta4.getNaipe()
									&& carta4.getNaipe() == carta5.getNaipe()) {
								return true;
							} else {
								carta1 = cardsSequencia.get(0 + 2);
								carta2 = cardsSequencia.get(1 + 2);
								carta3 = cardsSequencia.get(2 + 2);
								carta4 = cardsSequencia.get(3 + 2);
								carta5 = cardsSequencia.get(4 + 2);
								if (carta1.getNaipe() == carta2.getNaipe() && carta2.getNaipe() == carta3.getNaipe()
										&& carta3.getNaipe() == carta4.getNaipe()
										&& carta4.getNaipe() == carta5.getNaipe()) {
									return true;
								}
							}
						} catch (Exception e) {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
}
