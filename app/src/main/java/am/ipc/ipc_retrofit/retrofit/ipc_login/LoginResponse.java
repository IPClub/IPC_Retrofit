package am.ipc.ipc_retrofit.retrofit.ipc_login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haykc on 05/14/2017.
 */

public class LoginResponse {

    @SerializedName("status")
    public int status;

    @SerializedName("message")
    public String message;

    @SerializedName("content")
    public LoginContent content;
}
