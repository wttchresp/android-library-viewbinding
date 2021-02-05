package com.wttch.androidx.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * 使用 ViewBinding 的 Fragment 的泛型基类.
 * 继承该类会自动加载布局, 并可以通过调用[binding]来获取 ViewBinding 页面布局信息.
 *
 * @param T 布局文件自动生成的 ViewBinding 类
 */
abstract class ViewBindingFragment<T : ViewBinding> : Fragment() {
  protected lateinit var binding: T

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = createView(inflater, container)
    return binding.root
  }

  /**
   * 生成[T]类型的 ViewBinding 绑定对象.
   */
  protected abstract fun createView(inflater: LayoutInflater, container: ViewGroup?): T

}