package com.example.DealerWebSpringBoot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DealerWebSpringBoot.models.Baralho;
import com.example.DealerWebSpringBoot.models.Carta;

@Controller
@RequestMapping("/baralho")
public class BarralhoController {

	private Baralho baralhoJson = new Baralho();
	private List<Carta> cartas = new ArrayList<Carta>();


	@RequestMapping("/cartaaleatoria")
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


}
