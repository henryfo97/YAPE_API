package support.Ping;

import io.restassured.response.Response;
import support.apihelper;

public class HealthCheck {
    apihelper api;
    public static Response responseAPI;

    public HealthCheck(){
        api = new apihelper();
    }

    public void HealthC(){
        String url = "https://restful-booker.herokuapp.com/ping";
        responseAPI = api.getHealthCheck(url);
    }
}
