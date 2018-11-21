package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Estacionamento;
import eng2.business.estacionamento.entity.Tarifa;
import eng2.business.estacionamento.entity.Vaga;
import eng2.business.estacionamento.entity.Veiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author vld
 */
@Stateless
public class EstacionamentoControll {
    @PersistenceContext
    private EntityManager em;
    
    public void save
    (Estacionamento estacionamento, long tarifaid, long vagaid, long veiculoid) {
        estacionamento.setVaga(em.find(Vaga.class, vagaid));
        estacionamento.setTarifa(em.find(Tarifa.class, tarifaid));
        estacionamento.setVeiculo(em.find(Veiculo.class, veiculoid));
                
        save(estacionamento);
    }
    
    public void save(Estacionamento estacionamento){
        em.merge(estacionamento);
    }
    
    public List<Estacionamento> getAll() {
        return this.em.createNamedQuery("estacionamentos", Estacionamento.class).
                getResultList();
    }
}
