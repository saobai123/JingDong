package test.bwei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.bwei.jingdong.R;
import test.bwei.jingdong.bean.FindBean;

/**
 * Created by 大白 on 2017/11/2.
 */

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.MyViewHolder> {


    private  List<FindBean.DataBean> list;
    private Context context;
    private MyViewHolder holder;
    private View view;


    public FindAdapter( List<FindBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context).inflate(R.layout.find_item, parent, false);


        holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.with(context).load(list.get(position).getImages()).placeholder(R.mipmap.com).into(holder.img_fen1);
        holder.tv_fen1.setText(list.get(position).getTitle());
        holder.find_price.setText(list.get(position).getPrice()+"");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_fen1;
        private final ImageView img_fen1;
        private final TextView find_price;

        public MyViewHolder(View itemView) {
            super(itemView);

            img_fen1 = itemView.findViewById(R.id.find_img);
            tv_fen1 = itemView.findViewById(R.id.find_title);
            find_price = itemView.findViewById(R.id.find_price);
        }
    }





}
