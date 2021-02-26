package com.wttch.androidx.viewbinding;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.wttch.android.widget.BaseListAdapter;
import java.util.List;

/**
 * 自带 ViewHolder 的ListAdapter.
 */
public abstract class BaseRecyclerListAdapter<T, VB extends ViewBinding> extends
    BaseListAdapter<T> {

  public BaseRecyclerListAdapter(Context context) {
    super(context);
  }

  public BaseRecyclerListAdapter(Context context, List<T> data) {
    super(context, data);
  }

  public BaseRecyclerListAdapter(Context context, T[] data) {
    super(context, data);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    VB binding;
    if (convertView == null) {
      binding = newView(parent);
      convertView = binding.getRoot();
      convertView.setTag(binding);
    } else {
      binding = bindingClass().cast(convertView.getTag());
    }
    T item = getItem(position);
    convertView(binding, item, position);
    return convertView;
  }

  /**
   * 返回 ViewBinding 的类型
   *
   * @return ViewBinding 的类型
   */
  public abstract Class<VB> bindingClass();

  /**
   * 新建一个 ViewBinding
   *
   * @return 新建的 ViewBinding
   */
  public abstract VB newView(ViewGroup parent);

  /**
   * 转换布局, 填充页面数据
   *
   * @param binding  ViewBinding 的对象
   * @param item     数据
   * @param position 位置
   */
  public abstract void convertView(@NonNull VB binding, @NonNull T item, int position);
}
