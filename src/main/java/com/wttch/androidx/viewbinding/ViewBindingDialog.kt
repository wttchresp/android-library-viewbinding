package com.wttch.androidx.viewbinding


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.annotation.DimenRes
import androidx.annotation.StyleRes
import androidx.viewbinding.ViewBinding
import com.wttch.android.util.SizeUtils

/**
 * ViewBinding 方式的 Dialog.
 */
abstract class ViewBindingDialog<Binding : ViewBinding>(context: Context, @StyleRes styleId: Int) : Dialog(context, styleId), ViewBindable<Binding> {
  protected lateinit var binding: Binding
  private var width = 200
  private var height = 300

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = bindingView()
    setContentView(binding.root)

    setCanceledOnTouchOutside(true)
    window?.let {
      val lp = it.attributes
      lp.height = height
      lp.width = width
      it.attributes = lp
    }
  }

  /**
   * 设置 Dialog 的宽度资源 [res].
   * 链式调用, 同时返回自身.
   */
  fun width(@DimenRes res: Int): ViewBindingDialog<Binding> = apply { this.width = context.resources.getDimension(res).toInt() }

  /**
   * 设置 Dialog 的宽度 [pxValue], 单位 px.
   * 链式调用, 同时返回自身.
   */
  fun pxWidth(pxValue: Float): ViewBindingDialog<Binding> = apply { this.width = pxValue.toInt() }

  /**
   * 设置 Dialog 的宽度 [dpValue], 单位 dp.
   * 链式调用, 同时返回自身.
   */
  fun dpWidth(dpValue: Float): ViewBindingDialog<Binding> = apply { this.width = SizeUtils.dp2px(dpValue) }

  /**
   * 设置 Dialog 的高度资源 [res].
   * 链式调用, 同时返回自身.
   */
  fun height(@DimenRes res: Int): ViewBindingDialog<Binding> = apply { this.height = context.resources.getDimension(res).toInt() }

  /**
   * 设置 Dialog 的高度 [pxValue], 单位 px.
   * 链式调用, 同时返回自身.
   */
  fun pxHeight(pxValue: Float): ViewBindingDialog<Binding> = apply { this.height = pxValue.toInt() }

  /**
   * 设置 Dialog 的高度 [dpValue], 单位 dp.
   * 链式调用, 同时返回自身.
   */

  fun dpHeight(dpValue: Float): ViewBindingDialog<Binding> = apply { this.width = SizeUtils.dp2px(dpValue) }
}