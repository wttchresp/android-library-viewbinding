package com.wttch.androidx.viewbinding;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;
import com.wttch.androidx.viewbinding.util.InflateUtil;
import org.jetbrains.annotations.NotNull;

/**
 * 使用 BindingView 的 Activity 的基类.
 */
public abstract class ViewBindingActivity<Binding extends ViewBinding> extends AppCompatActivity
    implements ViewBindable<Binding> {

  protected Binding binding;

  @Override
  @NotNull
  public Binding bindingView() {
    return InflateUtil.reflectInflate(getClass(), getLayoutInflater());
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = bindingView();
    setContentView(binding.getRoot());
  }
}
