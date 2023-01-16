package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class Tracking extends AppCompatActivity {

    TextView tvCalculate;
    TextView waterLeft;
    Button btnAdd,btnSub,btnStart;

    FirebaseAuth firebaseAuth;
    public static  int value=0;
  //  Context context =;
   // SharedPreferences sharedPref = context.getSharedPreferences(
     //       getString(R.string.preference_file_key), Context.MODE_PRIVATE);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        tvCalculate=findViewById(R.id.tvCalculate);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnStart=findViewById(R.id.btnStart);
        //waterLeft=findViewById(R.id.tvwaterleft);
        firebaseAuth=FirebaseAuth.getInstance();



        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

    //            tvCalculate.setText(Integer.toString(value));
              // LoadInt();
                value=value - 150;
              //  SaveInt("key",value);

              tvCalculate.setText(Integer.toString(value));
                Toast.makeText(Tracking.this,"150ml Reduced!",Toast.LENGTH_SHORT).show();


            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                tvCalculate.setText(Integer.toString(value));
              //  LoadInt();

                value=value+150;
              //  SaveInt("key",value);


                tvCalculate.setText(Integer.toString(value));
                Toast.makeText(Tracking.this,"150ml Added!",Toast.LENGTH_SHORT).show();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }

   /* public void SaveInt(String key, int value){


        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putInt(key, value);
       editor.apply();
    }
    public void LoadInt(){

        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        value = sharedPreferences.getInt("key", value);
    }
*/




    }


