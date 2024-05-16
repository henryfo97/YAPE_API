package definition.Booking;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Booking.UpdateBooking;

import java.util.List;
import java.util.Map;

public class UpdateBookingDefiition {

    UpdateBooking update;

    public UpdateBookingDefiition() {
        update = new UpdateBooking();
    }

    @Dado("que ingreso el body request update")
    public void queIngresoElBodyRequestUpdate(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            update.UpdateB(data.get(i).get("Authorization")
                    , data.get(i).get("id")
                    , data.get(i).get("firstname")
                    , data.get(i).get("lastname")
                    , data.get(i).get("totalprice")
                    , data.get(i).get("depositpaid")
                    , data.get(i).get("checkin")
                    , data.get(i).get("checkout")
                    , data.get(i).get("additionalneeds"));
        }
    }

    @Entonces("valido el codigo de respuesta para update booking {string}")
    public void validoElCodigoDeRespuestaParaUpdateBooking(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), UpdateBooking.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + UpdateBooking.responseAPI.getStatusCode());
    }

    @Y("muestro el response de update booking")
    public void muestroElResponseDeUpdateBooking() {
        ResponseBody<Response> body = UpdateBooking.responseAPI;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(body.asString());
        System.out.println("-------------------------------------------------------------------------");
    }
}
