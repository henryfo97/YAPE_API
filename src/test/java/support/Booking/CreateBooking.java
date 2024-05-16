package support.Booking;

import io.restassured.response.Response;
import support.apihelper;

public class CreateBooking {
    apihelper api;
    public static Response responseAPI;

    public CreateBooking() {
        api = new apihelper();
    }

    public void CreateB(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds){
        String url = "https://restful-booker.herokuapp.com/booking";
        String payload ="{\"firstname\" : \""+firstname+"\",\"lastname\" : \""+lastname+"\",\"totalprice\" : "+totalprice+",\"depositpaid\" : "+depositpaid+",\"bookingdates\" : {\"checkin\" : \""+checkin+"\",\"checkout\" : \""+checkout+"\"},\"additionalneeds\" : \""+additionalneeds+"\"}";
        responseAPI = api.postCreateBooking(url,payload);
    }
}
