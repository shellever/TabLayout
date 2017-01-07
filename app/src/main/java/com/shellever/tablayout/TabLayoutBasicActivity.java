package com.shellever.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//
// TabLayout
// compile 'com.android.support:design:25.1.0'
//
public class TabLayoutBasicActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    private RadioGroup mTabModeRg;
    private RadioButton mFixedModeRb;
    private RadioButton mScrollableModeRb;

    private RadioGroup mTabGravityRg;
    private RadioButton mFillGravityTb;
    private RadioButton mCenterGravityTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_basic);

        mTabLayout = (TabLayout) findViewById(R.id.tl_tab_layout);

        TabLayout.Tab mChatsTab = mTabLayout.newTab().setText("Chats");
        mTabLayout.addTab(mChatsTab);

        TabLayout.Tab mContactsTab = mTabLayout.newTab().setText("Contacts");
        mTabLayout.addTab(mContactsTab);

        TabLayout.Tab mDiscoverTab = mTabLayout.newTab().setText("Discover");
        //mTabLayout.addTab(mDiscoverTab);          // 默认第一个项被选中
        mTabLayout.addTab(mDiscoverTab, true);      // 设置为默认选中项

        // TabMode
        // TabLayout.MODE_FIXED
        // TabLayout.MODE_SCROLLABLE
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);   // default

        // setOnTabSelectedListener()方法已过时
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabLayoutBasicActivity.this, "Selected: " + tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // TabMode
        mFixedModeRb = (RadioButton) findViewById(R.id.rb_mode_fixed);
        mScrollableModeRb = (RadioButton) findViewById(R.id.rb_mode_scrollable);
        mTabModeRg = (RadioGroup) findViewById(R.id.rg_tab_mode);
        mTabModeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_mode_fixed:
                        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
                        break;
                    case R.id.rb_mode_scrollable:
                        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                        break;
                }
            }
        });

        // TabGravity (只在TabMode为TabLayout.MODE_FIXED时才会生效)
        mFillGravityTb = (RadioButton) findViewById(R.id.rb_gravity_fill);
        mCenterGravityTb = (RadioButton) findViewById(R.id.rb_gravity_center);
        mTabGravityRg = (RadioGroup) findViewById(R.id.rg_tab_gravity);
        mTabGravityRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_gravity_fill:
                        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                        break;
                    case R.id.rb_gravity_center:
                        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                        break;
                }
            }
        });
    }
}
