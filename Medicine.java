package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class Medicine extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    TextView Name;
    EditText etname;
    TextView tvmed;
    ImageView ivclock;
    TextView tvstop;

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine2);


        etname=findViewById(R.id.etname);
        tvmed=findViewById(R.id.tvmed);
        ivclock=findViewById(R.id.ivclock);
        tvstop=findViewById(R.id.tvstop);


    ivclock.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            DialogFragment timePicker=new TimePickerFragment();
            timePicker.show(getSupportFragmentManager(),"Time Picker");


        }


    });

    tvstop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            stopAlarm();
        }
    });
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        tvmed.setText("Alarm set at "+hourOfDay+":"+minute+" for "+etname.getText());
        alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Medicine.this, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        // Set the alarm to start at the wake up time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
        Toast.makeText(Medicine.this,"Alarm set !!!",Toast.LENGTH_SHORT).show();

    }

    public void stopAlarm()
    {
        if (alarmMgr!= null)
        {
            alarmMgr.cancel(alarmIntent);
            Toast.makeText(Medicine.this,"Alarm Cancelled !!!",Toast.LENGTH_SHORT).show();
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
                FirebaseAuth firebaseAuth;
                firebaseAuth=FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent intent = new Intent(Medicine.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Medicine.this, "Logging Out!", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.medicineMenu:
            {
                Intent intent = new Intent(Medicine.this, Medicine.class);
                startActivity(intent);

                break;
            }

            case R.id.fragmentmenu:
            {
                Intent intent = new Intent(Medicine.this, FragmentsActivity.class);
                startActivity(intent);

                break;
            }

        }
        return super.onOptionsItemSelected(item);

    }



}
