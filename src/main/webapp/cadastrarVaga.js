document.addEventListener('DOMContentLoaded', function() {
    fetchVagas();
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
        vagasList.innerHTML += '<div class="itemVaga">'+
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
    var vagaNum = document.getElementsByClassName('vagaNumero')[0].value;
    var vagaDesc = document.getElementsByClassName('vagaDescri')[0].value;
    
    ajax.open("POST", URL, true);
    ajax.setRequestHeader("Content-type", "application/json");
    var jsonStringfy = JSON.stringify({numero: vagaNum, descricao: vagaDesc})
    console.log("jsonStringfy:", jsonStringfy);
    ajax.send(jsonStringfy);

    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            console.log(data);
        }
    }
}
