package com.yxlh.fsearchhistory.jd;

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
public class JDFoldLayout extends FlowListView {
    private View upFoldView;
    private View downFoldView;
    private boolean canFold;
    private boolean fold;
    private int index;
    private int surplusWidth;

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
            this.canFold = canFold;
            this.fold = fold;
            this.index = index;
            this.surplusWidth = surplusWidth;
            refreshFoldView();
        });
    }

    @Override
    public void updateView() {
        super.updateView();
        refreshFoldView();
    }

    private void refreshFoldView() {
        Utils.removeFromParent(upFoldView);
        Utils.removeFromParent(downFoldView);
        if (canFold) {
            addView(downFoldView);
            if (fold) {
                Utils.removeFromParent(upFoldView);
                int upIndex = index(index, surplusWidth);
                addView(upFoldView, upIndex);
            } else {
                Utils.removeFromParent(downFoldView);
                addView(downFoldView);
            }
        }
    }

    private int index(int index, int surplusWidth) {
        int upIndex = index;
        int upWidth = Utils.getViewWidth(upFoldView);
        //当剩余空间大于等于展开View宽度直接加入index+1
        if (surplusWidth >= upWidth) {
            upIndex = index + 1;
        } else { //找到对应的位置
            for (int i = index; i >= 0; i--) {
                View view = getChildAt(i);
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
