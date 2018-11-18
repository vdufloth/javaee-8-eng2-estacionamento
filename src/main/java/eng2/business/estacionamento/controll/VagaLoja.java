package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Vaga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author vinicius.dufloth
 */
public class VagaLoja {
    @PersistenceContext
    EntityManager em;
    
    public void save(Vaga vaga){
        em.merge(vaga);
    }
    
    public List<Vaga> all(){
        return this.em.
                createNamedQuery("all", Vaga.class).
                getResultList();
    }
}
