package com.wttch.androidx.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * 使用 BindingView 的 Activity 的基类.
 */
abstract class ViewBindingActivity<Binding : ViewBinding> : AppCompatActivity(), ViewBindable<Binding> {
  protected lateinit var binding: Binding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = bindingView()
    setContentView(binding.root)
  }
}
