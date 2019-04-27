package com.bwie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.R;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/27 8:55
 * Description:
 */
public class SyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        View view = View.inflate(getContext(), R.layout.fragment_sy, null);

        return view;

    }
}
