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
        final EditText decryptFile = (EditText) findViewById(R.id.decryptFile);

        String file = decryptFile.getText().toString();
        String text = decryptText.getText().toString();
        String key = decryptKey.getText().toString();

        if (text.isEmpty() && file.isEmpty()) {
            Toast.makeText(this, "You need to enter text to decrypt", Toast.LENGTH_SHORT).show();
        } else if (file.isEmpty()){
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
        } else {
            InputStream ins = getResources().openRawResource(
                    getResources().getIdentifier(file,
                            "raw", getPackageName()));
            String sxml = readTextFile(ins);
            if (radioButton.getText().equals("Caesar Cipher Decrypt")) {
                if (TextUtils.isEmpty(decryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DecryptActivity.this, ResultDecryptActivity.class);
                    intent.putExtra("param", new Parameter(sxml, key, "decrypt", "caesar"));
                    startActivity(intent);
                }
            }
            if (radioButton.getText().equals("Vigenere Cipher Decrypt")) {
                if (TextUtils.isEmpty(decryptKey.getText().toString())) {
                    Toast.makeText(this, "You need to enter the key", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DecryptActivity.this, ResultDecryptActivity.class);
                    intent.putExtra("param", new Parameter(sxml, key, "decrypt", "vigenere"));
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
