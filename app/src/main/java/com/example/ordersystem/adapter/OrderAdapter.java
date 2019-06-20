package com.example.ordersystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordersystem.R;
import com.example.ordersystem.databinding.RecyclerviewItemOrderBinding;
import com.example.ordersystem.entity.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<Order> currentOrderList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // 为每个item创建binding对象，复用
        RecyclerviewItemOrderBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_item_order, parent, false);
        return new MyViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.binding.setOrder(currentOrderList.get(position));
//        holder.orderId.setText("订单号" + currentOrderList.get(position).id);
//        holder.price.setText("总价：" + currentOrderList.get(position).totalPrice + " 元");
//        String str = "";
//        for (Food f : currentOrderList.get(position).foodlist) {
//            str += (f.name + " ............ " + f.price + "\n");
//        }
//        holder.content.setText(str);
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.instance); //更具MainActivity.instance 拿到 MainActivity 的上下文
//                dialog.setTitle("结账");
//                dialog.setMessage("是否结账");
//
//                // 确认按钮回调
//                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MyApplication.getInstance(), "加载中", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                // 取消回调
//                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return currentOrderList.size();
    }

    /**
     * viewholder不再holder控件，而是每一个itemview对应的binding对象
     * 通过binding对象绑定集合中的数据
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerviewItemOrderBinding binding;

        public MyViewHolder(@NonNull View itemView, RecyclerviewItemOrderBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
    /**
     * 传入新数据，整合原数据，基于自定义的Callback，更新adapter
     * @param newNewsList
     */
    public void updateOrders(List<Order> newNewsList) {
        // 需渲染全部数据，而非新加载的数据，因此创建集合添加全部数据
        List<Order> allNewsList = new ArrayList<>();
        // 加入原数据
        allNewsList.addAll(getCurrentNewsList());
        // 在顶部加入新数据
        allNewsList.addAll(0, newNewsList);
        // 创建自动计算的效率更高的diff对象
        DiffUtil.DiffResult diff = DiffUtil.calculateDiff(new MyDiffCallback(allNewsList, currentOrderList));
        // 通知adpter基于新数据更新
        diff.dispatchUpdatesTo(this);
        // 必须手动更新封装的数据即可，dispatchUpdatesTo
        setCurrentNewsList(allNewsList);
    }

    /**
     * DiffUtil/Callback支持自动计算最佳更新方法，封装调用支持动画效果的dapter更新方法
     */
    static class MyDiffCallback extends DiffUtil.Callback {
        private List<Order> norders;
        private List<Order> oorders;

        public MyDiffCallback(List<Order> norders, List<Order> oorders) {
            this.norders = norders;
            this.oorders = oorders;
        }

        @Override
        public int getOldListSize() {
            return oorders.size();
        }

        @Override
        public int getNewListSize() {
            return norders.size();
        }

        // 自定义如何判断2个item是否相同
        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oorders.get(oldItemPosition).id == norders.get(newItemPosition).id;
        }

        // 自定义判断2特item内容是否相同，即内容是否更新
        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oorders.get(oldItemPosition).foodlist == norders.get(newItemPosition).foodlist;
        }
    }

    public List<Order> getCurrentNewsList() {
        return currentOrderList;
    }

    public void setCurrentNewsList(List<Order> currentNewsList) {
        this.currentOrderList = currentNewsList;
    }

}
