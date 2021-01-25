package com.example.mrk.dayteller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button b, clr;
    int m, d, y,val;
    int mon[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    public int dayofweek(int d, int m, int y)
    {
        int mon[] = { 0, 31, 59, 90, 120,151 ,181 ,212,243,273,304,334 };
        int t=0;
        if((y%4==0)&&((y%100==0)||y%400==0)&&m<3)
            t=1;
        return ( y*365 + y/4 - y/100 + y/400 + mon[m-1]-t + d-1) % 7;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        b = (Button) findViewById(R.id.button);
        clr = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d = Integer.parseInt(et1.getText().toString());
                m = Integer.parseInt(et2.getText().toString());
                y = Integer.parseInt(et3.getText().toString());
                if((m==2 && d>29)||d>31)
                {
                    Toast.makeText(MainActivity.this, "Invalid date", Toast.LENGTH_SHORT).show();
                }

                else {
                    val = dayofweek(d, m, y);
                  // int val1=dayofweek(d-1,m,y);
                    int val2=dayofweek(1,m+1,y);
                    if( val2==val)
                    {
                        Toast.makeText(MainActivity.this, "Invalid date", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (val == 0) {
                            Toast.makeText(MainActivity.this, "Sunday",
                                    Toast.LENGTH_LONG).show();
                            //et3.setText("Sunday");
                        } else if (val == 1) {

                            Toast.makeText(MainActivity.this, "Monday",
                                    Toast.LENGTH_LONG).show();
                        } else if (val == 2) {

                            Toast.makeText(MainActivity.this, "Tuesday",
                                    Toast.LENGTH_LONG).show();
                        } else if (val == 3) {

                            Toast.makeText(MainActivity.this, "Wednesday",
                                    Toast.LENGTH_LONG).show();
                        } else if (val == 4) {

                            Toast.makeText(MainActivity.this, "Thursday",
                                    Toast.LENGTH_LONG).show();
                        } else if (val == 5) {

                            Toast.makeText(MainActivity.this, "Friday",
                                    Toast.LENGTH_LONG).show();
                        } else {

                            Toast.makeText(MainActivity.this, "Saturday",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
    clr.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        et1.setText("");
        et2.setText("");
        et3.setText("");
    }
    });
}

}