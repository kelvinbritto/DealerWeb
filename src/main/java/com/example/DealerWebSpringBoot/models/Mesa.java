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
		
		for (Player player : jogadores) {
			player.setResultado(validadora.valida(player, cartasComunitarias));
		}
		
		
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

		turn = true;
		flop = true;
		river = true;
	}

	public List<Carta> getComunitarias() {
		return cartasComunitarias;
	}

}
