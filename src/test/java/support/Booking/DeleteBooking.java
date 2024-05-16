package support.Booking;

import io.restassured.response.Response;
import support.apihelper;

public class DeleteBooking {
    apihelper api;
    public static Response responseAPI;

    public DeleteBooking() {
        api = new apihelper();
    }

    public void DeleteB(String authorization, String id){
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        responseAPI = api.deleteDeleteBooking(url, authorization);
    }
}
