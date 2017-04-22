package com.drbt.holyquran.suras;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drbt.holyquran.R;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class takwir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takwir);



        //Tottal line number
        int n = 29;

        //intention: read every specific line and group them for designing
        for (int i = 0; i < n; i ++) {


            //creat new textciew and layout
            LinearLayout layout = new LinearLayout(this);
            TextView textA = new TextView(this);
            TextView textE = new TextView(this);

            //text design

            textA.setTextSize(26);
            textA.setTextColor(Color.rgb(0,0,0));


            textE.setTextSize(20);
            textE.setTextColor(Color.rgb(90,90,90));

            //layout design
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setBackgroundColor(Color.WHITE);
            layout.setPadding(7, 7, 7, 7);



            //arabic text params
            LinearLayout.LayoutParams arbText = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT

            );

            //set arabic to right
            arbText.gravity = Gravity.RIGHT;
            arbText.setMargins(0,4,0,15);

            //layout params
            LinearLayout.LayoutParams layoutDetails = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT

            );

            //set layout margin
            layoutDetails.setMargins(0, 0, 0, 5);


            //add text to newly created linear layout
            layout.addView(textA, arbText);
            layout.addView(textE);


            //add the newly created layout to main layout(creat nested layout)
            LinearLayout mainlayout = (LinearLayout)findViewById(R.id.suraLayout);
            mainlayout.addView(layout, layoutDetails);



            String s1 = null;
            String s2 = null;
            int i1 = i;
            int i2 = i + n;
            try {
                s1 = readLine(i1);
                s2 = readLine(i2);

                textA.setText(s1);
                textE.setText(s2);


            } catch (IOException e) {
                e.printStackTrace();
            }



        }

    }


    //count the total line in the byteArrayOutputString(not needed here)

//    public int lineNumber (String s) {
//
//        int ct = 0;
//        for (int i = 0; i <s.length() ; i++) {
//            if (s.charAt(i)=='\n') {
//                ct++;
//            }
//
//        }
//        return ct;
//    }


    //read the whole file
//    private String readTxt ( ) {
//        InputStream inputStream = getResources().openRawResource(R.raw.fatiha1);
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        try{
//            int n;
//            n=inputStream.read();
//            while (n!=-1) {
//
//                byteArrayOutputStream.write(n);
//                n = inputStream.read();
//
//
//            }
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return byteArrayOutputStream.toString();
//    }
//

    //read line by line
    String readLine ( int line)throws IOException {

        InputStream in = getResources().openRawResource(R.raw.takwir);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));

        try {
            String lineStr = null;
            int currentLine = 0;
            while ((lineStr = r.readLine()) != null) {
                if (currentLine++ == line) {
                    return lineStr;
                }
            }
        } finally {
            if (r != null) {
                r.close();
            }
        }
        throw new IOException("line" + line + "not found");

    }
}
