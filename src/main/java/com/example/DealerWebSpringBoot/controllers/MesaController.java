package com.example.DealerWebSpringBoot.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Mesa;
import com.example.DealerWebSpringBoot.models.Player;

@RequestMapping("/mesa")
@Controller
public class MesaController {

	private Mesa mesa = new Mesa();

	@GetMapping
	public ModelAndView mesa() {
		ModelAndView modelAndView = new ModelAndView("mesa");
		modelAndView.addObject("flop", null);
		return modelAndView;
	}

	@RequestMapping("/flop")
	public ModelAndView flop() {
		ModelAndView modelAndView = new ModelAndView("mesa");
		List<Carta> cartasComunitarias = mesa.flop();
		modelAndView.addObject("cartasComunitarias", cartasComunitarias);

		return modelAndView;
	}

	@RequestMapping("/turn")
	public ModelAndView turn() {

		ModelAndView modelAndView = new ModelAndView("mesa");

		List<Carta> cartasComunitarias = mesa.turn();
		modelAndView.addObject("cartasComunitarias", cartasComunitarias);

		return modelAndView;

	}

	@RequestMapping("/river")
	public ModelAndView river() {
		ModelAndView modelAndView = new ModelAndView("mesa");
		List<Carta> cartasComunitarias = mesa.river();
		modelAndView.addObject("cartasComunitarias", cartasComunitarias);

		return modelAndView;
	}

	@RequestMapping("/resultado")
	public ModelAndView resultado() {

		if (mesa.getValidaEntregaResultado()) {
			
			ModelAndView modelAndView = new ModelAndView("resultado");

			mesa.geraResultado();
			List<Carta> cartasComunitarias = mesa.river();
			List<Player> jogadores = mesa.getPlayers();

			modelAndView.addObject("cartasComunitarias", cartasComunitarias);
			modelAndView.addObject("players", jogadores);

			return modelAndView;
		}

		return new ModelAndView("redirect:/mesa/flop");
	}

	@RequestMapping("/formulario")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("/formularioescolhacartas");
		List<Carta> cartasBaralho = mesa.listarBaralho();
		modelAndView.addObject("cartasBaralho", cartasBaralho);
		modelAndView.addObject("jogadores", mesa.getPlayers());
		return modelAndView;
	}

	@RequestMapping(value = "/grava", method = RequestMethod.POST)
	public ModelAndView grava(String nome, Integer carta1, Integer carta2) {

		Carta cartaEscolida1 = mesa.selecionaCartaId(carta1);
		Carta cartaEscolida2 = mesa.selecionaCartaId(carta2);

		if (mesa.testaIguais(cartaEscolida1, cartaEscolida2) || cartaEscolida1 == null || cartaEscolida2 == null) {
			return new ModelAndView("redirect:/mesa/formulario");
		}

		mesa.removeCarta(cartaEscolida1);
		mesa.removeCarta(cartaEscolida2);

		Player player = new Player(nome, cartaEscolida1, cartaEscolida2);

		mesa.gravarPlayer(player);

		return new ModelAndView("redirect:/mesa/formulario");
	}

	@RequestMapping("/resetajogo")
	public ModelAndView resetajogo() {
		this.mesa = new Mesa();
		return new ModelAndView("redirect:/mesa/formulario");
	}

}
