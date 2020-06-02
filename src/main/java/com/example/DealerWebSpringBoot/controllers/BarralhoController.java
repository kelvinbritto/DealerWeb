package com.example.DealerWebSpringBoot.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.DealerWebSpringBoot.models.Baralho;
import com.example.DealerWebSpringBoot.models.Carta;

@Controller
@RequestMapping("/baralho")
public class BarralhoController {

	private Baralho baralho = new Baralho();

	public ModelAndView listar() {
		List<Carta> cartasNoJogo = baralho.listaBaralho();
		ModelAndView modelAndView = new ModelAndView("listabaralho");
		modelAndView.addObject("cartasNoJogo", cartasNoJogo);

		return modelAndView;
	}

	@RequestMapping("/cartaaleatoria")
	public ModelAndView cartaAleatoria() {

		try {
			Carta carta = baralho.AleatoriaCarta();
			ModelAndView modelAndView = new ModelAndView("cartaaleatoria");
			modelAndView.addObject("cartaAleatoria", carta);
			modelAndView.addObject("quantidadeCartas", baralho.quantidade());
			return modelAndView;
		} catch (Exception e) {
			ModelAndView modelAndView = new ModelAndView("cartaaleatoria");
			modelAndView.addObject("cartaAleatoria", "As Cartas do Baralho acabaram!");

			return modelAndView;
		}

	}

	@RequestMapping("/reseta")
	public ModelAndView resetaBaralho() {
		this.baralho = new Baralho();
		ModelAndView modelAndView = new ModelAndView("cartaaleatoria");
		modelAndView.addObject("cartaAleatoria", "Baralho Resetado");

		return modelAndView;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form() {

		ModelAndView modelAndView = new ModelAndView("formcartas");

		List<Carta> cartasBaralho = baralho.listaBaralho();
		modelAndView.addObject("cartasBaralho", cartasBaralho);

		return modelAndView;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView gravar(String carta) {
		System.out.println("parte 1 - " + carta);
		// baralho.gravaCarta(id);
		return new ModelAndView("redirect:/baralho/cartaaleatoria");
	}

	@RequestMapping("/form/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		Carta carta = baralho.selecionaCartaId(id);
		System.out.println(carta);
		return new ModelAndView("redirect:/baralho/form");

	}

}
