package com.yxlh.fsearchhistory;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.yxlh.fsearchhistory.jd.JDActivity;
import com.yxlh.fsearchhistory.pdd.PDDActivity;
import com.yxlh.fsearchhistory.tb.TBActivity;

/**
 * @author yxlh
 * @date on 2021/6/5
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 淘宝
     *
     * @param view
     */
    public void tbClick(View view) {
        TBActivity.start(this);
    }

    /**
     * 京东
     *
     * @param view
     */
    public void jdClick(View view) {
        JDActivity.start(this);
    }

    /**
     * 拼多多
     *
     * @param view
     */
    public void pddClick(View view) {
        PDDActivity.start(this);
    }
}
