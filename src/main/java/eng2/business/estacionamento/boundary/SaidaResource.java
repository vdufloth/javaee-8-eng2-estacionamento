package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.SaidaControll;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vinicius
 */
@Path("saida")
public class SaidaResource {
    
    @Inject
    SaidaControll controll;
    
    @GET
    public String get(){
        return "output";
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(JsonObject jo){
        String entrada = jo.getString("numero");
        controll.registrarSaida(Integer.parseInt(entrada));
     //   String retorno = controll.registrarSaida(Integer.parseInt(entrada));
     //   String retorno = "alô";
     //   return  retorno;
    }
}
