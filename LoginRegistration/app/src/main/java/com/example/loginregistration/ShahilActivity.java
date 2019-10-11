package com.example.loginregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShahilActivity extends AppCompatActivity {

    Button shahil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shahil);

        shahil = (Button) findViewById(R.id.btnshahil);


        shahil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ShahilActivity.this,"Welcome",Toast.LENGTH_LONG).show();


            }
        });


    }
}
