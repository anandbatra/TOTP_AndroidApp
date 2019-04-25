package com.ns.totp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.CountDownTimer;
import android.widget.LinearLayout;
import android.widget.TextView;
//import android.widget.LinearLayout.LayoutParams;;


import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    private MyCountDownTimer ctime;
    private MyCountDownTimer ctime1;
    private TextView totp;
    private TextView timer;
    private TextView totp1;
    private TextView timer1;
    private TextView demo;
    private TextView demo1;
    private long unixTime = System.currentTimeMillis() / 1000L;
    int count=123456;
    int count1=987654;
    FloatingActionButton fab;
    Intent i;
    Intent intent;
    String client_name;
    String otp;
    int height=0;


    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("Height", height);
        Log.i("SavedInstance","dummy");

        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
         height = savedInstanceState.getInt("height");
        Log.i("Restore","dummy");
//        double myDouble = savedInstanceState.getDouble("myDouble");
//        int myInt = savedInstanceState.getInt("MyInt");
//        String myString = savedInstanceState.getString("MyString");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





//        totp.setText("Hi there");
        ctime = new MyCountDownTimer(30000, 100);
        ctime1 = new MyCountDownTimer(30000, 100);



        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(view.getContext(),Client_List.class);

                startActivity(i);
            }
        });


        intent=getIntent();

        if(intent.hasExtra("Application"))
        {


            client_name=intent.getStringExtra("Application");
            Log.i("inside app",client_name);


        }
        if(intent.hasExtra("OTP"))
        {

            otp=intent.getStringExtra("OTP");
            Log.i("otp",otp);

        }

//        Log.i("outside ifs",client_name+"");


        if((client_name+"").equals("Google"))
        {
            Log.i("inside app if",client_name+"");


            demo = (TextView) findViewById (R.id.demo);
            CoordinatorLayout.LayoutParams layoutparams = (CoordinatorLayout.LayoutParams) demo.getLayoutParams();
            layoutparams.gravity = Gravity.LEFT;
            layoutparams.topMargin =height+ 250;
//            layoutparams.setMargins(20, 280, 0, 0);

            demo.setLayoutParams(layoutparams);

            timer = (TextView) findViewById (R.id.timer);
            CoordinatorLayout.LayoutParams layoutparams_timer = (CoordinatorLayout.LayoutParams) timer.getLayoutParams();
            layoutparams_timer.gravity = Gravity.RIGHT;
//            layoutparams_timer.setMargins(120, 280, 0, 0);
            layoutparams_timer.topMargin = height+250;

            timer.setLayoutParams(layoutparams_timer);

            totp = (TextView) findViewById (R.id.TOTP);
            CoordinatorLayout.LayoutParams layoutparams_totp = (CoordinatorLayout.LayoutParams) totp.getLayoutParams();
            layoutparams_totp.gravity = Gravity.CENTER_HORIZONTAL;
//            layoutparams_totp.setMargins(220, 280, 0, 0);
            layoutparams_totp.topMargin =height+ 250;

            totp.setLayoutParams(layoutparams_totp);

            totp.setText((count++)+"");
            height = height + 250;

            ctime.start();


//            demo.setTextSize(15.0f);
//            demo.setTextColor(Color.rgb( 0, 0, 200));
//            demo.setOnClickListener(this);
//            demo.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT,
//                    Toolbar.LayoutParams.WRAP_CONTENT));
            demo.setText(client_name);
//
//            demo.setText("");


            //task=Integer.parseInt(taskToBeDone);




        }
        else if((client_name+"").equals("Facebook"))
        {

            Log.i("inside app if fb",client_name);
//
            demo1 = (TextView) findViewById (R.id.demo1);
//
            CoordinatorLayout.LayoutParams layoutparams_client1 = (CoordinatorLayout.LayoutParams) demo1.getLayoutParams();
            layoutparams_client1.gravity = Gravity.LEFT;
            layoutparams_client1.topMargin =height +  250;
            demo1.setLayoutParams(layoutparams_client1);

            timer1 = (TextView) findViewById (R.id.timer1);
//
            CoordinatorLayout.LayoutParams layoutparams_timer1 = (CoordinatorLayout.LayoutParams) timer1.getLayoutParams();
            layoutparams_timer1.gravity = Gravity.RIGHT;
//            layoutparams_timer.setMargins(120, 280, 0, 0);
            layoutparams_timer1.topMargin =height +  250;
//
            timer1.setLayoutParams(layoutparams_timer1);
//
//
//
            totp1 = (TextView) findViewById (R.id.TOTP1);
            CoordinatorLayout.LayoutParams layoutparams_totp1 = (CoordinatorLayout.LayoutParams) totp1.getLayoutParams();
            layoutparams_totp1.gravity = Gravity.CENTER_HORIZONTAL;
////            layoutparams_timer.setMargins(120, 280, 0, 0);
            layoutparams_totp1.topMargin =height +  250;
//
            totp1.setLayoutParams(layoutparams_totp1);


            height = height + 250 ;




            totp1.setText((count1++)+"");
            ctime1.start();
            demo1.setText(client_name);
//            demo.setText("");


            //task=Integer.parseInt(taskToBeDone);

//            Log.i("App","inside app");


        }



//        Log.i("time remaining",millisUntilFinished / 1000+"");


    }





    public class MyCountDownTimer extends CountDownTimer {


        public MyCountDownTimer(long startTime, long interval)//constructor for the class
        {

            super(startTime, interval);


        }

        @Override
        public void onTick(long millisUntilFinished) {


            Log.i("OnTICK",client_name+"");



            if((client_name+"").equals("Google"))
            {

                Log.i("on tick inside if",(millisUntilFinished / 1000)+"");

                timer.setText((millisUntilFinished / 1000)+"");
            }
            else
            {
                timer1.setText((millisUntilFinished / 1000)+"");
            }





        }


        @Override
        public void onFinish()
        {

            if((client_name+"").equals("Google"))
            {
//
//
                totp.setText(count+"");
                count++;

                ctime.start();
            }
            else
            {
                totp1.setText(count1+"");
                count1++;

                ctime1.start();
            }




        }


    }
}
