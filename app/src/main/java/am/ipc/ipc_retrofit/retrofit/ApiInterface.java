package am.ipc.ipc_retrofit.retrofit;

import am.ipc.ipc_retrofit.retrofit.ipc_login.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haykc on 05/14/2017.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> loginToIpc(@Field("login") String username,
                                   @Field("password") String password);
}
