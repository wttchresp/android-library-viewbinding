package com.wttch.androidx.viewbinding

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

/**
 * 使用 BindingView 的 FragmentActivity 的基类.
 */
abstract class ViewBindingFragmentActivity<Binding : ViewBinding> : FragmentActivity(), ViewBindable<Binding> {

  protected lateinit var binding: Binding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = bindingView()
    setContentView(binding.root)
  }
}