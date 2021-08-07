package com.yxlh.lib_search_history;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @describe 流布局适配器
 * @date on 2020/12/31
 */
public abstract class FlowAdapter<T> {

    private OnDataChangedListener onDataChangedListener;

    private List<T> data;

    /**
     * 子View创建
     *
     * @param parent
     * @param item
     * @param position
     * @return
     */
    public abstract View getView(ViewGroup parent, T item, int position);

    /**
     * 初始化View
     *
     * @param view
     * @param item
     * @param position
     * @return
     */
    public abstract void initView(View view, T item, int position);


    /**
     * 折叠View 默认不设置
     *
     * @return
     */
    public View foldView() {
        return null;
    }


    /**
     * 数据的数量
     *
     * @return
     */
    public int getCount() {
        return this.data == null ? 0 : this.data.size();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<T> getData() {
        return data;
    }


    /**
     * 设置新数据
     *
     * @param data
     */
    public void setNewData(List<T> data) {
        this.data = data;
        notifyDataChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(List<T> data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.addAll(data);
        notifyDataChanged();
    }

    /**
     * 添加数据
     *
     * @param index
     * @param data
     */
    public void addData(int index, List<T> data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.addAll(index, data);
        notifyDataChanged();
    }


    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(T data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(data);
        notifyDataChanged();
    }


    /**
     * 获取指定位置的数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        if (this.data != null && position >= 0 && position < this.data.size()) {
            return this.data.get(position);
        }
        return null;
    }


    /**
     * 刷新数据
     */
    public void notifyDataChanged() {
        if (this.onDataChangedListener != null) {
            this.onDataChangedListener.onChanged();
        }
    }

    void setOnDataChangedListener(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }

    interface OnDataChangedListener {
        void onChanged();
    }


}
