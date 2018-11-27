document.addEventListener('DOMContentLoaded', function() {
    fetchTarifas();
    fetchVagas();
    fetchModelos();
    
    criaEstacionamento();
}, false);

function fetchTarifas() {
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "resources/tarifa", true);
    ajax.send();
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            montaLista(data);
	}
    } 
}

function montaLista(tarifas) {
    var tarifasSelect = document.getElementById('idTarifas');
    tarifasSelect.innerHTML = '';
    
    tarifas = JSON.parse(tarifas);

    for (var i = 0; i < tarifas.length; i++) {
        var id = tarifas[i].id;
        var desc = tarifas[i].descricao;
        tarifasSelect.innerHTML += '<option value = \"'+ id + '\">' + 
                                desc +
                              '</option>';
    }
}

function fetchModelos() {
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "resources/veiculo", true);
    ajax.send();
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            montaListaModelos(data);
	}
    }
}

function montaListaModelos(modelos) {
    var modelosSelect = document.getElementById('idModelos');
    modelosSelect.innerHTML = '';
    
    modelos = JSON.parse(modelos);

    for (var i = 0; i < modelos.length; i++) {
        var id = modelos[i].id;
        var modelo = modelos[i].modelo;
        modelosSelect.innerHTML += '<option value = \"'+ id + '\">' + 
                                    modelo +
                                   '</option>';
    }
}
function fetchVagas() {
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "resources/vaga", true);
    ajax.send();
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            montaListaVagas(data);
	}
    }
}

function montaListaVagas(vagas) {
    var vagasSelect = document.getElementById('idVagas');
    vagasSelect.innerHTML = '';
    
    vagas = JSON.parse(vagas);

    for (var i = 0; i < vagas.length; i++) {
        var id = vagas[i].id;
        var vaga = vagas[i].numero;
        vagasSelect.innerHTML += '<option value = \"'+ id + '\">' + 
                               vaga +
                              '</option>';
    }
}

function criaEstacionamento() {
    var form_el = document.getElementsByClassName("registrar_estacionamento_form")[0];

    form_el.addEventListener("submit", function(evt) {
        evt.preventDefault();
    
        var ajax = new XMLHttpRequest();

        var URL = "resources/estacionamento";
        var nomeCliente = document.getElementsByClassName('nomeCLi')[0].value;
        var cnhCLi = document.getElementsByClassName('CNH')[0].value;
        var placaCarro = document.getElementsByClassName('placaCarro')[0].value;

        var vagaOption = document.getElementsByClassName("selectVagas");
        var vagaSelectedOption = vagaOption[0].options[vagaOption[0].selectedIndex].value;
        
    //    var modeloOption = document.getElementsByClassName("selectModelos");
    //    var modeloSelectedOption = modeloOption[0].options[modeloOption[0].selectedIndex].value;
    //    
    //    var tarifaOption = document.getElementsByClassName("selectTarifas");
    //    var tarifaSelectedOption = tarifaOption[0].options[tarifaOption[0].selectedIndex].value;

//        var vagaSelectedOption = "12";
//
//        var modeloSelectedOption = "5";
//
//        var tarifaSelectedOption = "1";
//
//        ajax.open("POST", URL, true);
//        ajax.setRequestHeader("Content-type", "application/json");
//        var jsonStringfy = JSON.stringify({nome: nomeCliente, cnh: cnhCLi, vagaid: vagaSelectedOption, placa: placaCarro, veiculoid: modeloSelectedOption, tarifaid: tarifaSelectedOption})
//        console.log("jsonStringfy:", jsonStringfy);
//        ajax.send(jsonStringfy);
//
//        ajax.onreadystatechange = function() {
//            if (ajax.readyState == 4 && ajax.status == 200) {
//                var data = ajax.responseText;
//                console.log(data);
//            }
//        }
    });
}