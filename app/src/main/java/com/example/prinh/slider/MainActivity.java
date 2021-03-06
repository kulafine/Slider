package com.example.prinh.slider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView[] dots;
    private Button next;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.pager);
        next = (Button)findViewById(R.id.next);
        linearLayout = (LinearLayout)findViewById(R.id.layoutdots);
        viewPager.setAdapter(new SimplePagerAdapter(getSupportFragmentManager()));
        addDots(0);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem()+1;
                if (current<2){
                    viewPager.setCurrentItem(1);
                }else{
                    //launch home Activity
                }


            }
        });



    }
    public  int getItem(){
        return viewPager.getCurrentItem();
    }
    private void addDots(int CurrentPosition){
        dots = new TextView[6];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        linearLayout.removeAllViews();
        for (int i =0;i<6;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#45;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[CurrentPosition]);
            linearLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[CurrentPosition].setTextColor(colorsActive[CurrentPosition]);

    }

    ViewPager.OnPageChangeListener viewPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            addDots(position);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public class SimplePagerAdapter extends FragmentPagerAdapter {


        public SimplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            switch (position){
                case 0:
                    return new Frag1();
                case 1:
                    return new Frag2();
                case 2:
                    return new Frag3();
                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
