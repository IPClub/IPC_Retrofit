package am.ipc.ipc_retrofit.retrofit.ipc_courses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haykc on 05/16/2017.
 */

public class CoursesContent {


    @SerializedName("courses")
    public List<Course> courses ;
}
