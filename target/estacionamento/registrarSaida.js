function deletaEstacionamento() {
    var ajax = new XMLHttpRequest();
    var URL = "resources/saida";
    var vagaNum = document.getElementsByClassName('vagaNumeroSaida')[0].value;
    
    ajax.open("POST", URL, true);
    ajax.setRequestHeader("Content-type", "application/json");
    var jsonStringfy = JSON.stringify({numero: vagaNum});
    ajax.send(jsonStringfy);

    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            console.log(data);
            montaDadosDeRegistro(data);
        }
    }
}
function montaDadosDeRegistro(dadosDoEstacionamento) {
    console.log("entrou");
    var dadosDeRegistro = document.getElementById('registerData');
    dadosDeRegistro.innerHTML = '';
    
    dadosDoEstacionamento = JSON.parse(dadosDoEstacionamento);
    
    for (var i = 0; i < dadosDoEstacionamento.length; i++) {
        var tempo = dadosDoEstacionamento[i].tempo;
        var valor = dadosDoEstacionamento[i].valor;
        dadosDeRegistro.innerHTML += '<div class="itemTarifa">'+
                                        '<hr /> '+
                                        '<p>Tempo total na vaga: '+tempo+' minutos</p> '+
                                        '<p>Valor a ser cobrado: R$ '+valor+'</p> '+
                                        '<a class="optionButton" href="index.html">Confirmar Pagamento</a>' +
                                     '</div>'
    }
}