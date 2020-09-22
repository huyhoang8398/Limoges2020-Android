package com.example.excersise2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DecryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
    }


    public void decrypt(View view) {
        final EditText decryptText = (EditText) findViewById(R.id.decryptText);
        String text = decryptText.getText().toString();
        StringBuilder result = new StringBuilder();
        if (text.isEmpty()) {
            Toast.makeText(this, "You need to enter text to encrypt", Toast.LENGTH_SHORT).show();
        }
        else {
            for (char character : text.toCharArray()) {
                if (character != ' ') {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + 23) % 26;
                    System.out.println(newAlphabetPosition);
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }
            }
            Intent intent = new Intent(DecryptActivity.this, ResultDecryptActivity.class);
            intent.putExtra("result", result.toString());
            startActivity(intent);
        }
    }
}
