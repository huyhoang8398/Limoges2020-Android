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
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        final TextView resultTextView = (TextView) findViewById(R.id.resultEncrypt);
        resultTextView.setText(result);
    }
}
