package com.yxlh.fsearchhistory.jd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yxlh.fsearchhistory.R;
import com.yxlh.fsearchhistory.adapter.SearchHistoryAdapter;
import com.yxlh.fsearchhistory.utils.DataUtils;

/**
 * 京东搜索历史
 */
public class JDActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, JDActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jd);
        setTitle("京东搜索历史");
        initView();
    }


    private void initView() {
        JDFoldLayout flowListView = findViewById(R.id.flow_list);
        SearchHistoryAdapter adapter = new SearchHistoryAdapter();
        adapter.setNewData(DataUtils.getHistoryList());
        flowListView.setAdapter(adapter);
    }


}