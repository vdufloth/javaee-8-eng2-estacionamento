/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng2.business.estacionamento.controll;

import com.google.gson.Gson;
import eng2.business.estacionamento.entity.Estacionamento;
import eng2.business.estacionamento.entity.Tarifa;
import eng2.business.estacionamento.entity.Vaga;
import eng2.business.estacionamento.entity.Veiculo;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vld
 */
@Stateless
public class TestControll {
    
    @Inject
    TarifaControll tc;
    @Inject
    VagaControll vac;
    @Inject
    VeiculoControll vec;
    @Inject
    EstacionamentoControll ec;
    
    public String test(){
        Vaga vaga = new Vaga(1, "primeiravaga");
        Veiculo veiculo = new Veiculo("gol", "vermelho", "ISM-3455");
        Tarifa tarifa = new Tarifa("Carro Pequeno", 0.3);

        vac.save(vaga);
        tc.save(tarifa);        
        vec.save(veiculo);

        vaga = new Vaga(2, "vaga perto do hidrante");
        veiculo = new Veiculo("Camaro", "Amarelo", "GAY-2424");
        tarifa = new Tarifa("Carro de Rico", 12.99);

        tc.save(tarifa);
        vac.save(vaga);
        vec.save(veiculo);

        Estacionamento estacionamento = new Estacionamento("62648130356", "Jhon", "13:57");

        tc.getAll().get(1).getId();
        ec.save(estacionamento, tc.getAll().get(0).getId(), vac.getAll().get(0).getId(), vec.getAll().get(0).getId());

        estacionamento = new Estacionamento("40303166406", "Afonso", "17:12");
        ec.save(estacionamento, tc.getAll().get(1).getId(), vac.getAll().get(1).getId(), vec.getAll().get(1).getId());
        
        StringBuilder resultado = new StringBuilder("Resultado: ");
        for ( Estacionamento e : ec.getAll()) {
            resultado.append("<hr>");
            resultado.append(e.getId());
            resultado.append("<br>");
            resultado.append(e.getNomecliente());
            resultado.append("<br>");
            resultado.append(e.getVaga().getNumero());
            resultado.append("<br>");
            resultado.append(e.getTarifa().getDescricao());
            resultado.append("<br>");
            resultado.append(e.getVeiculo().getModelo());
            resultado.append("<br>");
        }
        
        String jVagas = new Gson().toJson(ec.getAll());
        
        return resultado.toString() + "<br><br>" + jVagas;
    }
    
}
