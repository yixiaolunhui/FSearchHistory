package com.yxlh.fsearchhistory.pdd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.yxlh.fsearchhistory.R;
import com.yxlh.fsearchhistory.utils.Utils;
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
                    Utils.removeFromParent(upFoldView);
                    addView(upFoldView, index(index, surplusWidth));
                }
            }
        });
    }

    private int index(int index, int surplusWidth) {
        int upIndex = index;
        int upWidth = Utils.getViewWidth(upFoldView);
        //当剩余空间大于等于展开View宽度直接加入index+1
        if (surplusWidth >= upWidth) {
            upIndex = index + 1;
        } else { //找到对应的位置
            for (int i = index; i >= 0; i--) {
                View view = getChildAt(index);
                int viewWidth = Utils.getViewWidth(view);
                upWidth -= viewWidth;
                if (upWidth <= 0) {
                    upIndex = i;
                    break;
                }
            }
        }
        return upIndex;
    }
}
