package com.yxlh.fsearchhistory.jd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yxlh.fsearchhistory.R;
import com.yxlh.lib_search_history.FlowListView;

/**
 * @author zwl
 * @describe 折叠
 * @date on 2021/8/7
 */
public class JDFoldLayout extends FlowListView {
    private View upFoldView;
    private View downFoldView;

    public JDFoldLayout(Context context) {
        this(context, null);
    }

    public JDFoldLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JDFoldLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        upFoldView = LayoutInflater.from(context).inflate(R.layout.view_item_fold_up, null);
        downFoldView = LayoutInflater.from(context).inflate(R.layout.view_item_fold_down, null);
        upFoldView.setOnClickListener(v -> {
            mFold = false;
            flowAdapter.notifyDataChanged();
        });

        downFoldView.setOnClickListener(v -> {
            mFold = true;
            flowAdapter.notifyDataChanged();
        });

        setOnFoldChangedListener((canFold, fold, index, surplusWidth) -> {
            if (canFold) {
                removeFromParent(downFoldView);
                addView(downFoldView);
                if (fold) {
                    removeFromParent(upFoldView);
                    //当剩余空间大于等于展开View宽度直接加入index+1
                    if (width(upFoldView) > surplusWidth) {
                        addView(upFoldView, index);
                    } else { //当剩余空间小于展开View宽度直接加入index
                        addView(upFoldView, index + 1);
                    }
                } else {
                    removeFromParent(downFoldView);
                    addView(downFoldView);
                }
            }
        });
    }

    private int width(View view) {
        view.measure(0, 0);
        return view.getMeasuredWidth();
    }

    /**
     * 移除父布局中的子布局
     *
     * @param view
     */
    private void removeFromParent(View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
