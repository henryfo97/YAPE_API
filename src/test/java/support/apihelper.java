package support;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class apihelper {

    public Response postCreateToken(String url, Object payload){
        return given().body(payload).contentType("application/json").post(url);
    }

    ///////////////////////////////////////////////////////////////////////////
    public Response getGetBookinglds(String url){

        return given().contentType("application/json").get(url);
    }

    public Response getGetBooking(String url){
        return given().contentType("application/json").accept("application/json").get(url);
    }

    public Response postCreateBooking(String url, Object payload){
        return given().body(payload).contentType("application/json").accept("application/json").post(url);
    }

    public Response putUpdateBooking(String url, String authorization, Object payload){
        return given().body(payload).header("Authorization", authorization).contentType("application/json").accept("application/json").put(url);
    }

    public Response pathPartialUpdateBooking(String url, String authorization, Object payload){
        return given().body(payload).header("Authorization", authorization).contentType("application/json").accept("application/json").patch(url);
    }

    public Response deleteDeleteBooking(String url, String authorization){
        return given().header("Authorization", authorization).delete(url);
    }

    //////////////////////////////////////////////////////////////////////////

    public Response getHealthCheck(String url){
        return given().contentType("application/json").get(url);
    }

}
