package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    FirebaseAuth firebaseAuth;


    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        Name=findViewById(R.id.etEName);
        Password=findViewById(R.id.etPassword);
        Login=findViewById(R.id.btLogin);
        Info=findViewById(R.id.tvInfo);

        authStateListener=new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser!=null)
                {
                    Toast.makeText(MainActivity.this,"You are Logged in!",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(MainActivity.this,SecondActivity1.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_email = Name.getText().toString().trim();
                String user_password = Password.getText().toString().trim();
                if (user_email.isEmpty()) {
                    Name.setError("Please Enter Email");
                    Name.requestFocus();
                } else if (user_password.isEmpty()) {
                    Password.setError("Please Enter Password");
                    Password.requestFocus();
                }
                else if (user_email.isEmpty() && user_password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter All Details !", Toast.LENGTH_SHORT).show();
                }
                else if (!(user_email.isEmpty() && user_password.isEmpty()))
                {

                 firebaseAuth.signInWithEmailAndPassword(user_email,user_password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                     @Override

                     public void onComplete(@NonNull Task<AuthResult> task) {

                         if(!task.isSuccessful())
                         {
                             Toast.makeText(MainActivity.this, "Error! Login Failed! ", Toast.LENGTH_SHORT).show();
                         }
                         else {
                             Intent intent =new Intent(MainActivity.this,SecondActivity1.class);
                             startActivity(intent);
                             finish();
                         }
                     }
                 });

                }

            }

        });
        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}
