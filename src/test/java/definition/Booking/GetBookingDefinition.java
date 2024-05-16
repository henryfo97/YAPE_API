package definition.Booking;

import io.cucumber.java.es.Dada;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Auth.CreateToken;
import support.Booking.GetBooking;
import support.Booking.GetBookingIds;

public class GetBookingDefinition {

    GetBooking booking;

    public GetBookingDefinition() {
        booking = new GetBooking();
    }

    @Dada("envio el id {string} que deso consultar")
    public void envioElIdQueDesoConsultar(String id) {
        booking.Booking(id);
    }

    @Entonces("valido el codigo de respuesta para booking {string}")
    public void validoElCodigoDeRespuestaParaBooking(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), GetBooking.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + GetBooking.responseAPI.getStatusCode());
    }

    @Y("muestro el resultado de booking")
    public void muestroElResultadoDeBooking() {
        ResponseBody<Response> body= GetBooking.responseAPI;
        System.out.print(body.asString());
    }
}
