package com.example.excersise2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultDecryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_result);

        Bundle data = getIntent().getExtras();
        assert data != null;
        Parameter parameter = (Parameter) data.getParcelable("param");

        assert parameter != null;
        if (parameter.getAlgo().equals("caesar")) {
            caesarDecrypt(parameter.getPlainText(), Integer.parseInt(parameter.getKey()));
        } else {
            vigenereDecrypt(parameter.getPlainText(), parameter.getKey());
        }
    }

    public void vigenereDecrypt(String text, String key) {
        final TextView resultTextView = (TextView) findViewById(R.id.resultDecrypt);
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

    public void caesarDecrypt(String text, int key) {
        key = 26 - (key % 26);
        final TextView resultTextView = (TextView) findViewById(R.id.resultDecrypt);
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
