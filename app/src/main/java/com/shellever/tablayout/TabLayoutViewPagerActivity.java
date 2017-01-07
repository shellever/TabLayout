package com.shellever.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabLayoutViewPagerActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private String[] mTitleArray = {"Chats", "Contacts", "Discover", "Me"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_view_pager);

        // ViewPager
        mViewPager = (ViewPager) findViewById(R.id.vp_pager);
        TabPagerAdapter adapter = new TabPagerAdapter();
        mViewPager.setAdapter(adapter);

        // TabLayout
        mTabLayout = (TabLayout) findViewById(R.id.tl_tab);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);    // 默认模式，可以不设置
        mTabLayout.setupWithViewPager(mViewPager);      // ViewPager <---> TabLayout
    }

    // 自定义ViewPager页面适配器
    public class TabPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mTitleArray.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(TabLayoutViewPagerActivity.this);
            tv.setText(mTitleArray[position]);
            tv.setGravity(Gravity.CENTER);
            container.addView(tv, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleArray[position];
        }
    }
}
