package definition.Ping;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Booking.DeleteBooking;
import support.Ping.HealthCheck;

public class HealthCheckDefinition {

    HealthCheck check;

    public HealthCheckDefinition(){
        check = new HealthCheck();
    }

    @Dado("ejecuto el HealthCheck")
    public void ejecutoElHealthCheck() {
        check.HealthC();
    }

    @Entonces("valido el codigo de respuesta para health {string}")
    public void validoElCodigoDeRespuestaParaHealth(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), HealthCheck.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + HealthCheck.responseAPI.getStatusCode());
    }

    @Y("muestro el response de health")
    public void muestroElResponseDeHealth() {
        ResponseBody<Response> body= HealthCheck.responseAPI;
        System.out.print(body.asString());
    }
}
