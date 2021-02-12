package com.example.DealerWebSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.DealerWebSpringBoot.validadores.Validadora;

public class Mesa {

	private boolean flop = false;
	private boolean turn = false;
	private boolean river = false;
	private boolean resultado = false;

	private List<Player> jogadores = new ArrayList<Player>();

	private List<Carta> cartasComunitarias = new ArrayList<Carta>();
	
	private List<List> resultadoLista = new ArrayList<List>();

	private Baralho baralho = new Baralho();

	public List<Carta> comunitariasManual(Integer cartaId1, Integer cartaId2, Integer cartaId3, Integer cartaId4,
			Integer cartaId5) {

		Carta carta1 = selecionaCartaId(cartaId1);
		Carta carta2 = selecionaCartaId(cartaId2);
		Carta carta3 = selecionaCartaId(cartaId3);
		Carta carta4 = selecionaCartaId(cartaId4);
		Carta carta5 = selecionaCartaId(cartaId5);

		if (baralho.listaBaralho().contains(carta1) && baralho.listaBaralho().contains(carta2)
				&& baralho.listaBaralho().contains(carta3) && baralho.listaBaralho().contains(carta4)
				&& baralho.listaBaralho().contains(carta5)) {
			cartasComunitarias.add(carta1);
			cartasComunitarias.add(carta2);
			cartasComunitarias.add(carta3);
			cartasComunitarias.add(carta4);
			cartasComunitarias.add(carta5);
			baralho.removeCarta(carta1);
			baralho.removeCarta(carta2);
			baralho.removeCarta(carta3);
			baralho.removeCarta(carta4);
			baralho.removeCarta(carta5);

			flop = true;
			turn = true;
			river = true;

			return getComunitarias();
		}
		return null;
	}

	public ResponseEntity<List<Carta>> flop() {

//		if (jogadores.size() == 0) {
//			return ResponseEntity.badRequest().build();
//		}

		if (flop) {
			return ResponseEntity.ok(getComunitarias());
		}

		cartasComunitarias.add(baralho.cartaAleatoria());
		cartasComunitarias.add(baralho.cartaAleatoria());
		cartasComunitarias.add(baralho.cartaAleatoria());
		flop = true;

		return ResponseEntity.ok(getComunitarias());
	}

	public ResponseEntity<List<Carta>> turn() {

//		if (jogadores.size() == 0) {
//			return ResponseEntity.badRequest().build();
//		}

		if (turn) {
			return ResponseEntity.ok(getComunitarias());
		}
		cartasComunitarias.add(baralho.cartaAleatoria());
		turn = true;

		return ResponseEntity.ok(getComunitarias());
	}

	public ResponseEntity<List<Carta>> river() {

//		if (jogadores.size() == 0) {
//			return ResponseEntity.badRequest().build();
//		}

		if (river) {
			return ResponseEntity.ok(getComunitarias());
		}
		cartasComunitarias.add(baralho.cartaAleatoria());
		river = true;

		return ResponseEntity.ok(getComunitarias());
	}

	public List<List> geraResultado() {
			
		if(resultado == false) {
			
			resultado = true;
			
			jogadores.forEach(player -> player.setResultado(new Validadora().valida(player, cartasComunitarias)));
			
			resultadoLista.add(this.cartasComunitarias);
			resultadoLista.add(this.jogadores);			
			
			return resultadoLista;
		}
		
		return resultadoLista;
	}

	public void gravarPlayer(Player player) {
		jogadores.add(player);
	}

	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.addAll(jogadores);
		return players;
	}

	public boolean getValidaEntregaResultado() {
		if (flop && turn && river && jogadores.size() > 0) {
			return true;
		}
		return false;
	}

	public List<Carta> getComunitarias() {
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.addAll(cartasComunitarias);
		return cartas;
	}

	public List<Carta> listarBaralhoCompleto() {
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

	public Carta cartaAleatoria() {
		return baralho.cartaAleatoria();
	}

	public Carta selecionaCartaNome(String numero, String naipe) {
		return baralho.selecionaCarta(numero, naipe);
	}

}
