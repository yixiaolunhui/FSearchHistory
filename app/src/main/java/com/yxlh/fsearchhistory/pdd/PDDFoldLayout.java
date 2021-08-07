package com.yxlh.fsearchhistory.pdd;

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
public class PDDFoldLayout extends FlowListView {
    private View upFoldView;

    public PDDFoldLayout(Context context) {
        this(context, null);
    }

    public PDDFoldLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PDDFoldLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        upFoldView = LayoutInflater.from(context).inflate(R.layout.view_item_fold_up_pdd, null);
        upFoldView.setOnClickListener(v -> {
            mFold = false;
            flowAdapter.notifyDataChanged();
        });
        setOnFoldChangedListener((canFold, fold, index, surplusWidth) -> {
            if (canFold) {
                if (fold) {
                    removeFromParent(upFoldView);
                    //当剩余空间大于等于展开View宽度直接加入index+1
                    if (width(upFoldView) > surplusWidth) {
                        addView(upFoldView, index);
                    } else { //当剩余空间小于展开View宽度直接加入index
                        addView(upFoldView, index + 1);
                    }
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
