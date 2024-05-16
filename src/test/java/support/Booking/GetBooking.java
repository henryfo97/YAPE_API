package support.Booking;

import io.restassured.response.Response;
import support.apihelper;

public class GetBooking {
    apihelper api;

    public static Response responseAPI;

    public GetBooking() {
        api = new apihelper();
    }

    public void Booking(String id){
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        responseAPI = api.getGetBooking(url);
    }
}
