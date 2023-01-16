package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Tracking1 extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton  radioButton,r1,r2,r3,r4;
    TextView tv1;
    Button btadd,btstop,btnsub;
    int value=0;
    ImageView clock;


    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private String gender;
    private String age1;
    private String awaketime;
    public int water;
    private int awaketime1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking1);

        radioGroup = findViewById(R.id.rdg);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        tv1 = findViewById(R.id.tv1water);
        btadd = findViewById(R.id.bt1add);
        btstop=findViewById(R.id.bt1set);
        btnsub=findViewById(R.id.btnsub);
        clock=findViewById(R.id.imageView);





//instance stored to access firebase
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                gender = userProfile.getUser_gender();
                age1 = userProfile.getUser_age();
                awaketime=userProfile.getUser_wakeup();
                awaketime1=Integer.parseInt(awaketime);
                calculate();


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Tracking1.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }

        });


        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);

                if (radioButton == r1) {


                        value = value + 50;
                        tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"50ml Added!",Toast.LENGTH_SHORT).show();
                        if(value>=water)
                        {
                            Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                        }


                } else if (radioButton == r2) {


                    value = value + 100;
                    tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"100ml Added!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }

                } else if (radioButton == r3) {



                    value = value + 150;
                    tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"150ml Added!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }

                } else if (radioButton == r4) {

                        value = value + 200;
                        tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"200ml Added!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }

                }


            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);

                if (radioButton == r1) {


                    value = value - 50;
                    tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"50ml Subtracted!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }


                } else if (radioButton == r2) {


                    value = value -100;
                    tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"100ml Subtracted!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }

                } else if (radioButton == r3) {



                    value = value -150;
                    tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"150ml Subtracted!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }

                } else if (radioButton == r4) {

                    value = value -200;
                    tv1.setText(Integer.toString(value));
                    Toast.makeText(Tracking1.this,"200ml Subtracted!",Toast.LENGTH_SHORT).show();
                    if(value>=water)
                    {
                        Toast.makeText(Tracking1.this,"Your water target is completed !!!",Toast.LENGTH_LONG).show();
                    }

                }


            }
        });




        clock.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        setAlarm();
    }
});

        btstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAlarm();

            }
        });

    }



    private void setAlarm()
    {
// To get the alarm service
        alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(Tracking1.this, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

   // Set the alarm to start at the wake up time
        //instance gets stored in Calender object
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.set(Calendar.HOUR_OF_DAY,awaketime1);
        calendar.set(Calendar.MINUTE, 30);
        Toast.makeText(Tracking1.this,"Alarm set !!!",Toast.LENGTH_SHORT).show();

    // setRepeating() lets you specify a precise custom interval--in this case,
     // 30 minutes.
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 3, alarmIntent);
    }



    public void stopAlarm()
    {
        if (alarmMgr!= null)
        {
            alarmMgr.cancel(alarmIntent);
            Toast.makeText(Tracking1.this,"Alarm Cancelled !!!",Toast.LENGTH_SHORT).show();
        }
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
            if (age < 8) {
                water = 1200;
            } else if (age >= 8 && age <= 13) {
                water = 1800;
            } else if (age >= 14 && age <= 18) {
                water = 2200;
            } else {
                water = 3700;
            }
        }

    }

    //======================== Menu Options ===========================//
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
                Intent intent = new Intent(Tracking1.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Tracking1.this, "Logging Out!", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.medicineMenu:
            {
                Intent intent = new Intent(Tracking1.this, Medicine.class);
                startActivity(intent);

                break;
            }

            case R.id.fragmentmenu:
            {
                Intent intent = new Intent(Tracking1.this, FragmentsActivity.class);
                startActivity(intent);

                break;
            }

        }
        return super.onOptionsItemSelected(item);

    }



}
