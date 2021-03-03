package com.wttch.androidx.viewbinding.util;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * ViewBinding 布局相关的工具类.
 */
public class InflateUtil {

  /**
   * 利用 ViewBinding#inflate(LayoutInflater) 方法的反射初始化 ViewBinding 对象.
   *
   * @param clazz          自定义View, Activity 等的类
   * @param layoutInflater 布局
   * @param <T>            ViewBinding 类型
   * @return 实例化的 ViewBinding 对象. 不会为空, 出错则抛出运行时异常.
   */
  @SuppressWarnings({"unchecked"})
  @NotNull
  public static <T> T reflectInflate(Class<?> clazz, LayoutInflater layoutInflater) {
    ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
    Class<T> viewBindingClass = (Class<T>) Objects.requireNonNull(type).getActualTypeArguments()[0];
    try {
      Method inflateMethod = viewBindingClass.getMethod("inflate", LayoutInflater.class);
      return (T) Objects.requireNonNull(inflateMethod.invoke(null, layoutInflater));
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * 利用 ViewBinding#inflate(LayoutInflater, ViewGroup, boolean) 方法的反射初始化 ViewBinding 对象.
   *
   * @param clazz          自定义View, Activity 等的类
   * @param layoutInflater 布局
   * @param parent         父组件
   * @param attachToParent 是否自动添加到父组件的子组件中去
   * @param <T>            ViewBinding 类型
   * @return 实例化的 ViewBinding 对象. 不会为空, 出错则抛出运行时异常.
   */
  @SuppressWarnings({"unchecked"})
  @NotNull
  public static <T> T reflectInflate(Class<?> clazz, LayoutInflater layoutInflater,
      ViewGroup parent, boolean attachToParent) {
    ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
    Class<T> viewBindingClass = (Class<T>) Objects.requireNonNull(type).getActualTypeArguments()[0];
    try {
      Method inflateMethod = viewBindingClass
          .getMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
      return (T) Objects
          .requireNonNull(inflateMethod.invoke(null, layoutInflater, parent, attachToParent));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
