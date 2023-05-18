package com.rajapps.bmianalyzer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variables declaration


    TextView mcurrentheight;
    TextView mcurrentweight,mcurrentage;
    ImageView mincrementage,mdecrementage,mincrementweight,mdecrementweight;
    SeekBar mseekbarforheight;
    Button mcalculatebmi;
    RelativeLayout mmale,mfemale;

    int intweight=55; // Default weight
    int intage=22; // Default weight
    int currentprogress;
    String mintprogress="170";
    String typerofuser="0";
    String weight2="55";
    String age2="22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //main codes

        // hiding action Bar
       // Toolbar toolbar = findViewById(R.id.custom_toolbar);
     //   setSupportActionBar(toolbar);
      //  getSupportActionBar().hide();

        //finding id's and connecting to variables
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincrementage=findViewById(R.id.incrementage);
        mdecrementage=findViewById(R.id.decrementage);
        mincrementweight=findViewById(R.id.incremetweight);
        mdecrementweight=findViewById(R.id.decrementweight);
        mcalculatebmi=findViewById(R.id.calculatebmi);
        mseekbarforheight=findViewById(R.id.seekbarforheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);



        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typerofuser="Male";

            }
        });


        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typerofuser="Female";
            }
        });

        // setting maximum height = 300
        mseekbarforheight.setMax(300);
        // setting default height = 170
        mseekbarforheight.setProgress(170);

        //Height progress
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //increase Weight btn
        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });
        //Decrease Weight btn
        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });



        //increment age btn
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });
        //decrement age btn
        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });




        //Calculate btn
        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checking gender is selcted or not
                if(typerofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select Your Gender First",Toast.LENGTH_SHORT).show();
                }
                //checking height is selected or not
                else if(mintprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select Your Height First",Toast.LENGTH_SHORT).show();
                }
                //checking age=0 or age<0
                else if(intage==0 || intage<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is Incorrect",Toast.LENGTH_SHORT).show();
                }

                //checking weight=0 or weight<0
                else if(intweight==0|| intweight<0)
                {
                    Toast.makeText(getApplicationContext(),"Weight Is Incorrect",Toast.LENGTH_SHORT).show();
                }
                // going to BmiActivity
                else {

                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                    intent.putExtra("gender", typerofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);

                }


            }
        });


    }
    //functions


}