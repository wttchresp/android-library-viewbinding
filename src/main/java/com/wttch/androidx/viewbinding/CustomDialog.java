package com.wttch.androidx.viewbinding;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.DimenRes;
import androidx.viewbinding.ViewBinding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 通用的 ViewBinding 绑定的对话框.
 *
 * @param <Binding> 绑定的 ViewBinding 类型
 */
public class CustomDialog<Binding extends ViewBinding> extends ViewBindingDialog<Binding> {

  /**
   * 使用构建器构建通用的对话框
   *
   * @param builder 构建器对象
   */
  private CustomDialog(Builder<Binding> builder) {
    super(builder.context, R.style.CustomDialog);
    setCancelable(builder.cancelable);
    setOnCancelListener(builder.cancelListener);
    width(builder.width);
    height(builder.height);
    this.binding = builder.binding;
  }

  @NotNull
  @Override
  public Binding bindingView() {
    return binding;
  }

  /**
   * CustomDialog 使用的构建器
   *
   * @param context   android 上下文
   * @param binding   ViewBinding 对象
   * @param <Binding> ViewBinding 类型
   */
  public static <Binding extends ViewBinding> Builder<Binding> builder(Context context,
      Binding binding) {
    return new Builder<>(context, binding);
  }

  public static class Builder<Binding extends ViewBinding> {

    private final Context context;
    private final Binding binding;
    private int width;
    private int height;
    private boolean cancelable = false;
    @Nullable
    private DialogInterface.OnCancelListener cancelListener;

    public Builder(Context context, Binding binding) {
      this.context = context;
      this.binding = binding;
    }

    public CustomDialog<Binding> build() {
      return new CustomDialog<>(this);
    }

    public Builder<Binding> width(@DimenRes int width) {
      this.width = width;
      return this;
    }

    public Builder<Binding> height(@DimenRes int height) {
      this.height = height;
      return this;
    }

    public Builder<Binding> cancelable(boolean cancelable) {
      this.cancelable = cancelable;
      return this;
    }

    public Builder<Binding> cancelListener(
        @Nullable DialogInterface.OnCancelListener cancelListener) {
      this.cancelListener = cancelListener;
      return this;
    }

  }
}
