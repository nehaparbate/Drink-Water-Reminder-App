package com.example.loginpage;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class FifthActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        firebaseAuth = FirebaseAuth.getInstance();
        Next=findViewById(R.id.bta5);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FifthActivity.this,HydrationActivity.class);
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
                firebaseAuth.signOut();
                Intent intent = new Intent(FifthActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(FifthActivity.this, "Logging Out!", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.medicineMenu:
            {
                Intent intent = new Intent(FifthActivity.this, Medicine.class);
                startActivity(intent);

                break;
            }

            case R.id.fragmentmenu:
            {
                Intent intent = new Intent(FifthActivity.this, FragmentsActivity.class);
                startActivity(intent);

                break;
            }
        }
        return super.onOptionsItemSelected(item);

    }
}


