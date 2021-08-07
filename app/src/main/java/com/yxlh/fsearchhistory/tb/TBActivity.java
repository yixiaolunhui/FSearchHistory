package com.yxlh.fsearchhistory.tb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yxlh.fsearchhistory.R;
import com.yxlh.fsearchhistory.adapter.SearchHistoryAdapter;
import com.yxlh.fsearchhistory.utils.DataUtils;

public class TBActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, TBActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb);
        setTitle("淘宝搜索历史");
        initView();
    }

    private void initView() {
        TBFoldLayout flowListView = findViewById(R.id.flow_list);
        SearchHistoryAdapter adapter = new SearchHistoryAdapter();
        adapter.setNewData(DataUtils.getHistoryList());
        flowListView.setAdapter(adapter);
    }

}