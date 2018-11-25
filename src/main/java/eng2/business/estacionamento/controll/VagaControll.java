package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Vaga;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author vinicius.dufloth
 */
@Stateless
public class VagaControll {
    @PersistenceContext
    private EntityManager em;
    
    public void save(Vaga vaga){
        em.merge(vaga);
    }
    
    public List<Vaga> getAll(){
        return this.em.
                createNamedQuery("vagas", Vaga.class).
                getResultList();
    }
    
    public List<Vaga> getFree(){
        return this.em.
                createNamedQuery("vagasLivres", Vaga.class).
                getResultList();
    }
}
