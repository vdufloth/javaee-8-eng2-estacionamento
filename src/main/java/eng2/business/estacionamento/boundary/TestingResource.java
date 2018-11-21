/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng2.business.estacionamento.boundary;

import eng2.business.estacionamento.controll.TestControll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author vld
 */
@Path("/test")
public class TestingResource {
    @Inject
    TestControll tc;
    

    @GET
    public String teste() {
        return tc.test();
    }
}
