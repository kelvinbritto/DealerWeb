var botaoFlop = document.querySelector("#flop-botao");
var botaoTurn = document.querySelector("#turn-botao");
var botaoRiver = document.querySelector("#river-botao");
var botaoResultado = document.querySelector("#resultado-botao");
var botaoNovoJogo = document.querySelector("#novo-jogo");
var trTabelaResultado = document.querySelector("#trCartas");

var xhr = new XMLHttpRequest();

var flop = false;
var turn = false;
var river = false;

var cartasComunitarias = [];


botaoFlop.addEventListener("click", function () {

    if (flop) {
        return;
    }

    xhr.open("GET", "http://localhost:8080/mesa/flop");
    xhr.withCredentials = true;

    xhr.addEventListener("load", function () {
        flop = true;
        var resposta = xhr.responseText;
        var cartas = JSON.parse(resposta);
        cartasComunitarias.length = 0;
        
        cartas.forEach(function (carta) {
        cartasComunitarias.push(carta);
        });
        mostraComunitarias();
    });
    xhr.send();
});


botaoTurn.addEventListener("click", function () {

    if(!flop) {
        return;
    }

    if (turn) {
        return;
    }

    xhr.open("GET", "http://localhost:8080/mesa/turn");
    xhr.withCredentials = true;

    xhr.addEventListener("load", function () {
        turn = true;
        var resposta = xhr.responseText;
        var cartas = JSON.parse(resposta);
        cartasComunitarias.length = 0;
        cartas.forEach(function (carta) {
            cartasComunitarias.push(carta);
        });
    });
    xhr.send();

});

botaoRiver.addEventListener("click", function () {

    if(!flop || !turn){
        return;
    }

    if (river) {
        return;
    }

    xhr.open("GET", "http://localhost:8080/mesa/river");
    xhr.withCredentials = true;

    xhr.addEventListener("load", function () {

        river = true;
        var resposta = xhr.responseText;
        var cartas = JSON.parse(resposta);
        cartasComunitarias.length = 0;
        cartas.forEach(function (carta) {
            cartasComunitarias.push(carta);
        });
    });

    xhr.send();

});

botaoNovoJogo.addEventListener("click", function () {

    xhr.open("GET", "http://localhost:8080/mesa/resetajogo");
    xhr.withCredentials = true;

    xhr.addEventListener("load", function () {
        reseta();
    });
    xhr.send();
    
});

function montaTd(dado) {
    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add("carta");
    return td;
}

function mostraComunitarias() {
    var i = 1;
    cartasComunitarias.forEach(function(carta, i){
        i++;
        trocaImagem(carta.id, i);
    });

}

function reseta(){

    trocaImagem(0, 1);
    trocaImagem(0, 2);
    trocaImagem(0, 3);
    trocaImagem(0, 4);
    trocaImagem(0, 5);
    
    flop = false;
    turn = false;
    river = false;

    cartasComunitarias = [];

}

function trocaImagem(id, i) {
    var imagem = document.querySelector('#imagem-carta' + i);
    imagem.classList.add("fadeOut");
    setTimeout(function() {
        imagem.src = 'resources/cartas/' + id + '.png';
        imagem.classList.add("fadeIn");
    },500);
}

function xmlxhr(){
    return xhr;
}

function getcartasComunitarias() {
    return cartasComunitarias;
}