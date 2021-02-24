package com.wttch.androidx.viewbinding

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.wttch.android.util.SizeUtils

abstract class ViewBindingDialog<Binding : ViewBinding>(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?)
  : Dialog(context, cancelable, cancelListener), ViewBindable<Binding> {
  protected lateinit var binding: Binding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = bindingView()
    setContentView(binding.root)

    setCanceledOnTouchOutside(true)

    window?.let {
      val lp = it.attributes
      lp.height = SizeUtils.dp2px(200f)
      lp.width = SizeUtils.dp2px(300f)
      it.attributes = lp
    }
  }
}