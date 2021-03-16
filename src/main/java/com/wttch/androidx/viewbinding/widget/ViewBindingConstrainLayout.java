package com.wttch.androidx.viewbinding.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.wttch.androidx.viewbinding.util.InflateUtil;

/**
 * viewbinding 使用 ConstrainLayout 作为根自定义 View 时的基类.
 *
 * @param <VB> ViewBinding 的类型
 */
public abstract class ViewBindingConstrainLayout<VB extends ViewBinding> extends
    ConstraintLayout implements ViewBindingStyleable {

  protected VB binding;


  public ViewBindingConstrainLayout(@NonNull Context context) {
    this(context, null);
  }

  public ViewBindingConstrainLayout(@NonNull Context context,
      @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ViewBindingConstrainLayout(@NonNull Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    binding = InflateUtil.reflectInflate(getClass(), LayoutInflater.from(context), this, true);
    TypedArray array = context.obtainStyledAttributes(attrs, getStyleableRes());
    preform(array);
    array.recycle();
  }
}
