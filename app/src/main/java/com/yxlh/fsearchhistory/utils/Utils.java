package com.yxlh.fsearchhistory.utils;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @date on 2021/8/7
 */
public class Utils {
    public static List<String> getHistoryList() {
        List<String> historyList = new ArrayList<>();
        historyList.add("衣服");
        historyList.add("T恤宽松男");
        historyList.add("男鞋");
        historyList.add("香蕉苹果");
        historyList.add("休闲裤");
        historyList.add("牛仔裤");
        historyList.add("红薯");
        historyList.add("西红柿");
        historyList.add("玩具大白");
        historyList.add("丝绵被");
        historyList.add("保温杯");
        historyList.add("花生油");
        historyList.add("折叠椅");
        historyList.add("小米笔记本");
        historyList.add("三星手机");
        historyList.add("显示器");
        historyList.add("小风扇");
        historyList.add("卫生纸");
        historyList.add("视频教程");
        historyList.add("学习");
        return historyList;
    }


    public static  int getViewWidth(View view) {
        view.measure(0, 0);
        return view.getMeasuredWidth();
    }

    /**
     * 移除父布局中的子布局
     *
     * @param view
     */
    public static void removeFromParent(View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
