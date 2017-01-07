package com.shellever.tablayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//
// TabLayout
// compile 'com.android.support:design:25.1.0'
//
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_tab_layout_basic).setOnClickListener(this);
        findViewById(R.id.btn_tab_layout_view_pager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_tab_layout_basic:
                intent = new Intent(MainActivity.this, TabLayoutBasicActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tab_layout_view_pager:
                intent = new Intent(MainActivity.this, TabLayoutViewPagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
