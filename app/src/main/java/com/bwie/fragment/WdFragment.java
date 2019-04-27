package com.bwie.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.R;

import java.util.PriorityQueue;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/27 8:55
 * Description:
 */
public class WdFragment extends Fragment {

    private ImageView iv_icon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        View view = View.inflate(getContext(), R.layout.fragment_wd, null);

        iv_icon = view.findViewById(R.id.iv_icon);

        //点击这个报错 看信息
        view.findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = null;
                str.concat("123");
            }
        });

        view.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //属性动画  组合动画 translateY
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator translateY = ObjectAnimator.ofFloat(iv_icon,
                        "TranslationY", 0, 100);
                ObjectAnimator rotate_self = ObjectAnimator.ofFloat(iv_icon,
                        "RotationX", 0, 360);
                //组合动画
                animatorSet.setDuration(2000);
                animatorSet.play(translateY).before(rotate_self);
                animatorSet.start();
            }
        });

        return view;
    }
}
