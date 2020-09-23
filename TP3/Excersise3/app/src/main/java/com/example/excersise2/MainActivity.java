package com.example.excersise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToEncryptActivity(View view) {
        Intent intent = new Intent(this, EncryptActivity.class);
        startActivity(intent);
    }
    public void goToDecryptActivity(View view) {
        Intent intent = new Intent(this, DecryptActivity.class);
        startActivity(intent);
    }
}
