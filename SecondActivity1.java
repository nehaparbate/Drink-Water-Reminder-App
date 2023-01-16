package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity1 extends AppCompatActivity {

     private Button LogOut;
     private FirebaseAuth firebaseAuth;
     private FirebaseAuth.AuthStateListener authStateListener;
     private Button Next;
     private Button plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second1);
        LogOut=findViewById(R.id.btLogout);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(SecondActivity1.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Next=findViewById(R.id.a2btstart);
        plan=findViewById(R.id.btHydration);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity1.this,FourthActivity.class);
                startActivity(intent);
                finish();
            }
        });

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity1.this,HydrationActivity.class);
               // Intent intent=new Intent(SecondActivity1.this,Tracking.class);
                startActivity(intent);
                finish();

            }
        });

    }

    //========================Menu Options===========================//


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logoutMenu:
            {
                FirebaseAuth firebaseAuth;
                firebaseAuth=FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent intent = new Intent(SecondActivity1.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(SecondActivity1.this, "Logging Out!", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.medicineMenu:
            {
                Intent intent = new Intent(SecondActivity1.this, Medicine.class);
                startActivity(intent);

                break;
            }
            case R.id.fragmentmenu:
            {
                Intent intent = new Intent(SecondActivity1.this, FragmentsActivity.class);
                startActivity(intent);

                break;
            }

        }
        return super.onOptionsItemSelected(item);

    }





}
