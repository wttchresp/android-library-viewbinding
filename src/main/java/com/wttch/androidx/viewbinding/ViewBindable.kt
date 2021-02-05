package com.wttch.androidx.viewbinding

import androidx.viewbinding.ViewBinding

/**
 * 所用使用 BindingView 的公共接口.
 */
interface ViewBindable<Binding : ViewBinding> {

  /**
   * 返回页面的 BindingView
   */
  fun bindingView(): Binding
}