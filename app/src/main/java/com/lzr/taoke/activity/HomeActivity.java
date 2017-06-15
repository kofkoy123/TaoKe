package com.lzr.taoke.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lzr.taoke.R;
import com.lzr.taoke.activity.base.BaseActivity;
import com.lzr.taoke.view.fragment.home.HomeFragmet;
import com.lzr.taoke.view.fragment.home.MessageFragment;
import com.lzr.taoke.view.fragment.home.MineFragment;

/**
 * @function 创建首页所有fragment
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener{

    private HomeFragmet mHomeFragmet;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private FragmentManager fm;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;
    private TextView mHomeText;
    private TextView mMessageText;
    private TextView mMineText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initViews();
        //显示首页fragment
        mHomeFragmet = new HomeFragmet();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        //添加显示homefragment.replace 先remove 再add
        fragmentTransaction.replace(R.id.content_layout,mHomeFragmet);
        fragmentTransaction.commit();
        changeFontColor(mHomeText);
    }



    @Override
    public void onClick(View view) {
        //开始
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()){
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                changeFontColor(mHomeText);
                //先隐藏没有点击的fragment
                hideFragment(mMessageFragment,ft);
                hideFragment(mMineFragment,ft);
                //如果没创建fragment 就创建并添加,有就直接显示
                if (mHomeFragmet == null){
                    mHomeFragmet = new HomeFragmet();
                    ft.add(R.id.content_layout,mHomeFragmet);
                }else {
                    ft.show(mHomeFragmet);
                }

                break;
            case R.id.message_layout_view:
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                changeFontColor(mMessageText);
                //先隐藏没有点击的fragment
                hideFragment(mHomeFragmet,ft);
                hideFragment(mMineFragment,ft);
                //如果没创建fragment 就创建并添加,有就直接显示
                if (mMessageFragment == null){
                    mMessageFragment = new MessageFragment();
                    ft.add(R.id.content_layout,mMessageFragment);
                }else {
                    ft.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                changeFontColor(mMineText);
                //先隐藏没有点击的fragment
                hideFragment(mHomeFragmet,ft);
                hideFragment(mMessageFragment,ft);
                //如果没创建fragment 就创建并添加,有就直接显示
                if (mMineFragment == null){
                    mMineFragment = new MineFragment();
                    ft.add(R.id.content_layout,mMineFragment);
                }else {
                    ft.show(mMineFragment);
                }
                break;
        }
        //关闭
        ft.commit();
    }

    private void changeFontColor(TextView tv){
        mHomeText.setTextColor(getResources().getColor(R.color.color_333333));
        mMessageText.setTextColor(getResources().getColor(R.color.color_333333));
        mMineText.setTextColor(getResources().getColor(R.color.color_333333));
        tv.setTextColor(getResources().getColor(R.color.color_fed952));
    }

    /**
     *  隐藏fragment
     * @param fragment 需要隐藏对象
     * @param ft  运输器
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null){
            ft.hide(fragment);
        }

    }

    private void initViews() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
        mHomeText = (TextView)findViewById(R.id.home_textview_view);
        mMessageText = (TextView) findViewById(R.id.message_textview_view);
        mMineText = (TextView) findViewById(R.id.mine_textview_view);
    }
}
