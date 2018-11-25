package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.VagaControll;
import eng2.business.estacionamento.entity.Vaga;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

/**
 * @author vinicius.dufloth
 */
@Path("vaga")
public class VagaResource {
    @Inject
    VagaControll controll;
    
    @GET
    public String get () {
        String jVagas = "";
        try {
            jVagas = new Gson().toJson(controll.getAll());
        } catch (Exception e) {
            jVagas = "Erro ao carregar vagas";    
        }        
        return jVagas;     
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(JsonObject jo){
        int numero = Integer.parseInt(jo.getString("numero"));
        String descricao = jo.getString("descricao");
        this.controll.save(new Vaga(numero,descricao));
    }
}
