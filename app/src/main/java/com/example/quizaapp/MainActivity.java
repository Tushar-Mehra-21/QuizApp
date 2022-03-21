package com.example.quizaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button yes,no,restart;
    TextView textView1,textView2;
     String[] questions ={"int x[] = new int[]{10,20,30};<br><br>Arrays can also be created and initialize as in above statement.",
            "In an instance method or a constructor, \"this\" is a reference to the current object.", "Garbage Collection is manual process.",
            "The JRE deletes objects when it determines that they are no longer being used. This process is called Garbage Collection.",
            "Constructor overloading is not possible in Java.","Assignment operator is evaluated Left to Right.","All binary operators except for the assignment operators are evaluated from Left to Right","Java programming is not statically-typed, means all variables should not first be declared before they can be used."};

     Boolean[] answers ={true,true,false,true,false,false,true,false};
     int max= answers.length;
     int index=0;
     int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        restart = findViewById(R.id.restart);
        textView1= findViewById(R.id.textView1);
        textView2= findViewById(R.id.textView2);
        textView1.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answers[index] && index!=answers.length-1){
                    score++;
                }
                if(index<answers.length-1){
                    index++;
                    textView1.setText(questions[index]);
                }
                else{
                    textView1.setText("COMPLETED!!");
                    textView2.setText("Score is "+score+"/"+max);
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answers[index] && index!=answers.length-1){
                    score++;
                }
                if(index<answers.length-1){
                    index++;
                    textView1.setText(questions[index] );
                }
                else{
                    textView1.setText("COMPLETED!!");
                    textView2.setText("Score is "+score+"/"+max);
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  index=0;
                  score=0;
                  textView1.setText(questions[index]);
                  textView2.setText("");
            }
        });
    }

}

