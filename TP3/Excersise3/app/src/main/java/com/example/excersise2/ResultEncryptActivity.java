package com.example.excersise2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultEncryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_result);

        Bundle data = getIntent().getExtras();
        Parameter parameter = (Parameter) data.getParcelable("param");


        if (parameter.getAlgo().equals("caesar")) {
            caesar(parameter.getPlainText(), Integer.parseInt(parameter.getKey()));
        }
        else {
            vigenere(parameter.getPlainText(), parameter.getKey());
        }
    }


    public void vigenere(String text, String key) {
        final TextView resultTextView = (TextView) findViewById(R.id.resultEncrypt);
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        resultTextView.setText(res);

    }

    public void caesar(String text, int key) {
        final TextView resultTextView = (TextView) findViewById(R.id.resultEncrypt);
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                character = Character.toLowerCase(character);
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        resultTextView.setText(result);
    }
}
