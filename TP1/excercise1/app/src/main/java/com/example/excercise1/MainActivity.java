package com.example.excercise1;

import android.os.Bundle;
import android.text.TextUtils;
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
    private int min;
    private int max;
    private int random;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // init variable
        this.min = 0;
        this.max = 100;
        this.random = new Random().nextInt((max - min) + 1) + min;
        this.count = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play (View view){
        final EditText guessText = (EditText) findViewById(R.id.guessText);
        String guess_text = guessText.getText().toString().trim();
        if(guess_text.isEmpty())
        {
            Toast.makeText(this, "You need to enter the guessing number", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int guess = Integer.parseInt(guessText.getText().toString());
            actionGuess(guess);
            count++;
            String toast = "count: " + String.valueOf(count);
            Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
        }
    }

    public void actionGuess ( int guess){
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

    public void convert(View view) {
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        final RadioButton radioButton = (RadioButton) findViewById(selectedId);
        final EditText dollarMoney = (EditText) findViewById(R.id.dollar);
        final EditText eurMoney = (EditText) findViewById(R.id.eur);
        // find the radiobutton by returned id

        if (radioButton.getText().equals("Dol->Eu")) {
            if (TextUtils.isEmpty(dollarMoney.getText().toString())) {
                Toast.makeText(this, "You need to enter the amount of dollar", Toast.LENGTH_SHORT).show();
            } else {
                float dollar = Float.parseFloat(dollarMoney.getText().toString());
                float eurConverted = convertToEuro(dollar);
                eurMoney.setText(String.valueOf(eurConverted));
            }
        }
        else if (radioButton.getText().equals("Eu->Dol")) {
            if (TextUtils.isEmpty(eurMoney.getText().toString())) {
                Toast.makeText(this, "You need to enter the amount of eur", Toast.LENGTH_SHORT).show();
            } else {
                float euro = Float.parseFloat(eurMoney.getText().toString());
                float dollarConverted = convertToDollar(euro);
                dollarMoney.setText(String.valueOf(dollarConverted));
            }
        }
    }

    public static float convertToEuro ( float amount)
    {
        return (float) (amount / 1.18);
    }
    public static float convertToDollar ( float amount){
        return (float) (amount * 1.36077);
    }
}