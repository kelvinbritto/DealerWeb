package com.example.DealerWebSpringBoot.models;

public class Teste {

	public static void main(String[] args) {

		
		Baralho baralho = new Baralho();
		
		int i = 0;
		while(i < 53) {
			System.out.println("Carta: " + baralho.cartaAleatoria());
			
		}
		
	}
}
