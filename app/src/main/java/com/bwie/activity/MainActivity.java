package com.bwie.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.adapter.MyAdapter;
import com.bwie.fragment.SyFragment;
import com.bwie.fragment.WdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Thread.UncaughtExceptionHandler {

    private ViewPager viewPager;
    private TextView sy;
    private TextView wd;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        sy = findViewById(R.id.sy);
        wd = findViewById(R.id.wd);

        //设置两个布局
        list.add(new SyFragment());
        list.add(new WdFragment());

        //Framelayout
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));

        //滑动改变颜色
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //停止
                if (i == 0) {
                    //第一个
                    sy.setBackgroundColor(Color.RED);
                    sy.setTextColor(Color.WHITE);
                    wd.setBackgroundColor(Color.WHITE);
                    wd.setTextColor(Color.BLACK);
                } else {
                    sy.setBackgroundColor(Color.WHITE);
                    sy.setTextColor(Color.BLACK);
                    wd.setBackgroundColor(Color.RED);
                    wd.setTextColor(Color.WHITE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //在这里捕获异常
        //获取手机型号
        Log.i("catch", "手机型号："+Build.MODEL);
        //打印错误日志
        Log.i("catch", "错误日志："+e.getMessage());
    }
}
