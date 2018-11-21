/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Tarifa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author vld
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
