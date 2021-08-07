package com.yxlh.fsearchhistory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;

import com.yxlh.fsearchhistory.R;
import com.yxlh.lib_search_history.FlowAdapter;

/**
 * @author zwl
 * @date on 2021/8/5
 */
public class SearchHistoryAdapter extends FlowAdapter<String> {

    @Override
    public View getView(ViewGroup parent, String item, int position) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_history, null);
    }

    @Override
    public void initView(View view, String item, int position) {
        AppCompatTextView textView = view.findViewById(R.id.item_tv);
        textView.setText(item);
        textView.setOnClickListener(v -> Toast.makeText(view.getContext(), item, Toast.LENGTH_SHORT).show());
    }
}
