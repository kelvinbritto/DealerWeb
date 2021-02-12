var cartas = baralhoCompleto();
var xhr = xmlxhr();

adicionacartas();

function adicionacartas() {

    cartas.forEach(function (item) {
        var i = document.querySelector("#selection1");
        var option = document.createElement("option");
        option.text = item.nome;
        option.value = item.id;
        i.add(option);
    });

    cartas.forEach(function (item) {
        var i = document.querySelector("#selection2");
        var option = document.createElement("option");
        option.text = item.nome;
        option.value = item.id;
        i.add(option);
    });

}


var botaoPronto = document.querySelector("#botao-pronto");
var botaoAuto = document.querySelector("comecar-automatico");

botaoPronto.addEventListener("click", function (event) {
    event.preventDefault();

    var form = document.querySelector("#form-player");
    var player = obtemPlayer(form);

    xhr.open("POST", "http://localhost:8080/mesa/gravar", true)
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.withCredentials = true;

    xhr.addEventListener("load", function () {

        if (xhr.status != 200) {
            removePlayer(player.nome);
        }
    });

    xhr.send(JSON.stringify(player));

    adicionaPlayerTabela(player.nome);

    form.reset();



    //document.querySelector("#mensagens-erro").innerHTML = "";
});



function obtemPlayer(form) {

    var player = {
        nome: form.nome.value,
        carta1: form.carta1.value,
        carta2: form.carta2.value,
    }
    return player;
}


function adicionaPlayerTabela(nome) {

    var tabela = document.querySelector("#player-table");
    var td = document.createElement("td");
    var tr = document.createElement("tr");
    td.classList.add("player-nome");
    tr.classList.add(nome);
    td.textContent = nome;

    tr.appendChild(td);

    tabela.appendChild(tr);
}


function removePlayer(nome) {
    var trPlayer = document.querySelector('.' + nome);
    trPlayer.innerHTML = "";
}


