package com.example.excersise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        String text = encryptText.getText().toString();
        StringBuilder result = new StringBuilder();
        if (text.isEmpty()) {
            Toast.makeText(this, "You need to enter text to encrypt", Toast.LENGTH_SHORT).show();
        }
        else {
            for (char character : text.toCharArray()) {
                if (character != ' ') {
                    character = Character.toLowerCase(character);
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + 3) % 26;
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
}
