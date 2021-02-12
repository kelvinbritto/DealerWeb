package com.example.DealerWebSpringBoot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.DealerWebSpringBoot.models.Baralho;
import com.example.DealerWebSpringBoot.models.Carta;

@Controller
@RequestMapping("/baralho")
public class BarralhoController {

	private Baralho baralho = new Baralho();
	private Baralho baralhoJson = new Baralho();
	private List<Carta> cartas = new ArrayList<Carta>();

	@RequestMapping("/cartaaleatoria")
	public ModelAndView cartaAleatoria() {
		try {
			Carta carta = baralho.cartaAleatoria();
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

	@RequestMapping("/carta")
	@ResponseBody
	public ResponseEntity<List<Carta>> aleatoria() {
		try {
			cartas.add(baralhoJson.cartaAleatoria());
			return ResponseEntity.ok(cartas);	
		}catch (Exception e) {
			baralhoJson = new Baralho();
			cartas = new ArrayList<Carta>();
		}
		return ResponseEntity.badRequest().body(null);
	}

	@RequestMapping("/reseta")
	public ModelAndView resetaBaralho() {
		this.baralho = new Baralho();
		ModelAndView modelAndView = new ModelAndView("cartaaleatoria");
		modelAndView.addObject("cartaAleatoria", "Baralho Resetado");

		return modelAndView;
	}

}
