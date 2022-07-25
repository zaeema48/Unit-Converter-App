package com.example.unitconvertor;  //unit convertor is the name of my app. name and domain should be chosen uniquely

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creating the objects
    private Button button;
    private TextView resValue;  //TextView(alt+enter) to import the required package from xml or etc
    private EditText inputValue;
    private Button swap;
    private TextView inputView;
    private TextView resView;
    private TextView heading;


    public void calculate(){
        String s = inputValue.getText().toString();   //getting the value using getText which accepts string only
        int input = Integer.parseInt(s);   //convert string into integer
        if(heading.getText().toString().equals("Convert Kg to Pounds")) {
            double pound = 2.205 * input;
            resValue.setText("" + pound);   //display the result
        }
        else {
           double kg= input/2.205;
            resValue.setText("" + kg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //onCreate method sets the view on opening the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FETCHING THE OBJECTS BY ITS ID
        button=findViewById(R.id.button2);  //button2 is the id of that button. note do not change the id from xml
        inputValue =findViewById(R.id.editTextNumber2);
        swap=findViewById(R.id.button);
        inputView = findViewById(R.id.textView4);
        resView =findViewById(R.id.textView3);
        resValue=findViewById(R.id.textView2);
        heading= findViewById(R.id.textView);
        inputValue.setText("1");

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SWAPPING
                String temp = inputView.getText().toString();
                inputView.setText(resView.getText().toString());  //equating the input and resvalue
                resView.setText(temp);
                inputValue.setText("1");
                resValue.setText("");

                if(heading.getText().toString().equals("Convert Kg to Pounds"))
                    heading.setText("Converts pounds to kg");
                else
                    heading.setText("Convert Kg to Pounds");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {  //to make the button responsive
            @Override
            public void onClick(View view) {
                calculate();

                Toast.makeText(MainActivity.this, "Calculating..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}