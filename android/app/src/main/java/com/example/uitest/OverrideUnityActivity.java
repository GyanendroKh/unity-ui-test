package com.example.uitest;

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public class OverrideUnityActivity extends UnityPlayerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        handleIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        setIntent(intent);
    }

    void handleIntent(Intent intent) {
        if (intent == null || intent.getExtras() == null) return;

        if (intent.getExtras().containsKey("doQuit")) {
            if (mUnityPlayer != null) {
                finish();
            }
        }
    }

    protected void showMainActivity(String setToColor) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("setColor", setToColor);
        startActivity(intent);
    }

    @Override
    public void onUnityPlayerUnloaded() {
        showMainActivity("");
    }
}
