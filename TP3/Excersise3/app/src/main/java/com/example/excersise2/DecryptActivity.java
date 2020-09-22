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

public class DecryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
    }

    public void decrypt(View view) {
        final EditText decryptText = (EditText) findViewById(R.id.decryptText);
        final EditText decryptKey = (EditText) findViewById(R.id.decryptKey);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.decryptRadioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        final RadioButton radioButton = (RadioButton) findViewById(selectedId);


        String text = decryptText.getText().toString();
        String key = decryptKey.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "You need to enter text to decrypt", Toast.LENGTH_SHORT).show();
        } else {
            if (radioButton.getText().equals("Caesar Cipher Decrypt")) {
                if (TextUtils.isEmpty(decryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DecryptActivity.this, ResultDecryptActivity.class);
                    intent.putExtra("param", new Parameter(text, key, "decrypt", "caesar"));
                    startActivity(intent);
                }
            }
            if (radioButton.getText().equals("Vigenere Cipher Decrypt")) {
                if (TextUtils.isEmpty(decryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DecryptActivity.this, ResultDecryptActivity.class);
                    intent.putExtra("param", new Parameter(text, key, "decrypt", "vigenere"));
                    startActivity(intent);
                }
            }
        }
    }
}
