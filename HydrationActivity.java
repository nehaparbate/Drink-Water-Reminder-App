package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HydrationActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private String gender;
    private String age1;
    public int water;
    private TextView budget;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydration);

        budget=findViewById(R.id.tvwaterml);
        next=findViewById(R.id.btstarttrack);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HydrationActivity.this,Tracking1.class);
                startActivity(intent);
                finish();
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener()

        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

            UserProfile userProfile=dataSnapshot.getValue(UserProfile.class);

            gender=userProfile.getUser_gender() ;
            age1=userProfile.getUser_age();




                    calculate();



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(HydrationActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }


        });


    }

    private void calculate()
    {
       int age=Integer.parseInt(age1);


        if(gender.equalsIgnoreCase("female"))
        {
            if(age<8)
            {
                water=1200;
            }
            else if(age>=8 && age<=13 )
            {
              water=1800;
            }
            else if(age>=14 && age<=18)
            {
               water=2200;
            }
            else
            {
                water=2700;
            }

       }
       else

    {
        if (age < 8)
        {
            water = 1200;
        } else if (age >= 8 && age <= 13) {
            water = 1800;
        } else if (age >= 14 && age <= 18) {
            water = 2200;
        } else {
            water = 3700;
        }
    }



        //Toast.makeText(HydrationActivity.this,water,Toast.LENGTH_LONG).show();
        budget.setText(Integer.toString(water));

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
                Intent intent = new Intent(HydrationActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(HydrationActivity.this, "Logging Out!", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.medicineMenu:
            {
                Intent intent = new Intent(HydrationActivity.this, Medicine.class);
                startActivity(intent);

                break;
            }

            case R.id.fragmentmenu:
            {
                Intent intent = new Intent(HydrationActivity.this, FragmentsActivity.class);
                startActivity(intent);

                break;
            }

        }
        return super.onOptionsItemSelected(item);

    }

}


