package com.example.DealerWebSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

import com.example.DealerWebSpringBoot.validadores.Validadora;

public class Mesa {

	private boolean flop = false;
	private boolean turn = false;
	private boolean river = false;

	private List<Player> jogadores = new ArrayList<Player>();
	private List<Carta> cartasComunitarias = new ArrayList<Carta>();
	private Baralho baralho = new Baralho();

	public List<Carta> flop() {

		if (flop) {
			return cartasComunitarias;
		}
		flop = true;
		cartasComunitarias.add(baralho.AleatoriaCarta());
		cartasComunitarias.add(baralho.AleatoriaCarta());
		cartasComunitarias.add(baralho.AleatoriaCarta());

		return cartasComunitarias;
	}

	public List<Carta> turn() {

		if (turn) {
			return cartasComunitarias;
		}
		turn = true;
		cartasComunitarias.add(baralho.AleatoriaCarta());

		return cartasComunitarias;
	}

	public List<Carta> river() {
		if (river) {
			return cartasComunitarias;
		}
		river = true;

		cartasComunitarias.add(baralho.AleatoriaCarta());

		return cartasComunitarias;
	}

	public void geraResultado() {
		Validadora validadora = new Validadora();
		jogadores.forEach(player -> player.setResultado(validadora.valida(player, cartasComunitarias)));
	}

	public Carta getCarta1() {
		return cartasComunitarias.get(0);
	}

	public Carta getCarta2() {
		return cartasComunitarias.get(1);
	}

	public Carta getCarta3() {
		return cartasComunitarias.get(2);
	}

	public Carta getCarta4() {
		return cartasComunitarias.get(3);
	}

	public Carta getCarta5() {
		return cartasComunitarias.get(4);
	}

	public void gravarPlayer(Player player) {
		jogadores.add(player);
	}

	public List<Player> getPlayers() {
		return jogadores;
	}

	public boolean getValidaEntregaResultado() {
		if (flop && turn && river) {
			return true;
		}
		return false;
	}

	public void forcaComunitarias() {
		cartasComunitarias.add(baralho.selecionaCartaId(35));
		cartasComunitarias.add(baralho.selecionaCartaId(6));
		cartasComunitarias.add(baralho.selecionaCartaId(12));
		cartasComunitarias.add(baralho.selecionaCartaId(13));
		cartasComunitarias.add(baralho.selecionaCartaId(50));

		flop = true;
		turn = true;
		river = true;
	}

	public List<Carta> getComunitarias() {
		return cartasComunitarias;
	}
	
	public List<Carta> listarBaralho() {
		return baralho.listaBaralhoFixo();
	}
	
	public Carta selecionaCartaId(Integer cartaId) {
		return baralho.selecionaCartaId(cartaId);
	}
	
	public void removeCarta(Carta carta) {
		baralho.removeCarta(carta);
	}
	
	public Boolean testaIguais(Carta carta1, Carta carta2) {
		return baralho.testaIguais(carta1, carta2);
	}
	
	public Carta aleatoriaCarta() {
		return baralho.AleatoriaCarta();
	}
}
