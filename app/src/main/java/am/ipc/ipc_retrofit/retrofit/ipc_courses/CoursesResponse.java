package am.ipc.ipc_retrofit.retrofit.ipc_courses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haykc on 05/16/2017.
 */

public class CoursesResponse {

    @SerializedName("status")
    public int status;

    @SerializedName("message")
    public String message;

    @SerializedName("content")
    public CoursesContent c;


}
