package am.ipc.ipc_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import am.ipc.ipc_retrofit.retrofit.ApiClient;
import am.ipc.ipc_retrofit.retrofit.ApiInterface;
import am.ipc.ipc_retrofit.retrofit.ipc_courses.CoursesResponse;
import am.ipc.ipc_retrofit.retrofit.ipc_login.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText login_et;
    EditText pass_et;
    TextView status;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_et = (EditText) findViewById(R.id.login);
        pass_et = (EditText) findViewById(R.id.pass);
        status = (TextView) findViewById(R.id.status);
    }

    public void login(View view) {
        String login = login_et.getText().toString();
        String pass = pass_et.getText().toString();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call =  apiService.loginToIpc(login,pass);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse r = response.body();
                if(response.body().status == 200){
                    status.setText(r.content.token);
                    token = r.content.token;
                }else{
                    status.setText(r.message);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                status.setText("something went wrong");
            }
        });
    }

    public void allCourses(View view) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CoursesResponse> call =  apiService.getCourses(token);

        call.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
                CoursesResponse r = response.body();
                if(r.status ==200){
                    Log.i("__courses",r.c.courses.toString());
                    status.setText("");
                }

            }

            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {
                status.setText("something went wrong");
            }
        });


    }
}
