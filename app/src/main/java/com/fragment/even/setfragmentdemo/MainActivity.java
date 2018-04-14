package com.fragment.even.setfragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        init();
    }

    PlusOneFragment one = new PlusOneFragment();
    PlusTwoFragment two = new PlusTwoFragment();
    PlusThreeFragment three = new PlusThreeFragment();
    PlusFourFragment four = new PlusFourFragment();
    Button button01, button02, button03, button04;

    private void init() {
        transaction(one).commit();
        button01 = (Button) findViewById(R.id.bt_01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction(one).commit();
//                LoandFragment(one);
                Log.i("md","button01");
            }
        });
        button02 = (Button) findViewById(R.id.bt_02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction(two).commit();
//                LoandFragment(two);
                Log.i("md","button02");
            }
        });
        button03 = (Button) findViewById(R.id.bt_03);
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction(three).commit();
//                LoandFragment(three);
                Log.i("md","button03");
            }
        });
        button04 = (Button) findViewById(R.id.bt_04);
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction(four).commit();
//                LoandFragment(four);
                Log.i("md","button04");
            }
        });
    }

    private  void  LoandFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commitAllowingStateLoss();
    }



    private Fragment currentFragment = new Fragment();
    //Fragment优化
    private FragmentTransaction transaction(Fragment targetFragment) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.fragment, targetFragment, targetFragment.getClass().getName());

        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }


}
