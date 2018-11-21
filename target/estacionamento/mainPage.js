document.addEventListener('DOMContentLoaded', function() {
    fetchAll();
    novo();
}, false);

function montaLista(estacionamento) {
    var vagasList = document.getElementById('vagasList');
    vagasList.innerHTML = '';
    
    estacionamento = JSON.parse(estacionamento);

    for (var i = 0; i < estacionamento.length; i++) {
        var id = estacionamento[i].id;
        var numero = estacionamento[i].numero;
        var desc = estacionamento[i].descricao;
        var placa = estacionamento[i].placa;
        vagasList.innerHTML += '<div>'+
                             '<hr></hr>' +
                              '<p>ID: ' + id + '</p>'+
                             '<p>Numero: ' + numero + '</p>'+
                             '<p>Descricao: ' + desc + '</p>'+
                             '<p>Placa: ' + placa + '</p>'+
                           '</div>';
    }
}

function fetchAll() {
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "resources/estacionamento", true);
    ajax.send();
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            montaLista(data);
	}
    }
    
}

function novo() {
    var ajax = new XMLHttpRequest();
    var URL = "resources/estacionamento";
    //var URL = "localhost:8080/eng2-estacionamento/resources/vaga";
    ajax.open("POST", URL, true);
    ajax.setRequestHeader("Content-type", "application/json");

    ajax.send(JSON.stringify({numero: 123, descricao: "teste", placa: "12345"}));

    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            console.log(data);
        }
    }
}
