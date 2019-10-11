package com.example.loginregistration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText etname, etid, etpass, etclass;
    Button btnregister;

    String name,id,clas,password;

    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etname = (EditText) findViewById(R.id.etname);
        etid = (EditText) findViewById(R.id.etid);
        etclass = (EditText) findViewById(R.id.etclass);
        etpass = (EditText) findViewById(R.id.etpass);

        btnregister = (Button) findViewById(R.id.btnregister);


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 name = etname.getText().toString();
                 id = etid.getText().toString();
                 clas = etclass.getText().toString();
                 password = etpass.getText().toString();

                 if(!name.isEmpty() && !id.isEmpty() && !clas.isEmpty() && !password.isEmpty()){
                     register();
                 } else {
                     Toast.makeText(RegisterActivity.this, "Please enter your details", Toast.LENGTH_LONG).show();
                 }



            }
        });
    }

    private void register() {

        pDialog= ProgressDialog.show(RegisterActivity.this,"","Registering...",false,false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.URL_REGISTER,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {



                        Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_LONG).show();

                        pDialog.hide();

                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        pDialog.hide();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Name",name);
                params.put("Id",id);
                params.put("Class", clas);
                params.put("Password",password);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
