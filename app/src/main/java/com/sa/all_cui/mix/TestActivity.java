package com.sa.all_cui.mix;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sa.all_cui.quick_lib.fix.screenlock.ScreenLockManager;

public class TestActivity extends AppCompatActivity {

    private ScreenLockManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        manager = new ScreenLockManager(this, MixApp.getMixApp());
    }

    @Override
    protected void onStart() {
        super.onStart();
        manager.onStart(getSupportFragmentManager());
    }

    public void toDisplaySetting(View v) {
        Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.onUnRegisterBroadcast();
    }
}
