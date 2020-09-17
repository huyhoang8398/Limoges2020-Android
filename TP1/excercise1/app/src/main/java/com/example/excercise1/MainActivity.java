package com.example.excercise1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final int min = 0;
    final int max = 100;
    final int random = new Random().nextInt((max - min) + 1) + min;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText eurMoney;

    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(random);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText dollarMoney = (EditText) findViewById(R.id.dollar);
        eurMoney = (EditText) findViewById(R.id.eur);

        radioGroup = (RadioGroup) findViewById(R.id.radio);

        this.count = 0;

        Button btnConvert = (Button) findViewById(R.id.convertMoney);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                if (radioButton.getText().equals("Dol->Eu")) {
                    float dollar = Float.parseFloat(dollarMoney.getText().toString());
                    System.out.println(dollar);
                    float eurConverted = convertToEuro(dollar);
                    System.out.println(eurConverted);
                    eurMoney.setText(String.valueOf(eurConverted));
                }

                if (radioButton.getText().equals("Eu->Dol")) {
                    float eurmoney = Float.parseFloat(eurMoney.getText().toString());
                    float dollarConverted = convertToDollar(eurmoney);
                    dollarMoney.setText(String.valueOf(dollarConverted));
                }

                Toast.makeText(MainActivity.this,
                        radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void play(View view){
        //final TextView guessTextView = (TextView) findViewById(R.id.guessNum);
        //guessTextView.setText(String.valueOf(random));
        //guessTextView.setVisibility(View.GONE);

        final EditText guessText = (EditText) findViewById(R.id.guessText);
        int guess = Integer.parseInt(guessText.getText().toString());
//        System.out.println(guess);
        actionGuess(guess);
        count++;
        String toast = "count: " + String.valueOf(count);
        Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();

    }

    public void actionGuess(int guess) {
        if (guess > random) {
            Toast.makeText(getApplicationContext(), "Your number is bigger", Toast.LENGTH_SHORT).show();
        } else if (guess < random) {
            Toast.makeText(getApplicationContext(), "Your number is smaller", Toast.LENGTH_SHORT).show();
        } else {
            final TextView guessTextView = (TextView) findViewById(R.id.guessNum);
            guessTextView.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), "Win", Toast.LENGTH_SHORT).show();
        }
    }

    public static float convertToEuro(float amount)
    {
        float euro = (float) (amount / 1.18);
        return euro;
    }
    public static float convertToDollar(float amount) {
        float dollar  = (float) (amount * 1.36077);
        return dollar;
    }
}



