/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng2.business.estacionamento.boundary;

import com.google.gson.Gson;
import eng2.business.estacionamento.controll.EstacionamentoControll;
import eng2.business.estacionamento.entity.Estacionamento;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author vinicius.dufloth
 */
@Path("/estacionamento")
public class EstacionamentoResource {
    
    @Inject
    EstacionamentoControll ec;
    
    @GET
    public String estacionamentos () {  
        String jVagas = "";        
        try {
            jVagas = new Gson().toJson(ec.getAll());
        } catch (Exception e) {
            jVagas = "Erro ao carregar estacionamentos";    
        }        
        return jVagas;     
    }
    
}
