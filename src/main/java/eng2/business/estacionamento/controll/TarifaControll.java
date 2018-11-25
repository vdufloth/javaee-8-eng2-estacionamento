package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Tarifa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author vinicius.dufloth
 */
@Stateless
public class TarifaControll {
    @PersistenceContext
    private EntityManager em;
    
    public void save(Tarifa tarifa){
        em.merge(tarifa);
    }
    
    public List<Tarifa> getAll() {
        return this.em.
                createNamedQuery("tarifas", Tarifa.class).
                getResultList();
    }
}
