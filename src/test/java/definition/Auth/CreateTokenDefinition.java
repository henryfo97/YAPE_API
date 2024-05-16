package definition.Auth;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.Auth.CreateToken;

import java.util.List;
import java.util.Map;

public class CreateTokenDefinition {
    CreateToken token;

    public CreateTokenDefinition() {
        token = new CreateToken();
    }

    @Dado("ingreso body request de usuario")
    public void ingresoBodyRequestDeUsuario(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            token.createT(data.get(i).get("username"), data.get(i).get("password"));
        }
    }

    @Entonces("valido el codigo de respuesta {string}")
    public void validoElCodigoDeRespuesta(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), CreateToken.responseAPI.getStatusCode());
        System.out.println("El codigo de respuesta es:" + CreateToken.responseAPI.getStatusCode());
    }

    @Dado("muestro el resultado")
    public void muestroElResultado() {
        ResponseBody<Response> body = CreateToken.responseAPI;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(body.asString());
        System.out.println("-------------------------------------------------------------------------");
    }
}
