package com.example.a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1.Model.LoginAuth;
import com.example.a1.NetworkService.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button btnLogin = findViewById(R.id.btnLogin);
        EditText loginText = findViewById(R.id.editText);
        EditText passwordText = findViewById(R.id.editPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginText.getText().toString();
                String pwd = passwordText.getText().toString();

                NetworkService.getInstance().AuthAPI().login(email, pwd).enqueue(new Callback<LoginAuth>() {
                    @Override
                    public void onResponse(Call<LoginAuth> call, Response<LoginAuth> response) {
                        Log.e("call ", call.request().toString());
                        assert response.body() != null;
                        Log.e("token: ", response.body().toString());
                        String token = response.body().getToken();

                    }

                    @Override
                    public void onFailure(Call<LoginAuth> call, Throwable t) {
                        Log.e("token: ", t.toString());
                    }
                });
            }
        });
    }
    public void onMyButtonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, show_list.class);
        startActivity(intent);
    }
}
