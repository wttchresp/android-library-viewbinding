package com.wttch.androidx.viewbinding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.wttch.androidx.viewbinding.adapter.BaseRecyclerAdapter.ViewHolder;
import com.wttch.androidx.viewbinding.util.InflateUtil;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, VB extends ViewBinding> extends
    RecyclerView.Adapter<ViewHolder<VB>> {

  protected final Context context;
  protected List<T> data;

  protected BaseRecyclerAdapter(Context context, List<T> data) {
    this.context = context;
    this.data = data;
  }

  public void update(List<T> data) {
    this.data = data;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public ViewHolder<VB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder<>(
        InflateUtil.reflectInflate(getClass(), 1, LayoutInflater.from(context), parent, false));
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder<VB> holder, int position) {
    onBindViewBinding(holder.getBinding(), position, data.get(position));
  }

  protected abstract void onBindViewBinding(@NonNull VB binding, int position, T item);

  public static class ViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {

    private final VB binding;

    public ViewHolder(@NonNull VB binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public VB getBinding() {
      return binding;
    }
  }
}
