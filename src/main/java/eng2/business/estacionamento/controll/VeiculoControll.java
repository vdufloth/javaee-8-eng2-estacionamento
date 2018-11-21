/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Veiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vld
 */
@Stateless
public class VeiculoControll {
    @PersistenceContext
    private EntityManager em;
    
    public void save(Veiculo veiculo){
        em.merge(veiculo);
    }
    
    public List<Veiculo> getAll() {
        return this.em.
                createNamedQuery("veiculos", Veiculo.class).
                getResultList();
    }   
}
