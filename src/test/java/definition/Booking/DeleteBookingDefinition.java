package definition.Booking;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Booking.DeleteBooking;
import support.Booking.GetBooking;

import java.util.List;
import java.util.Map;

public class DeleteBookingDefinition {

    DeleteBooking delete;

    public DeleteBookingDefinition() {
        delete = new DeleteBooking();
    }

    @Dado("ejecuto el delete")
    public void ejecutoElDelete(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            delete.DeleteB(data.get(i).get("Authorization")
                        ,data.get(i).get("id"));
        }
    }

    @Entonces("valido el codigo de respuesta para delete booking {string}")
    public void validoElCodigoDeRespuestaParaDeleteBooking(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), DeleteBooking.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + DeleteBooking.responseAPI.getStatusCode());
    }

    @Y("muestro el response de delete booking")
    public void muestroElResponseDeDeleteBooking() {
        ResponseBody<Response> body= DeleteBooking.responseAPI;
        System.out.print(body.asString());
    }
}
