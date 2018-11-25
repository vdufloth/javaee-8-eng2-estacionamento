package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.VeiculoControll;
import eng2.business.estacionamento.entity.Veiculo;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author vinicius.dufloth
 */
@Path("/veiculo")
public class VeiculoResource {
    @Inject
    VeiculoControll controll;
    
    @GET
    public String get () {
        String jVagas = "";
        try {
            jVagas = new Gson().toJson(controll.getAll());
        } catch (Exception e) {
            jVagas = "Erro ao carregar veiculos";    
        }        
        return jVagas;     
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(JsonObject jo){
        String modelo = jo.getString("modelo");
        this.controll.save(new Veiculo(modelo));
    }
}
