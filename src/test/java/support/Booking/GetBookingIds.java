package support.Booking;

import io.restassured.response.Response;
import support.apihelper;

public class GetBookingIds {
    apihelper api;
    public static Response responseAPI;

    public GetBookingIds() {
        api = new apihelper();
    }

    public void BookingG(){
        String url = "https://restful-booker.herokuapp.com/booking";
        responseAPI = api.getGetBookinglds(url);
    }
}
