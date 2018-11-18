package eng2.business.estacionamento.boundary;

import eng2.business.estacionamento.controll.VagaLoja;
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
    VagaLoja cs;
    
    public List<Vaga> getAllVagas(){
        return this.cs.all();
    }
    
    public void save(Vaga vaga){
        this.cs.save(vaga);
    }
}
