package com.example.DealerWebSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.DealerWebSpringBoot.models.Baralho;
import com.example.DealerWebSpringBoot.models.Carta;

@Controller
@RequestMapping("/baralho")
public class BarralhoController {

	private Baralho baralho = new Baralho();

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

}
