package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.TarifaControll;
import eng2.business.estacionamento.entity.Tarifa;
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
@Path("tarifa")
public class TarifaResource {
    @Inject
    TarifaControll controll;
    
    @GET
    public String get () {
        String jString = "";
        try {
            jString = new Gson().toJson(controll.getAll());
        } catch (Exception e) {
            jString = "Erro ao carregar tarifas";    
        }        
        return jString;     
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(JsonObject jo){
        String descricao = jo.getString("descricao");
        String valor = jo.getString("valor");
        this.controll.save(new Tarifa(descricao,Double.parseDouble(valor)));
    }
}
