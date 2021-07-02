package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton mUnityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUnityBtn = findViewById(R.id.showUnityBtn);
        mUnityBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OverrideUnityActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            startActivityForResult(intent, 1);
        });
    }


    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
