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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


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
        final EditText encryptFile = (EditText) findViewById(R.id.encryptFile);

        String file = encryptFile.getText().toString();
        String text = encryptText.getText().toString();
        String key = encryptKey.getText().toString();
        if (text.isEmpty() && file.isEmpty()) {
            Toast.makeText(this, "You need to enter text or filename to encrypt", Toast.LENGTH_SHORT).show();
        } else if (file.isEmpty()) {
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
        } else {
            InputStream ins = getResources().openRawResource(
                    getResources().getIdentifier(file,
                            "raw", getPackageName()));
            String sxml = readTextFile(ins);
            if (radioButton.getText().equals("Caesar Cipher")) {
                if (TextUtils.isEmpty(encryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(EncryptActivity.this, ResultEncryptActivity.class);
                    intent.putExtra("param", new Parameter(sxml, key, "encrypt", "caesar"));
                    startActivity(intent);
                }
            }
            if (radioButton.getText().equals("Vigenere Cipher")) {
                if (TextUtils.isEmpty(encryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(EncryptActivity.this, ResultEncryptActivity.class);
                    intent.putExtra("param", new Parameter(sxml, key, "encrypt", "vigenere"));
                    startActivity(intent);
                }
            }
        }
    }
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
