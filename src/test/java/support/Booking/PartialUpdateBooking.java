package support.Booking;

import io.restassured.response.Response;
import support.apihelper;

public class PartialUpdateBooking {
    apihelper api;

    public static Response responseAPI;

    public PartialUpdateBooking() {
        api = new apihelper();
    }
    public void PartialUpdateB(String authorization, String id, String firstname, String lastname){
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        String payload ="{\"firstname\" : \""+firstname+"\",\"lastname\" : \""+lastname+"\"}";
        responseAPI = api.pathPartialUpdateBooking(url, authorization, payload);
    }
}
