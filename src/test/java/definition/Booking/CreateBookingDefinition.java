package definition.Booking;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Booking.CreateBooking;

import java.util.List;
import java.util.Map;

public class CreateBookingDefinition {

    CreateBooking create;
    static Integer Bookingid;

    public CreateBookingDefinition() {
        create = new CreateBooking();
    }

    @Dado("que ingreso el body request")
    public void queIngresoElBodyRequest(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            create.CreateB(data.get(i).get("firstname")
                    , data.get(i).get("lastname")
                    , data.get(i).get("totalprice")
                    , data.get(i).get("depositpaid")
                    , data.get(i).get("checkin")
                    , data.get(i).get("checkout")
                    , data.get(i).get("additionalneeds"));
        }
    }

    @Entonces("valido el codigo de respuesta para create booking {string}")
    public void validoElCodigoDeRespuestaParaCreateBooking(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), CreateBooking.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + CreateBooking.responseAPI.getStatusCode());
    }

    @Y("muestro el response de create booking")
    public void muestroElResponseDeCreateBooking() {
        ResponseBody<Response> body = CreateBooking.responseAPI;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(body.asString());
        System.out.println("-------------------------------------------------------------------------");

        JsonPath json = new JsonPath((body.asString()));
        Bookingid = json.with(body.asString()).get("bookingid");
        System.out.println(Bookingid);
    }

    public Integer Variable(){
        return Bookingid;
    }
}
