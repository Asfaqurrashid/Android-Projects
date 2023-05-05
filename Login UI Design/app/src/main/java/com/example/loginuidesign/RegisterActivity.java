package com.example.loginuidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    TextView login;
    Button btnRegister;
    EditText email, pass, conpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button)findViewById(R.id.btnregister);
        email = (EditText)findViewById(R.id.inputEmail);
        pass = (EditText)findViewById(R.id.inputPassword);
        conpass = (EditText)findViewById(R.id.inputConfirmPassword);
        login = (TextView) findViewById(R.id.newLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkValidity(pass.getText().toString(), conpass.getText().toString()))
                {
                    sendData(email.getText().toString(), pass.getText().toString());
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Password Not Matched", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public boolean checkValidity(String pass, String conpass) {
        if(pass.equals(conpass))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void sendData(final String email,final String pass)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject object = new JSONObject();
        try {
            object.put("email", email);
            object.put("password", pass);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        String url = "http://192.168.0.46/api/Student";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getInt("id") == 0)
                    {

                        Toast.makeText(getApplicationContext(), "User Already Registered With This Email!", Toast.LENGTH_SHORT ).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Registration Succeeded", Toast.LENGTH_SHORT ).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                if (networkResponse != null) {
                    Log.e("Volley", "Error. HTTP Status Code:" + networkResponse.statusCode);
                }

                if (error instanceof TimeoutError) {
                    Log.e("Volley", "TimeoutError");
                } else if (error instanceof NoConnectionError) {
                    Log.e("Volley", "NoConnectionError");
                } else if (error instanceof AuthFailureError) {
                    Log.e("Volley", "AuthFailureError");
                } else if (error instanceof ServerError) {
                    Log.e("Volley", "ServerError");
                } else if (error instanceof NetworkError) {
                    Log.e("Volley", "NetworkError");
                } else if (error instanceof ParseError) {
                    Log.e("Volley", "ParseError");
                }
                Log.d("Maps:", " Error: " + error.getMessage());
            }
        }
        );
        queue.add(jsonObjectRequest);
    }


}