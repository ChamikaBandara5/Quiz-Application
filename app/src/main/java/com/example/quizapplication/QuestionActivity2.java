package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity2 extends AppCompatActivity {

    String questions[] = {

            "The opening paranthesis should immediately follow the macro name",
            "What is a lint",
            "If abcdefg is the input, the output will be",
            "Why is a macro used in place of a function?",
            "In the C language, the constant is defined _______"


    };
    String answer[] = {

            "The opening paranthesis should immediately follow the macro name",
            "Analyzing tool",
            "efg",
            "It reduces code size",
            "Anywhere,but starting on a new line"
    };
    String opt[] = {

            "The opening paranthesis should immediately follow the macro name","There should Be at least one blank between the macro name and the opening parenthesis","There should be only one blank between the macro name and the opening parenthesis","All the above comments are correct",

            "C compiler","Interactive debugger","Analyzing tool","C interpreter",

            "abcd","abc","efg","Garbage",

            "It reduces execution time","It reduces code size","It increases execution time","It increases code size",

            "Before main","After main","Anywhere,but starting on a new line","None of the these"
    };

    int flag=0;

    public static int marks=0,correct=0,wrong=0;


    TextView tv;
    Button submitbutton,quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private TextView questionnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();

        questionnumber = findViewById(R.id.DispName);
        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answergrp);
        rb1 = (RadioButton) findViewById(R.id.radiobutton);
        rb1 = (RadioButton) findViewById(R.id.radiobutton2);
        rb1 = (RadioButton) findViewById(R.id.radiobutton3);
        rb1 = (RadioButton) findViewById(R.id.radiobutton4);


        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_g.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(QuestionActivity2.this,"please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionActivity2.this,"correct",Toast.LENGTH_SHORT).show();

                }
                else {
                    wrong++;
                    Toast.makeText(QuestionActivity2.this,"wrong",Toast.LENGTH_SHORT).show();
                }

                flag++;
                if (score!=null)
                {
                    score.setText(""+correct);

                    if (flag<questions.length)
                    {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag+4]);
                        rb2.setText(opt[flag+4 + 1]);
                        rb3.setText(opt[flag+4 + 2]);
                        rb4.setText(opt[flag+4 + 3]);
                        questionnumber.setText(flag+"/"+questions.length+"Question");
                    }
                    else {
                        marks=correct;
                        Intent in = new Intent(QuestionActivity2.this,ResultActivity2.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), ResultActivity2.class);
                startActivity(intent1);

            }
        });



    }
}
