package com.lzr.taoke.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzr.taoke.R;
import com.lzr.taoke.view.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/6/15.
 *
 */

public class MessageFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_layout,null);

        return view;
    }
}
