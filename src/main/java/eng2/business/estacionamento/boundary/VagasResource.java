package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eng2.business.estacionamento.entity.Vaga;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

/**
 * @author vinicius.dufloth
 */
@Path("estacionamento")
public class VagasResource {
    @Inject
    VagaService vs;
    
    @GET
    public String vagas () {
        String jVagas = "";
        List<JsonObject> vagasList = new ArrayList<JsonObject>();
        try {
            jVagas = new Gson().toJson(vs.getAllVagas());
        } catch (Exception e) {
            jVagas = "!Erro ao carregar vagas";    
        }        
        return jVagas;     
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(JsonObject vaga){
        int numero = vaga.getInt("numero");
        String descricao = vaga.getString("descricao");
        String placa = vaga.getString("placa");
        this.vs.save(new Vaga(numero,descricao,placa));
    }
}
