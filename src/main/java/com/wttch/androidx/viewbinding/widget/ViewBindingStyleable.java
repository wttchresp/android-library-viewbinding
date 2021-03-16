package com.wttch.androidx.viewbinding.widget;

import android.content.res.TypedArray;
import androidx.annotation.StyleableRes;

public interface ViewBindingStyleable {

  @StyleableRes
  int[] getStyleableRes();

  void preform(TypedArray typedArray);
}
