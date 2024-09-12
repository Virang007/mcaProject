package com.example.onroadassi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserRegister extends AppCompatActivity {

    private EditText uemail;
    private EditText upassword;
    private EditText repassword;
    private Button regiter;

    private FirebaseAuth auth; //connection code
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        uemail=findViewById(R.id.uemail);
        upassword=findViewById(R.id.upassword);
        repassword=findViewById(R.id.repassword);
        regiter=findViewById(R.id.btn_signUp);
        auth =FirebaseAuth.getInstance();


        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uemail1 =uemail.getText().toString();
                String upassword1 =upassword.getText().toString();

                if (!uemail1.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(uemail1).matches())
                {
                    if (!upassword1.isEmpty())
                    {
                        progressDialog =new ProgressDialog(UserRegister.this);
                        progressDialog.setCancelable(false);
                        progressDialog.setTitle("Register...");
                        progressDialog.show();
                        register(uemail1,upassword1);
                    }
                    else {
                        Toast.makeText(UserRegister.this,"Empty field Are not Allowed",Toast.LENGTH_SHORT).show();
                    }

                }
                else if (uemail1.isEmpty()){
                    Toast.makeText(UserRegister.this,"Empty field Are not Allowed",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(UserRegister.this,"Enter correct Email",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register(String uemail1, String upassword1) {

        auth.createUserWithEmailAndPassword(uemail1,upassword1).addOnCompleteListener(UserRegister.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(UserRegister.this,"SuccessFully Register",Toast.LENGTH_SHORT).show();
                    finish();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
                else {
                    Toast.makeText(UserRegister.this,"Register failed",Toast.LENGTH_SHORT).show();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(UserRegister.this,"Allrady Register",Toast.LENGTH_SHORT).show();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });
    }
}