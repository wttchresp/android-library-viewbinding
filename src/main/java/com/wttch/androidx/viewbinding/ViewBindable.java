package com.wttch.androidx.viewbinding;

import androidx.viewbinding.ViewBinding;
import org.jetbrains.annotations.NotNull;

/**
 * 所用使用 BindingView 的公共接口.
 */
public interface ViewBindable<Binding extends ViewBinding> {

  /**
   * 返回页面的 BindingView
   */
  @NotNull
  Binding bindingView();
}
