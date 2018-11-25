package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.VagaControll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author vinicius.dufloth
 */
@Path("vagaslivres")
public class EncontrarVagaResource {
    @Inject
    VagaControll controll;
    
    @GET
    public String get () {
        String jVagas = "";
        try {
            jVagas = new Gson().toJson(controll.getFree());
        } catch (Exception e) {
            jVagas = "Erro ao carregar vagas livres";    
        }        
        return jVagas;     
    }
    
}
