package eng2.business.estacionamento.controll;

import com.google.gson.Gson;
import eng2.business.estacionamento.entity.Estacionamento;
import eng2.business.estacionamento.entity.Tarifa;
import eng2.business.estacionamento.entity.Vaga;
import eng2.business.estacionamento.entity.Veiculo;
import java.time.Instant;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vinicius.dufloth
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
    @Inject
    SaidaControll sc;
    
    public String test(){   
        
        createTarifas();
        createVeiculos();
        createVagas();
        createEstacionamentos();
      
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
    
    public void createTarifas(){
        Tarifa tarifa = new Tarifa("Feriados", 0.05);
        tc.save(tarifa);        
        tarifa = new Tarifa("Cliente Normal", 0.03);
        tc.save(tarifa);
        tarifa = new Tarifa("Cartão Fidelidade", 0.02);
        tc.save(tarifa);
    }
    
    public void createVagas(){
        Vaga vaga = new Vaga(1, "Primeira à esquerda");
        vac.save(vaga);
        vaga = new Vaga(2,"Vaga com pneu atrás");
        vac.save(vaga);
        vaga = new Vaga(3, "Cara caminhões");
        vac.save(vaga);
        vaga = new Vaga(4, "Terceira da esquerda");
        vac.save(vaga);
        vaga = new Vaga(5, "Com a mangueira");
        vac.save(vaga);
        vaga = new Vaga(6, "Apenas motos");
        vac.save(vaga);
        vaga = new Vaga(7, "Apenas bicicletas");
        vac.save(vaga);
    }
    
    public void createVeiculos(){
        Veiculo veiculo = new Veiculo("Gol 2013");
        vec.save(veiculo);
        veiculo = new Veiculo("Cruze 2012");
        vec.save(veiculo);
        veiculo = new Veiculo("Chevette 1996");
        vec.save(veiculo);
        veiculo = new Veiculo("Veloster 2015");
        vec.save(veiculo);
        veiculo = new Veiculo("Peogeot 408 2013");
        vec.save(veiculo);
        veiculo = new Veiculo("Renegade 2011");
        vec.save(veiculo);
    }
    
    public void createEstacionamentos(){
        Estacionamento estacionamento = new Estacionamento("62648130356", "Jhon", Instant.now().plusSeconds(-7200).toString(), "ISM-1235");

        ec.save(estacionamento, tc.getAll().get(0).getId(), vac.getAll().get(0).getId(), vec.getAll().get(0).getId());

        estacionamento = new Estacionamento("40303166406", "Afonso", Instant.now().plusSeconds(-240).toString(), "ENG-1234");
        ec.save(estacionamento, tc.getAll().get(1).getId(), vac.getAll().get(1).getId(), vec.getAll().get(1).getId());
        
        
        estacionamento = new Estacionamento("09283746192", "Guilherme", Instant.now().plusSeconds(-45000).toString(), "AFS-0981");
        ec.save(estacionamento, tc.getAll().get(2).getId(), vac.getAll().get(2).getId(), vec.getAll().get(2).getId());
    }
    
    
}
