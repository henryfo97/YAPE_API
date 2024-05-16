package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadCreateToken {

    @JsonProperty(value = "username")
    private  String Username;

    @JsonProperty(value = "password")
    private  String Password;

    public payloadCreateToken(String username, String password) {
        this.Username = username;
        this.Password = password;
    }
}
