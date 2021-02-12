package com.example.DealerWebSpringBoot.validadores;

import java.util.List;

import com.example.DealerWebSpringBoot.models.Carta;
import com.example.DealerWebSpringBoot.models.Player;

public class Validadora {

	Royal royal = new Royal();
	StraightFlush straightFlush = new StraightFlush();
	FourOfAKind fourOfAKind = new FourOfAKind();
	FullHouse fullHouse = new FullHouse();
	Flush flush = new Flush();
	Straight straight = new Straight();
	Trinca trinca = new Trinca();
	DoisPares doisPares = new DoisPares();
	Par par = new Par();
	CartaAlta cartaAlta = new CartaAlta();

	public String valida(Player player, List<Carta> cartasComunitarias) {
		
		if(royal.temUmRoyal(player, cartasComunitarias)) {
			return "Royal Flush";
		}
		if(straightFlush.temUmStraightFlush(player, cartasComunitarias)) {
			return "Straight Flush";
		}
		if(fourOfAKind.temUmFourOfAKind(player, cartasComunitarias)) {
			return "Four Of A Kind";
		}
		if(fullHouse.temUmFullHouse(player, cartasComunitarias)) {
			return "Full House";
		}
		if(flush.temUmFlush(player, cartasComunitarias)) {
			return "Flush";
		}
		if(straight.ehUmaSequencia(player, cartasComunitarias)) {
			return "Straight";
		}
		if(trinca.temUmaTrinca(player, cartasComunitarias)) {
			return "Trinca";
		}
		if(doisPares.temDoisPares(player, cartasComunitarias)) {
			return "Dois Pares";
		}
		if(par.temUmPar(player, cartasComunitarias)) {
			return "Um Par";
		}
		if(cartaAlta.temUmaCartaAlta(player, cartasComunitarias)) {
			return "Carta Alta";
		}
		return "Nada!";
	}

}
