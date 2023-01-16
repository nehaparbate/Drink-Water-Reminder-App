package com.example.loginpage;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FourthActivity extends AppCompatActivity {
    private EditText age;
    private CheckBox female;
    private CheckBox male;
    private EditText bodywt;
    private EditText wakeUp;
    private EditText sleep;

    private FirebaseAuth firebaseAuth;

    private TextView Next;
    private String age1;
    private String sex1;
    private String bodywt1;
    private String wakeUp1;
    private String sleep1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Next=findViewById(R.id.a4tvnext);
        age=findViewById(R.id.etage);
        bodywt=findViewById(R.id.etbodywt);
        female=findViewById(R.id.cbfemale);
        male=findViewById(R.id.cbmale);
        wakeUp=findViewById(R.id.etwake);
        sleep=findViewById(R.id.etsleep);

        firebaseAuth=FirebaseAuth.getInstance();






        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                sendData();
                Intent intent=new Intent(FourthActivity.this,FifthActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getData()
    {
        bodywt1=bodywt.getText().toString();

        age1=age.getText().toString();

        if(female.isChecked())
        {
            sex1="Female";

        }
        else if(male.isChecked())
        {
            sex1="Male";
        }

        wakeUp1=wakeUp.getText().toString();
        sleep1=sleep.getText().toString();




    }
     private void sendData()
    {


        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myref=firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile=new UserProfile(age1,sex1,bodywt1,wakeUp1,sleep1);
        myref.setValue(userProfile);
    }


    //========================Menu Options===========================//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.logoutMenu:
            {
                firebaseAuth.signOut();
                Intent intent = new Intent(FourthActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(FourthActivity.this, "Logging Out!", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.medicineMenu:
            {
                Intent intent = new Intent(FourthActivity.this, Medicine.class);
                startActivity(intent);

                break;
            }

            case R.id.fragmentmenu:
            {
                Intent intent = new Intent(FourthActivity.this, FragmentsActivity.class);
                startActivity(intent);

                break;
            }

        }
        return super.onOptionsItemSelected(item);

    }
}
