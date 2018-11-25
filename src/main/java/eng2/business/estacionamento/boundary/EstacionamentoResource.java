package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.EstacionamentoControll;
import eng2.business.estacionamento.entity.Estacionamento;
import java.time.Instant;
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
@Path("estacionamento")
public class EstacionamentoResource {
    
    @Inject
    EstacionamentoControll controll;
    
    @GET
    public String get () {
        String jVagas = "";
        try {
            jVagas = new Gson().toJson(controll.getAll());
        } catch (Exception e) {
            jVagas = "Erro ao carregar estacionamentos" + e.getMessage();    
        }        
        return jVagas;     
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(JsonObject jo){
        String cnh = jo.getString("cnh");
        String nome = jo.getString("nome");
        String placa = jo.getString("placa");
        String hora = Instant.now().toString();
        
        long tarifaid = jo.getInt("tarifaid");
        long vagaid = jo.getInt("vagaid");
        long veiculoid = jo.getInt("veiculoid");
        
        this.controll.save(new Estacionamento(cnh,nome,hora,placa),tarifaid,veiculoid,vagaid);
    }
    
}
