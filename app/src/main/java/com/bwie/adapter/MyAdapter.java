package com.bwie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/27 8:57
 * Description:
 */
public class MyAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MyAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
