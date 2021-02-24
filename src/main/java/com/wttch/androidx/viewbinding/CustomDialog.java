package com.wttch.androidx.viewbinding;

import android.content.Context;
import android.content.DialogInterface;
import androidx.viewbinding.ViewBinding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomDialog<Binding extends ViewBinding> extends ViewBindingDialog<Binding> {


  public CustomDialog(Builder<Binding> builder) {
    super(builder.context, builder.cancelable, builder.cancelListener);
    this.binding = builder.binding;
  }

  @NotNull
  @Override
  public Binding bindingView() {
    return binding;
  }

  public static <Binding extends ViewBinding> Builder<Binding> builder(Context context,
      Binding binding) {
    return new Builder<>(context, binding);
  }

  public static class Builder<Binding extends ViewBinding> {

    private final Context context;
    private final Binding binding;
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
