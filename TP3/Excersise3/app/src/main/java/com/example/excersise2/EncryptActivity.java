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
        String key = encryptKey.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "You need to enter text to encrypt", Toast.LENGTH_SHORT).show();
        } else {
            if (radioButton.getText().equals("Caesar Cipher")) {
                if (TextUtils.isEmpty(encryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(EncryptActivity.this, ResultEncryptActivity.class);
                    intent.putExtra("param", new Parameter(text, key, "encrypt", "caesar"));
                    startActivity(intent);
                }
            }
            if (radioButton.getText().equals("Vigenere Cipher")) {
                if (TextUtils.isEmpty(encryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(EncryptActivity.this, ResultEncryptActivity.class);
                    intent.putExtra("param", new Parameter(text, key, "encrypt", "vigenere"));
                    startActivity(intent);
                }
            }
        }
    }


}
