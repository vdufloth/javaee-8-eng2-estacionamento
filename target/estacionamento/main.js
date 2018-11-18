console.log("chamou");

function fetchVagas() {
  //var vagasURL = "eng2-estacionamento/resources/estacionamento"
  const TODAS_VAGAS_URL = "http://localhost:8080/eng2-estacionamento/resources/estacionamento"
  var vagas;
  console.log("fetching 8");
  fetch(TODAS_VAGAS_URL)
  .then(function(response){
    response.json().then(function(data){
      vagas = data;
    });
  })
  .catch(function(err){
    console.error('Erro ao buscar os dados', err);
  });

  var vagasList = document.getElementById('vagasList');
  vagasList.innerHTML = '';

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
