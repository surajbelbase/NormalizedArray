package com.example.buttontoarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText enterSize,enterArrOne,enterArrTwo;
    Button enterButton,btnArrOne,btnArrTwo,btnCompute,btnClear;

    TextView dispArrOne,dispArrTwo,dispFactor,dispArrNorm;

    List<Integer> li1 = new ArrayList<>();
    List<Integer> li2 = new ArrayList<>();
    List<Integer> avg = new ArrayList<>();
    List<Integer> norm = new ArrayList<>();
    int size = 0;
    String arr1 = "", arr2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterSize = (EditText) findViewById(R.id.enterSize);
        enterButton = (Button) findViewById(R.id.enterButton);
        enterArrOne = (EditText) findViewById(R.id.enterArrOne);
        enterArrTwo = (EditText) findViewById(R.id.enterArrTwo);
        btnArrOne = (Button) findViewById(R.id.btnArrOne);
        btnArrTwo = (Button) findViewById(R.id.btnArrTwo);
        dispArrOne = (TextView) findViewById(R.id.dispArrOne);
        dispArrTwo = (TextView) findViewById(R.id.dispArrTwo);
        btnCompute = (Button) findViewById(R.id.btnCompute);
        dispFactor = (TextView) findViewById(R.id.dispFactor);
        dispArrNorm = (TextView) findViewById(R.id.dispArrNorm);
        btnClear = (Button) findViewById(R.id.btnClear);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numSize = enterSize.getText().toString();
                Boolean isDigit = true;
                for(int i = 0; i<numSize.length(); i++){

                    if(!Character.isDigit(numSize.charAt(i))){
                        isDigit = false;
                        break;
                    }

                }if(isDigit){
                    size = Integer.parseInt(numSize);
                    Toast.makeText(MainActivity.this,"Entered size is : "+size,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Alphabets not allowed!!",Toast.LENGTH_LONG).show();
                }

                enterSize.getText().clear();
            }
        });

        btnArrOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(size==0){
                    Toast.makeText(MainActivity.this,"First enter the size variable!",Toast.LENGTH_LONG).show();
                }
                else if(li1.size()<size){
                    String num = enterArrOne.getText().toString();
                    Boolean isDigit = true;
                    for(int i = 0; i<num.length(); i++){

                        if(!Character.isDigit(num.charAt(i))){
                            isDigit = false;
                            break;
                        }

                    }
                    if(isDigit){
                        int n = Integer.parseInt(num);
                        if(n>=0&&n<=255){
                            li1.add(n);
                            arr1 = arr1 + n + " ";
                            dispArrOne.setText(arr1);
                        }else{
                            Toast.makeText(MainActivity.this,"Enter value between 0 and 255",Toast.LENGTH_LONG).show();

                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Alphabets not allowed!!",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,"can't add further values, size has reached maximum value : "+li1.size(),Toast.LENGTH_LONG).show();
                }
                enterArrOne.getText().clear();
                }
        });

        btnArrTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(size==0){
                    Toast.makeText(MainActivity.this,"First enter the size variable!",Toast.LENGTH_LONG).show();
                }
                else if(li2.size()<size){
                    String num = enterArrTwo.getText().toString();
                    Boolean isDigit = true;
                    for(int i = 0; i<num.length(); i++){
                        if(!Character.isDigit(num.charAt(i))){
                            isDigit = false;
                            break;
                        }
                    }
                    if(isDigit){
                        int n = Integer.parseInt(num);
                        if(n>=0&&n<=255){
                            li2.add(n);
                            arr2 = arr2 + n + " ";
                            dispArrTwo.setText(arr2);
                        }else{
                            Toast.makeText(MainActivity.this,"Enter value between 0 and 255",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Alphabets not allowed!!",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,"can't add further values, size has reached maximum value  : "+li2.size(),Toast.LENGTH_LONG).show();
                }
                enterArrTwo.getText().clear();
            }
        });

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i<li1.size(); i++){
                    avg.add((li1.get(i)+li2.get(i))/2);
                }
                float max = Collections.max(avg);
                float factor = 255/max;
                dispFactor.setText(""+factor);

                String normArr = "";
                for(int i = 0; i<li1.size(); i++){
                    int product = (int)(avg.get(i)*factor);
                    norm.add(product);
                    normArr = normArr + norm.get(i) + "  ";
                }

                dispArrNorm.setText(normArr);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                li1.clear();
                li2.clear();
                avg.clear();
                norm.clear();
                arr1 = "";
                arr2 = "";
                size = 0;
                dispArrOne.setText("..items..");
                dispArrTwo.setText("..items..");
                dispFactor.setText("_______");
                dispArrNorm.setText("---");
            }
        });

    }
}