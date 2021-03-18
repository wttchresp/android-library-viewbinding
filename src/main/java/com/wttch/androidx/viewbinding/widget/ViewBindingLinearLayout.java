package com.wttch.androidx.viewbinding.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.wttch.androidx.viewbinding.util.InflateUtil;

/**
 * viewbinding 使用 LinearLayout 作为根自定义 View 时的基类.
 *
 * @param <VB> ViewBinding 的类型
 */
public abstract class ViewBindingLinearLayout<VB extends ViewBinding> extends
    LinearLayout implements ViewBindingStyleable {

  protected VB binding;

  public ViewBindingLinearLayout(Context context) {
    this(context, null);
  }

  public ViewBindingLinearLayout(Context context,
      @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ViewBindingLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    binding = InflateUtil.reflectInflate(getClass(), LayoutInflater.from(context), this, true);
    TypedArray array = context.obtainStyledAttributes(attrs, getStyleableRes());
    preform(array);
    array.recycle();
  }
}
