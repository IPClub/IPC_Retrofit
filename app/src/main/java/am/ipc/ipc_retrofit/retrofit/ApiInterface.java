package am.ipc.ipc_retrofit.retrofit;

import am.ipc.ipc_retrofit.retrofit.ipc_courses.CoursesContent;
import am.ipc.ipc_retrofit.retrofit.ipc_courses.CoursesResponse;
import am.ipc.ipc_retrofit.retrofit.ipc_login.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> loginToIpc(@Field("login") String username,
                                   @Field("password") String password);


    @GET("enabledCourses")
    Call<CoursesResponse> getCourses(@Header("token") String t);
}
