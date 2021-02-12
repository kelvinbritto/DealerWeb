var quantidade = 1;


xhr.open("GET", "http://localhost:8080/mesa/resultado");
xhr.withCredentials = true;

xhr.addEventListener("load", function () {
    resultado = JSON.parse(xhr.responseText);
    geraResultado(resultado);
});

xhr.send();



function geraResultado(resultado) {
    trocaImagem(resultado[0][0].id, 1);
    trocaImagem(resultado[0][1].id, 2);
    trocaImagem(resultado[0][2].id, 3);
    trocaImagem(resultado[0][3].id, 4);
    trocaImagem(resultado[0][4].id, 5);

    var i = 0;

    while(i < resultado[1].length){
        montaPlayer(i);
        trocaImagemPlayer(resultado[1][i]["carta1"].id, (quantidade-2));
        trocaImagemPlayer(resultado[1][i]["carta2"].id, (quantidade-1));
        escreveNomeEResultado(i);
        i++;
    }

}


function escreveNomeEResultado(i){
    var tdNome = document.querySelector('.player' + i + 'Nome');
    var tdResultado = document.querySelector('.player' + i + 'Resultado');
    tdNome.textContent = resultado[1][i]["nome"];
    tdResultado.textContent = resultado[1][i]["resultado"];
}


function montaPlayer(numeroPlayer) {

    var tabela = document.querySelector("#tabela-resultado");
    var tr = document.createElement("tr");
    var tdCarta1 = document.createElement("td");
    var tdCarta2 = document.createElement("td");
    var tdNome = document.createElement("td");
    var tdResultado = document.createElement("td");


    tdNome.classList.add('player' + numeroPlayer + 'Nome');
    tdNome.classList.add("resulta");
    tdResultado.classList.add('player' + numeroPlayer + 'Resultado');
    tdResultado.classList.add("resulta");
    tdResultado.classList.add("resulta-color");
    tdCarta1.classList.add('player' + numeroPlayer + 'Carta1');
    tdCarta2.classList.add('player' + numeroPlayer + 'Carta2');

    tdCarta1.innerHTML = '<img src="resources/cartas/0.png" class="imagem-carta" id="imagem-carta-player' + quantidade + '">';
    quantidade++;
    tdCarta2.innerHTML = '<img src="resources/cartas/0.png" class="imagem-carta" id="imagem-carta-player' + quantidade + '">';
    quantidade++;

    tr.classList.add("player-resultado");
    tr.appendChild(tdCarta1);
    tr.appendChild(tdCarta2);
    tr.appendChild(tdNome);
    tr.appendChild(tdResultado);

    tabela.appendChild(tr);
}



function trocaImagemPlayer(id, i) {
    var imagem = document.querySelector('#imagem-carta-player' + i);
    imagem.classList.add("fadeOut");
    setTimeout(function() {
        imagem.src = 'resources/cartas/' + id + '.png';
        imagem.classList.add("fadeIn");
    },500);
}