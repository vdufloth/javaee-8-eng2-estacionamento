document.addEventListener('DOMContentLoaded', function() {
    fetchVagas();
    criaVaga();
}, false);

function montaLista(vagas) {
    var vagasList = document.getElementById('vagasList');
    vagasList.innerHTML = '';
    
    vagas = JSON.parse(vagas);

    for (var i = 0; i < vagas.length; i++) {
        var id = vagas[i].id;
        var numero = vagas[i].numero;
        var desc = vagas[i].descricao;
        var placa = vagas[i].placa;
        vagasList.innerHTML += '<div>'+
                             '<hr></hr>' +
                              '<p>ID: ' + id + '</p>'+
                             '<p>Numero: ' + numero + '</p>'+
                             '<p>Descricao: ' + desc + '</p>'+
                             '<p>Placa: ' + placa + '</p>'+
                           '</div>';
    }
}

function fetchVagas() {
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "resources/vaga", true);
    ajax.send();
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            montaLista(data);
	}
    }
    
}

function criaVaga() {
    var ajax = new XMLHttpRequest();
    var URL = "resources/vaga";
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
