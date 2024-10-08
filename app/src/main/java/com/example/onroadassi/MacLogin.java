package com.example.onroadassi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MacLogin extends AppCompatActivity {

    private FirebaseAuth auth; //connection code

    private TextView email,password,forg;
    private Button login,regis;
    String eforg;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mac_login);

//        connection;
        auth =FirebaseAuth.getInstance();


        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        forg=findViewById(R.id.forg);
        login=findViewById(R.id.login);
        regis=findViewById(R.id.regis);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 =email.getText().toString();
                String password1= password.getText().toString();
//
                if (!email1.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email1).matches())
                {

                    if (!password1.isEmpty())
                    {
                        progressDialog =new ProgressDialog(MacLogin.this);
                        progressDialog.setCancelable(false);
                        progressDialog.setTitle("Login...");
                        progressDialog.show();
                        login(email1,password1);
                    }
                    else {
                        Toast.makeText(MacLogin.this,"Empty field Are not Allowed",Toast.LENGTH_SHORT).show();
                    }

                }
                else if (email1.isEmpty()){
                    Toast.makeText(MacLogin.this,"Empty field Are not Allowed",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MacLogin.this,"Enter correct Email",Toast.LENGTH_SHORT).show();

                }
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uemail1 =email.getText().toString();
                String upassword1 =password.getText().toString();

                if (!uemail1.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(uemail1).matches())
                {
                    if (!upassword1.isEmpty())
                    {
                        progressDialog =new ProgressDialog(MacLogin.this);
                        progressDialog.setCancelable(false);
                        progressDialog.setTitle("Register...");
                        progressDialog.show();
                        register(uemail1,upassword1);
                    }
                    else {
                        Toast.makeText(MacLogin.this,"Empty field Are not Allowed",Toast.LENGTH_SHORT).show();
                    }

                }
                else if (uemail1.isEmpty()){
                    Toast.makeText(MacLogin.this,"Empty field Are not Allowed",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MacLogin.this,"Enter correct Email",Toast.LENGTH_SHORT).show();
                }
            }
        });

        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder di= new androidx.appcompat.app.AlertDialog.Builder(MacLogin.this);
                di.setTitle("Enter Email and forgetPassword");
                EditText editText=new EditText(MacLogin.this);

                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                di.setView(editText);
                di.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eforg = editText.getText().toString();

                        if (eforg.isEmpty())
                        {
                            Toast.makeText(MacLogin.this,"email not match",Toast.LENGTH_SHORT).show();
                        }else {
                            forget();
                        }


                    }
                });
                di.show();
            }
        });

    }

    private void login(String email1, String password1) {
        auth.signInWithEmailAndPassword(email1,password1).addOnSuccessListener(MacLogin.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String str = email.getText().toString();
                Intent intent =new Intent(MacLogin.this,MacDash.class);
                intent.putExtra("em",str);
                startActivity(intent);
                Toast.makeText(MacLogin.this,"Login SuccessFully.",Toast.LENGTH_SHORT).show();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MacLogin.this,"Enter correct Password.",Toast.LENGTH_SHORT).show();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });
    }

    private void register(String uemail1, String upassword1) {
        auth.createUserWithEmailAndPassword(uemail1,upassword1).addOnCompleteListener(MacLogin.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(MacLogin.this,"SuccessFully Register",Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(MacLogin.this,MacLogin.class);
//                    startActivity(intent);
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
                else {
                    Toast.makeText(MacLogin.this,"Register failed",Toast.LENGTH_SHORT).show();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(MacLogin.this,"Allrady Register",Toast.LENGTH_SHORT).show();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });
    }


    private void forget() {
//        auth.sendPasswordResetEmail(eforg).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful())
//                {
//                    Toast.makeText(mca_login.this,"check you email id",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(mca_login.this,"error",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}