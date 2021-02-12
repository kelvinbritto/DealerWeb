package com.example.DealerWebSpringBoot.models;


public class Carta{
	
	private Integer id;
	private String nome;
    private String numero;
    private String naipe;
    
    
    public Carta(Carta carta) {
    }
    
    public Carta() {	
    }

    public Carta(Integer id, String numero, String naipe) {
    	this.id = id;
    	this.nome = numero + " de " + naipe;
     	this.naipe = naipe;
    	this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
    
    public String getNome(){
    	return this.nome;
    }

    public Integer getId() {
		return id;
	}

	public String toString() {
       return numero + " de " + naipe;
    }

}