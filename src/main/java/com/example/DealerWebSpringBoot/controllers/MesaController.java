package com.example.DealerWebSpringBoot.controllers;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Mesa;
import com.example.DealerWebSpringBoot.models.Player;
import com.example.DealerWebSpringBoot.models.form.ComunitariasForm;
import com.example.DealerWebSpringBoot.models.form.PlayerForm;

@RequestMapping("/mesa")
@RestController
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class MesaController {

	private Mesa mesa = new Mesa();

	@RequestMapping("/flop")
	public ResponseEntity<List<Carta>> flop() {
		
		ResponseEntity<List<Carta>> cartasComunitarias = mesa.flop();
		return cartasComunitarias;
	
	}

	@RequestMapping("/turn")
	public ResponseEntity<List<Carta>> turn() {
		ResponseEntity<List<Carta>> cartasComunitarias = mesa.turn();
		return cartasComunitarias;
	}

	@RequestMapping("/river")
	public ResponseEntity<List<Carta>> river() {
		ResponseEntity<List<Carta>> cartasComunitarias = mesa.river();
		
		return cartasComunitarias;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/resultado")
	public ResponseEntity<List<List>> resultado() {
		
		
		if (mesa.getValidaEntregaResultado()) {

			List<List> listas = mesa.geraResultado();
			
			return ResponseEntity.ok(listas);
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public ResponseEntity<String> gravar(@RequestBody PlayerForm form, UriComponentsBuilder uriBuilder) {
		
		Carta cartaEscolida1 = mesa.selecionaCartaId(form.getCarta1());
		Carta cartaEscolida2 = mesa.selecionaCartaId(form.getCarta2());

		if (mesa.testaIguais(cartaEscolida1, cartaEscolida2) || cartaEscolida1 == null || cartaEscolida2 == null) {
			return ResponseEntity.badRequest().body("Dados Inválidos");
		}

		mesa.removeCarta(cartaEscolida1);
		mesa.removeCarta(cartaEscolida2);

		Player player = form.converter(cartaEscolida1, cartaEscolida2);
		mesa.gravarPlayer(player);
		
		return ResponseEntity.ok(player.getNome());
	}

	@RequestMapping(value = "/gravarcomunitarias", method = RequestMethod.POST)
	public ResponseEntity<List<Carta>> selecionaComunitarias(@RequestBody ComunitariasForm form) {

		if (mesa.comunitariasManual(form.getCarta1(), form.getCarta2(), form.getCarta3(), form.getCarta4(),
				form.getCarta5()) != null) {
			return ResponseEntity.ok(mesa.getComunitarias());
		}
		return ResponseEntity.badRequest().build();
	}
 
	@RequestMapping("/resetajogo")
	public ResponseEntity<String> resetajogo() {
		this.mesa = new Mesa();
		return ResponseEntity.ok("Baralho Resetado");
	}
	
	@RequestMapping("/baralhocompleto")
	public ResponseEntity<List<Carta>> cartas(){
		return ResponseEntity.ok(mesa.listarBaralhoCompleto());
	}

}
