package com.yxlh.fsearchhistory.jd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.yxlh.fsearchhistory.R;
import com.yxlh.fsearchhistory.adapter.SearchHistoryAdapter;
import com.yxlh.fsearchhistory.tb.TBActivity;
import com.yxlh.fsearchhistory.utils.Utils;

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
        adapter.setNewData(Utils.getHistoryList());
        flowListView.setAdapter(adapter);

        AppCompatEditText et = findViewById(R.id.et);
        AppCompatButton add = findViewById(R.id.add);
        add.setOnClickListener(v -> {
            String content = et.getText().toString();
            if (TextUtils.isEmpty(content)) {
                Toast.makeText(JDActivity.this, "请输入内容", Toast.LENGTH_LONG).show();
                return;
            }
            adapter.addData(content);
        });

    }


}