package com.example.excersise2;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

public class EncryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
    }

    public void encryptCaesar(View view) throws JSONException {
        final EditText encryptText = (EditText) findViewById(R.id.encryptText);
        String textToEncrypt = encryptText.getText().toString();
        JSONArray jsonArray = new JSONArray(textToEncrypt);
        String[] strArr = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            strArr[i] = jsonArray.getString(i);
        }

        System.out.println(Arrays.toString(strArr));
    }

}
