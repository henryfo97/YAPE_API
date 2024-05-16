package definition.Booking;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Booking.PartialUpdateBooking;
import support.Booking.UpdateBooking;

import java.util.List;
import java.util.Map;

public class PartialUpdateDefinition {

    PartialUpdateBooking partialUpdate;

    public PartialUpdateDefinition() {
        partialUpdate = new PartialUpdateBooking();
    }

    @Dado("que ingreso el body request partialupdate")
    public void queIngresoElBodyRequestPartialupdate(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            partialUpdate.PartialUpdateB(data.get(i).get("Authorization")
                    , data.get(i).get("id")
                    , data.get(i).get("firstname")
                    , data.get(i).get("lastname"));
        }
    }

    @Entonces("valido el codigo de respuesta para partialupdate booking {string}")
    public void validoElCodigoDeRespuestaParaPartialupdateBooking(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), PartialUpdateBooking.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + PartialUpdateBooking.responseAPI.getStatusCode());
    }

    @Y("muestro el response de partialupdate booking")
    public void muestroElResponseDePartialupdateBooking() {
        ResponseBody<Response> body = PartialUpdateBooking.responseAPI;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(body.asString());
        System.out.println("-------------------------------------------------------------------------");
    }
}
