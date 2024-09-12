package com.example.onroadassi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserDash extends AppCompatActivity {
TextView t,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash);

        t=findViewById(R.id.pro);
        t1=findViewById(R.id.t1);
        Intent intent = getIntent();
        String str = intent.getStringExtra("em");
        t1.setText(str);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(UserDash.this,wallet.class);
                startActivity(i);
            }
        });
    }


    public void payget(View view) {

        Intent i =new Intent(UserDash.this,PayGetway.class);
        startActivity(i);
    }

    public void tipes(View view) {
        Intent i =new Intent(UserDash.this,Tip.class);
        startActivity(i);
    }

    public void logout(View view) {
        finish();
    }

    public void abo(View view) {
        Intent i =new Intent(UserDash.this,About.class);
        startActivity(i);
    }
}