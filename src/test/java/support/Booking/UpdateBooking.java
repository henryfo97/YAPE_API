package support.Booking;

import io.restassured.response.Response;
import support.apihelper;

public class UpdateBooking {
    apihelper api;

    public static Response responseAPI;

    public UpdateBooking() {
        api = new apihelper();
    }

    public void UpdateB(String authorization, String id, String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds){
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        String payload ="{\"firstname\" : \""+firstname+"\",\"lastname\" : \""+lastname+"\",\"totalprice\" : "+totalprice+",\"depositpaid\" : "+depositpaid+",\"bookingdates\" : {\"checkin\" : \""+checkin+"\",\"checkout\" : \""+checkout+"\"},\"additionalneeds\" : \""+additionalneeds+"\"}";
        responseAPI = api.putUpdateBooking(url, authorization, payload);
    }
}
