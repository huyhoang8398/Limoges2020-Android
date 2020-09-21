package com.example.excersise2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EncryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
    }

    public void encrypt(View view) {
        final EditText encryptText = (EditText) findViewById(R.id.encryptText);
        final EditText encryptKey = (EditText) findViewById(R.id.encryptKey);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.encryptRadioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        final RadioButton radioButton = (RadioButton) findViewById(selectedId);


        String text = encryptText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "You need to enter text to encrypt", Toast.LENGTH_SHORT).show();
        } else {
            if (radioButton.getText().equals("Caesar Cipher")) {
                if (TextUtils.isEmpty(encryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    caesar(text, Integer.parseInt(String.valueOf(encryptKey.getText())));
                }
            }
            if (radioButton.getText().equals("Vigenere Cipher")) {
                if (TextUtils.isEmpty(encryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    vigenere(text, encryptKey.toString());
                }
            }
        }
    }

    public void vigenere(String text, String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        Intent intent = new Intent(EncryptActivity.this, ResultEncryptActivity.class);
        intent.putExtra("result", res);
        startActivity(intent);
    }

    public void caesar(String text, int key) {
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
        Intent intent = new Intent(EncryptActivity.this, ResultEncryptActivity.class);
        intent.putExtra("result", result.toString());
        startActivity(intent);
    }
}
