function deletaEstacionamento() {
    var ajax = new XMLHttpRequest();
    var URL = "resources/saida";
    var vagaNum = document.getElementsByClassName('vagaNumeroSaida')[0].value;
    
    ajax.open("POST", URL, true);
    ajax.setRequestHeader("Content-type", "application/json");
    var jsonStringfy = JSON.stringify({numero: vagaNum})
    console.log("jsonStringfy:", jsonStringfy);
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
    var dadosDeRegistro = document.getElementById('registerData');
    dadosDeRegistro.innerHTML = '';
    
    dadosDoEstacionamento = JSON.parse(dadosDoEstacionamento);

    for (var i = 0; i < dadosDoEstacionamento.length; i++) {
        var tempo = dadosDoEstacionamento[i].tempo;
        var valor = dadosDoEstacionamento[i].valor;
        dadosDeRegistro.innerHTML += '<div>'+
                                '<hr></hr>' +
                                 '<p>ID: ' + tempo + '</p>'+
                                '<p>Numero: ' + valor + '</p>'+
                              '</div>';
    }
}