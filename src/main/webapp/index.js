document.addEventListener('DOMContentLoaded', function () {
    fetchEstacionamentos();
}, false);

function montaLista(estacionamento) {
    var estacionamentoList = document.getElementById('estacionamentoList');
    estacionamentoList.innerHTML = '';

    estacionamento = JSON.parse(estacionamento);

    for (var i = 0; i < estacionamento.length; i++) {
        var nome = estacionamento[i].nomecliente;
        var cnh = estacionamento[i].cnh;
        var hora = estacionamento[i].horaentrada;
        var tarifa = estacionamento[i].tarifa.valorminuto;
        var numero = estacionamento[i].vaga.numero;
        var desc = estacionamento[i].vaga.descricao;
        var modelo = estacionamento[i].veiculo.modelo;
        var placa = estacionamento[i].placa;
        estacionamentoList.innerHTML += '<div class="itemVaga">' +
                                            '<hr></hr>' +
                                            '<p>Vaga: ' + numero + '</p>' +
                                            '<p>Descricao: ' + desc + '</p>' +
                                            '<p>Modelo: ' + modelo + '</p>' +
                                            '<p>Placa: ' + placa + '</p>' +
                                            '<p>Cliente: ' + nome + '</p>' +
                                            '<p>CNH: ' + cnh + '</p>' +
                                            '<p>Entrada: ' + hora + '</p>' +
                                            '<p>Valor/Minuto: ' + tarifa + '</p>' +
                                        '</div>';
    }
}

function fetchEstacionamentos() {
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "resources/estacionamento", true);
    ajax.send();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            montaLista(data);
        }
    }

}
