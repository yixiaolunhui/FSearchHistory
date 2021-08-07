package com.yxlh.lib_search_history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author zwl
 * @describe 流布局
 * @date on 2020/12/31
 */
public class FlowListView extends FlowLayout implements FlowAdapter.OnDataChangedListener {

    protected FlowAdapter flowAdapter;

    public FlowListView(Context context) {
        super(context);
    }

    public FlowListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setAdapter(FlowAdapter tagAdapter) {
        this.flowAdapter = tagAdapter;
        this.flowAdapter.setOnDataChangedListener(this);
        updateView();
    }

    @Override
    public void onChanged() {
        updateView();
    }


    private void updateView() {
        removeAllViews();
        if (null == flowAdapter) {
            throw new RuntimeException("adapter cannot be empty");
        }
        int count = flowAdapter.getCount();

        for (int i = 0; i < count; i++) {
            View tagView = flowAdapter.getView(this, flowAdapter.getItem(i), i);
            tagView.setTag(flowAdapter.getItem(i));
            flowAdapter.initView(tagView, flowAdapter.getItem(i), i);
            addView(tagView);
        }
    }



}
