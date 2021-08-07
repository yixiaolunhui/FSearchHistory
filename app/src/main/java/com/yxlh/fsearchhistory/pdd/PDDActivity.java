package com.yxlh.fsearchhistory.pdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yxlh.fsearchhistory.R;
import com.yxlh.fsearchhistory.adapter.SearchHistoryAdapter;
import com.yxlh.fsearchhistory.utils.Utils;

/**
 * 拼多多
 */
public class PDDActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, PDDActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdd);
        setTitle("拼多多搜索历史");
        initView();
    }

    private void initView() {
        PDDFoldLayout flowListView = findViewById(R.id.flow_list);
        SearchHistoryAdapter adapter = new SearchHistoryAdapter();
        adapter.setNewData(Utils.getHistoryList());
        flowListView.setAdapter(adapter);
    }

}