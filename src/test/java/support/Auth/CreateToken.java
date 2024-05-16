package support.Auth;

import io.restassured.response.Response;
import objects.payloadCreateToken;
import support.apihelper;


public class CreateToken {
    apihelper api;
    payloadCreateToken token;
    public static Response responseAPI;

    public CreateToken(){
        api = new apihelper();
    }

    public void createT(String username, String password){
        String url = "https://restful-booker.herokuapp.com/auth";
        token = new payloadCreateToken(username, password);
        responseAPI = api.postCreateToken(url,token);
    }
}
