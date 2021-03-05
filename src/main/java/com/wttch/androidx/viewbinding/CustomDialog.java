package com.wttch.androidx.viewbinding;

import android.content.Context;
import androidx.viewbinding.ViewBinding;
import com.wttch.androidx.viewbinding.util.InflateUtil;
import org.jetbrains.annotations.NotNull;

/**
 * 通用的弹窗模块, 由于使用泛型获取参数实际类型并初始化, 所以设置为抽象类, 为了获取实际的 ViewBinding 类型.
 *
 * @param <VB> ViewBinding 的类型
 */
public abstract class CustomDialog<VB extends ViewBinding> extends ViewBindingDialog<VB> {

  public CustomDialog(@NotNull Context context) {
    super(context, R.style.CustomDialog);
  }

  @NotNull
  @Override
  public VB bindingView() {
    return InflateUtil.reflectInflate(getClass(), getLayoutInflater());
  }
}
