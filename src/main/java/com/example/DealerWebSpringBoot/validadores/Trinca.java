package com.example.DealerWebSpringBoot.validadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Trinca {
	
	Suporte suporte = new Suporte();
	
	public Boolean temUmaTrinca(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();
		List<Carta> cartasSequencia = new ArrayList<Carta>();

		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());

		cartas.addAll(cartasComunitarias);

		cartas.sort(Comparator.comparing(carta -> suporte.calculaId(carta)));

		Carta carta1 = cartas.get(0);
		Carta carta2 = cartas.get(1);
		Carta carta3 = cartas.get(2);

		if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
				&& carta1.getNumero() == carta3.getNumero()) {
			cartasSequencia.add(carta1);
			cartasSequencia.add(carta2);
			cartasSequencia.add(carta3);
			if (cartasSequencia.contains(player.getCarta1()) || cartasSequencia.contains(player.getCarta2())) {
				return true;
			}
		} else {
			carta1 = cartas.get(1);
			carta2 = cartas.get(2);
			carta3 = cartas.get(3);
			if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
					&& carta1.getNumero() == carta3.getNumero()) {
				cartasSequencia.add(carta1);
				cartasSequencia.add(carta2);
				cartasSequencia.add(carta3);
				if (cartasSequencia.contains(player.getCarta1()) || cartasSequencia.contains(player.getCarta2())) {
					return true;
				}
			} else {
				carta1 = cartas.get(2);
				carta2 = cartas.get(3);
				carta3 = cartas.get(4);
				if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
						&& carta1.getNumero() == carta3.getNumero()) {
					cartasSequencia.add(carta1);
					cartasSequencia.add(carta2);
					cartasSequencia.add(carta3);
					if (cartasSequencia.contains(player.getCarta1()) || cartasSequencia.contains(player.getCarta2())) {
						return true;
					}
				} else {
					carta1 = cartas.get(3);
					carta2 = cartas.get(4);
					carta3 = cartas.get(5);
					if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
							&& carta1.getNumero() == carta3.getNumero()) {
						cartasSequencia.add(carta1);
						cartasSequencia.add(carta2);
						cartasSequencia.add(carta3);
						if (cartasSequencia.contains(player.getCarta1())
								|| cartasSequencia.contains(player.getCarta2())) {
							return true;
						}
					} else {
						carta1 = cartas.get(4);
						carta2 = cartas.get(5);
						carta3 = cartas.get(6);
						if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
								&& carta1.getNumero() == carta3.getNumero()) {
							cartasSequencia.add(carta1);
							cartasSequencia.add(carta2);
							cartasSequencia.add(carta3);
							if (cartasSequencia.contains(player.getCarta1())
									|| cartasSequencia.contains(player.getCarta2())) {
								return true;
							}
						} else {
							return false;
						}

					}
				}
			}
		}
		return false;
	}

	public List<Carta> achaTrinca(Player player, List<Carta> cartasComunitarias) {

		List<Carta> cartas = new ArrayList<Carta>();
		List<Carta> cartasSequencia = new ArrayList<Carta>();

		cartas.add(player.getCarta1());
		cartas.add(player.getCarta2());

		cartas.addAll(cartasComunitarias);

		cartas.sort(Comparator.comparing(carta -> suporte.calculaId(carta)));

		Carta carta1 = cartas.get(0);
		Carta carta2 = cartas.get(1);
		Carta carta3 = cartas.get(2);

		if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
				&& carta1.getNumero() == carta3.getNumero()) {
			cartasSequencia.add(carta1);
			cartasSequencia.add(carta2);
			cartasSequencia.add(carta3);
			if (cartasSequencia.contains(player.getCarta1()) || cartasSequencia.contains(player.getCarta2())) {
				return cartasSequencia;
			}
		} else {
			carta1 = cartas.get(1);
			carta2 = cartas.get(2);
			carta3 = cartas.get(3);
			if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
					&& carta1.getNumero() == carta3.getNumero()) {
				cartasSequencia.add(carta1);
				cartasSequencia.add(carta2);
				cartasSequencia.add(carta3);
				if (cartasSequencia.contains(player.getCarta1()) || cartasSequencia.contains(player.getCarta2())) {
					return cartasSequencia;
				}
			} else {
				carta1 = cartas.get(2);
				carta2 = cartas.get(3);
				carta3 = cartas.get(4);
				if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
						&& carta1.getNumero() == carta3.getNumero()) {
					cartasSequencia.add(carta1);
					cartasSequencia.add(carta2);
					cartasSequencia.add(carta3);
					if (cartasSequencia.contains(player.getCarta1()) || cartasSequencia.contains(player.getCarta2())) {
						return cartasSequencia;
					}
				} else {
					carta1 = cartas.get(3);
					carta2 = cartas.get(4);
					carta3 = cartas.get(5);
					if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
							&& carta1.getNumero() == carta3.getNumero()) {
						cartasSequencia.add(carta1);
						cartasSequencia.add(carta2);
						cartasSequencia.add(carta3);
						if (cartasSequencia.contains(player.getCarta1())
								|| cartasSequencia.contains(player.getCarta2())) {
							return cartasSequencia;
						}
					} else {
						carta1 = cartas.get(4);
						carta2 = cartas.get(5);
						carta3 = cartas.get(6);
						if (carta1.getNumero() == carta2.getNumero() && carta2.getNumero() == carta3.getNumero()
								&& carta1.getNumero() == carta3.getNumero()) {
							cartasSequencia.add(carta1);
							cartasSequencia.add(carta2);
							cartasSequencia.add(carta3);
							if (cartasSequencia.contains(player.getCarta1())
									|| cartasSequencia.contains(player.getCarta2())) {
								return cartasSequencia;
							}
						} else {
							return null;
						}

					}
				}
			}
		}
		return null;
	}
}
