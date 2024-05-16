package definition.Booking;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Booking.GetBookingIds;

public class GetBookingldsDefinition {

    GetBookingIds booking;

    public GetBookingldsDefinition() {
        booking = new GetBookingIds();
    }

    @Dado("listo bookingid")
    public void listoBookingid() {
        booking.BookingG();
        ResponseBody<Response> body= GetBookingIds.responseAPI;
//        JsonPath json=new JsonPath(body.asString());
//        String token=json.getString("token_sesion");
        System.out.print(body.asString());
    }

    @Entonces("valido el codigo de respuesta del get {string}")
    public void validoElCodigoDeRespuestaDelGet(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), GetBookingIds.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + GetBookingIds.responseAPI.getStatusCode());
    }
}
