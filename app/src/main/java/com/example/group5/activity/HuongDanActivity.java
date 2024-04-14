package com.example.group5.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.group5.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HuongDanActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan);

        TextView txtHuongDan = findViewById(R.id.textViewHuongDan);
        String textContent = readTextFileFromAssets();
        txtHuongDan.setText(textContent);
    }

    private String readTextFileFromAssets() {
        StringBuilder text = new StringBuilder();

        try {
            InputStream is = getAssets().open("Readme.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append('\n');
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.toString();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textViewHuongDan) {
            startActivity(new Intent(getApplicationContext(), HuongDanActivity.class));
        }
    }
}