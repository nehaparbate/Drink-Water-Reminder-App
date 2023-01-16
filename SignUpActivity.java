package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUpActivity extends AppCompatActivity {
   
    private EditText UserEmail;
    private EditText UserPassword;
    private Button SignUp;
    private TextView UserLogin;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //creates instance of the authenticator
        firebaseAuth = FirebaseAuth.getInstance();

        UserEmail =  findViewById(R.id.etUserEmail);
        UserPassword =  findViewById(R.id.etPass);
        SignUp =  findViewById(R.id.btSignUp);
        UserLogin =  findViewById(R.id.tvDone);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_email = UserEmail.getText().toString().trim();
                String user_pass = UserPassword.getText().toString().trim();


                if (user_email.isEmpty())
                {
                    UserEmail.setError("Please Enter Email");
                    UserEmail.requestFocus();
                }
                else if (user_pass.isEmpty())
                {
                    UserPassword.setError("Please Enter Password");
                    UserPassword.requestFocus();
                }
                else if (user_email.isEmpty() && user_pass.isEmpty())
                {
                    UserPassword.setError("Please Enter Password");
                    UserPassword.requestFocus();
                    Toast.makeText(SignUpActivity.this, "Enter All Details !", Toast.LENGTH_SHORT).show();
                }

                else if (!(user_email.isEmpty() && user_pass.isEmpty()))
                {



                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Registration Successful! ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Registration Failed! ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                    {
                    Toast.makeText(SignUpActivity.this, "Error! Registration Failed! ", Toast.LENGTH_SHORT).show();

                }
            }

        });

        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SecondActivity1.class));
                finish();
            }
        });

    }




}
