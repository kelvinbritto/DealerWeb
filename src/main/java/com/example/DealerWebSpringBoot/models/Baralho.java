package com.example.DealerWebSpringBoot.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Baralho {

	private List<Carta> cartas;
	private List<Carta> cartasBaralhoFixo;

	public Baralho() {
		cartas = new ArrayList<>();
		cartasBaralhoFixo = new ArrayList<>();
		iniciarBaralho();
	}

	private void iniciarBaralho() {

		int id = 1;
		String numeros[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String naipe[] = { "Espadas", "Copas", "Ouros", "Paus" };

		for (int nai = 0; nai < naipe.length; nai++) {
			for (int num = 0; num < numeros.length; num++) {
				addCarta(id, numeros[num], naipe[nai]);
				id++;
			}
		}
	}

	public void addCarta(int id, String numero, String naipe) {
		Carta novaCarta = new Carta(id, numero, naipe);
		cartas.add(novaCarta);
		cartasBaralhoFixo.add(novaCarta);
	}

	public void listaBaralhoConsole() {
		cartas.forEach(System.out::println);
	}

	public List<Carta> listaBaralho() {
		List<Carta> c = new ArrayList<Carta>();
		cartas.forEach(carta -> c.add(carta));
		return c;
	}

	public List<Carta> listaBaralhoFixo() {
		List<Carta> c = new ArrayList<Carta>();
		cartasBaralhoFixo.forEach(carta -> c.add(carta));
		return c;
	}

	public List<Integer> listaBaralhoId() {
		List<Integer> c = new ArrayList<Integer>();
		cartas.forEach(carta -> c.add(carta.getId()));
		return c;
	}

	public Carta selecionaCarta(String numero, String naipe) {
		Iterator<Carta> it = cartas.iterator();

		while (it.hasNext()) {
			Carta carta = it.next();

			if (carta.getNumero() == numero && carta.getNaipe() == naipe) {
				Carta card = carta;
				return card;
			}
		}
		return null;
	}

	public Carta selecionaCartaId(Integer id) {
		Iterator<Carta> it = cartas.iterator();
		
		while (it.hasNext()) {
			Carta carta = it.next();

			if (carta.getId() == id) {
				Carta card = carta;
				return card;
			}
		}
		return null;
	}

	public void removeCarta(String numero, String naipe) {
		
		Iterator<Carta> it = cartas.iterator();
		
		while (it.hasNext()) {
			Carta carta = it.next();
			if (carta.getNumero().equals(numero) && carta.getNaipe().equals(naipe)) {
				it.remove();
			}
		}
	}

	public void removeCarta(Carta carta) {
		Iterator<Carta> it = cartas.iterator();
		while (it.hasNext()) {
			Carta c = it.next();
			if (c == carta) {
				it.remove();
			}
		}
	}

	public Carta cartaAleatoria() {
		Random r = new Random();
		int a = r.nextInt(quantidade());
		String numeroCarta = cartas.get(a).getNumero();
		String naipeCarta = cartas.get(a).getNaipe();
		Carta nvc = cartas.get(a);
		removeCarta(numeroCarta, naipeCarta);
		return nvc;
	}

	public int quantidade() {
		return cartas.size();
	}

	public Boolean testaIguais(Carta carta1, Carta carta2) {
		if (carta1 != carta2) {
			return false;
		}
		return true;
	}
}
