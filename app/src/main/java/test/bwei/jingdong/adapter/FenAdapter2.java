package test.bwei.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.bwei.jingdong.R;
import test.bwei.jingdong.activity.DataActivity;
import test.bwei.jingdong.bean.Fen2Bean;


/**
 * Created by 大白 on 2017/11/2.
 */

public class FenAdapter2 extends RecyclerView.Adapter<FenAdapter2.MyViewHolder> {

    private List<Fen2Bean.DataBean> list1;
    private Context context;


    public FenAdapter2(List<Fen2Bean.DataBean> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fen2_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_fen2.setText(list1.get(position).getName());
       // Picasso.with(context).load(list1.get(position).getList().get(position).getIcon()).into(holder.img_fen2);

        //String pcid = list1.get(position).getPcid();

        holder.re3.setLayoutManager(new GridLayoutManager(context,3));
        final List<Fen2Bean.DataBean.ListBean>list=list1.get(position).getList();
        FenAdapter3 adapter3=new FenAdapter3(list,context);
        holder.re3.setAdapter(adapter3);

       adapter3.setOnItemClickListener(new FenAdapter3.OnItemClickListener() {
           @Override
           public void onItemClick(Fen2Bean.DataBean.ListBean bean) {
               String pscid = list.get(position).getPscid()+"";
            //   Toast.makeText(context,pscid,Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(context,DataActivity.class);
               intent.putExtra("pscid",pscid);
               context.startActivity(intent);

           }
       });


    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_fen2;
        private final RecyclerView re3;
        // private final ImageView img_fen2;

        public MyViewHolder(View itemView) {
            super(itemView);

           // img_fen2 = itemView.findViewById(R.id.img_fen2);
            tv_fen2 = itemView.findViewById(R.id.tv_fen2);
            re3 = itemView.findViewById(R.id.re3);
        }

    }
}