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
			return "Royal Flush : (10)";
		}
		if(straightFlush.temUmStraightFlush(player, cartasComunitarias)) {
			return "Straight Flush : (9)";
		}
		if(fourOfAKind.temUmFourOfAKind(player, cartasComunitarias)) {
			return "Four Of A Kind : (8)";
		}
		if(fullHouse.temUmFullHouse(player, cartasComunitarias)) {
			return "Full House : (7)";
		}
		if(flush.temUmFlush(player, cartasComunitarias)) {
			return "Flush : (6)";
		}
		if(straight.ehUmaSequencia(player, cartasComunitarias)) {
			return "Straight : (5)";
		}
		if(trinca.temUmaTrinca(player, cartasComunitarias)) {
			return "Trinca : (4)";
		}
		if(doisPares.temDoisPares(player, cartasComunitarias)) {
			return "Dois Pares : (3)";
		}
		if(par.temUmPar(player, cartasComunitarias)) {
			return "Um Par : (2) ";
		}
		if(cartaAlta.temUmaCartaAlta(player, cartasComunitarias)) {
			return "Carta Alta : (1)";
		}
		return "Nada! : (0)";
	}

}
