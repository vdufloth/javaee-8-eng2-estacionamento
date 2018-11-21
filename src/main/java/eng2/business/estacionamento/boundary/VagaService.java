package eng2.business.estacionamento.boundary;

import eng2.business.estacionamento.controll.VagaControll;
import eng2.business.estacionamento.entity.Vaga;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author vinicius
 */
@Stateless
public class VagaService {
    
    @Inject
    VagaControll cs;
    
    public List<Vaga> getAllVagas(){
        return this.cs.getAll();
    }
    
    public void save(Vaga vaga){
        this.cs.save(vaga);
    }
}
