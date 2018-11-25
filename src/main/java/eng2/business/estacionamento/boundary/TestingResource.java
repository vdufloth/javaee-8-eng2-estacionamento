package eng2.business.estacionamento.boundary;

import eng2.business.estacionamento.controll.TestControll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author vinicius.dufloth
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
