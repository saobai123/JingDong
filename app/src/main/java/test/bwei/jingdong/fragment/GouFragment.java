package test.bwei.jingdong.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.bwei.jingdong.R;
import test.bwei.jingdong.activity.DingdanActivity;
import test.bwei.jingdong.bean.carBean;
import test.bwei.jingdong.car.chaxun.presenter.CarPresenter;
import test.bwei.jingdong.car.chaxun.presenter.CarPresenterSx;
import test.bwei.jingdong.car.chaxun.view.CarView;

/**
 * Created by 大白 on 2017/10/30.
 */

public class GouFragment extends Fragment implements CarView, View.OnClickListener {


    private List<carBean.DataBean> group;

    private ExpandableListView ex;
    private TextView shop_allmoney;
    private TextView shop_count;
    private CheckBox cb_all;
    private Exadapter exadapter;

    @Nullable

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gou_item, null);


        shop_allmoney = view.findViewById(R.id.shop_allmoney);
        shop_count = view.findViewById(R.id.shop_count);
        shop_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(getActivity(), DingdanActivity.class);
                    intent.putExtra("price",shop_allmoney.getText().toString());
                    startActivity(intent);

            }
        });


        cb_all = view.findViewById(R.id.check_all);
        cb_all.setOnClickListener(this);

        ex = view.findViewById(R.id.ex);
        CarPresenter carPresenter = new CarPresenterSx(this);
        carPresenter.passData();

        return view;
    }


   //view展示数据
    @Override
    public void showData(carBean bean) {
        group = bean.getData();
        exadapter = new Exadapter(getActivity());
        ex.setAdapter(exadapter);
        for (int i = 0; i < group.size(); i++) {
            ex.expandGroup(i);
        }
    }


    //全选监听
    @Override
    public void onClick(View v) {

         for (int i=0;i<group.size();i++){
             group.get(i).setGroupSelected(cb_all.isChecked());
             for (int j=0;j<group.get(i).getList().size();j++){
                 group.get(i).getList().get(j).setChildSelected(cb_all.isChecked());
             }
         }

        exadapter.MoneyAllAndCountAll();
        exadapter.notifyDataSetChanged();

    }


    //适配器
    class Exadapter extends BaseExpandableListAdapter{

        private Context context;
        private CheckBox child_check;
        private CheckBox group_check;

        public Exadapter(Context context) {
            this.context = context;
        }

        @Override
        public int getGroupCount() {
            return group.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {

                return group.get(groupPosition).getList().size();
            }

        @Override
        public Object getGroup(int groupPosition) {
            return group.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return group.get(groupPosition).getList().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.group, null);
            }
            TextView group_name = convertView.findViewById(R.id.group_name);
            group_name.setText(group.get(groupPosition).getSellerName());


            //父级CheckBox
            group_check = convertView.findViewById(R.id.group_check);
            group_check.setChecked(group.get(groupPosition).getGroupSelected());
            group_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (group.get(groupPosition).getGroupSelected()){
                        group.get(groupPosition).setGroupSelected(false);
                        cb_all.setChecked(false);
                        for (int i=0;i<group.get(groupPosition).getList().size();i++){
                            group.get(groupPosition).getList().get(i).setChildSelected(false);

                        }
                    }else {
                        int GroupSum = 0;
                        group.get(groupPosition).setGroupSelected(true);
                        for (int i=0;i<group.get(groupPosition).getList().size();i++) {
                            group.get(groupPosition).getList().get(i).setChildSelected(true);
                        }

                    for (int j=0;j<group.size();j++){
                        if (group.get(j).getGroupSelected()){
                            GroupSum++;
                        }
                        if (GroupSum == group.size()){
                            cb_all.setChecked(true);
                        }
                    }
                        MoneyAllAndCountAll();
                        notifyDataSetChanged();
                    }
                }
            });

            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.zi,null);
            }
            ImageView child_img = convertView.findViewById(R.id.child_img);
            TextView chidl_price = convertView.findViewById(R.id.chidl_price);
            TextView child_title = convertView.findViewById(R.id.chidl_title);

            chidl_price.setText(group.get(groupPosition).getList().get(childPosition).getPrice()+"");
            Picasso.with(context).load(group.get(groupPosition).getList().get(childPosition).getImages()).placeholder(R.mipmap.yue).into(child_img);
            child_title.setText(group.get(groupPosition).getList().get(childPosition).getTitle());


            //子级checkbox
            child_check = convertView.findViewById(R.id.child_check);
            child_check.setChecked(group.get(groupPosition).getList().get(childPosition).getChildSelected());
            child_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (group.get(groupPosition).getList().get(childPosition).getChildSelected()){
                        group.get(groupPosition).getList().get(childPosition).setChildSelected(false);
                        cb_all.setChecked(false);
                        group.get(groupPosition).setGroupSelected(false);
                    }else {
                       int childSum=0;
                       int groupSum=0;
                        group.get(groupPosition).getList().get(childPosition).setChildSelected(true);
                        for (int i=0;i<group.get(groupPosition).getList().size();i++){
                            if (group.get(groupPosition).getList().get(i).getChildSelected()){
                                childSum++;
                            }
                        }
                        if (group.get(groupPosition).getList().size()==childSum){
                            group.get(groupPosition).setGroupSelected(true);
                        }
                        for (int j=0;j<group.size();j++){
                            if (group.get(groupPosition).getGroupSelected()){
                                groupSum++;
                            }
                        }
                        if (group.size() == groupSum){
                            cb_all.setChecked(true);
                        }

                    }

                    MoneyAllAndCountAll();
                    notifyDataSetChanged();
                }
            });


            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }


        public void  MoneyAllAndCountAll(){
            int sum = 0;
            double money=0;
            for (carBean.DataBean dataBean : group){
                for (carBean.DataBean.ListBean listBean : dataBean.getList()){
                    if (listBean.getChildSelected()){
                        sum+=Integer.parseInt(listBean.getNum()+"");
                        double aDouble =Double.parseDouble(listBean.getPrice()+"");
                        money+=aDouble;
                    }
                }
            }
            shop_allmoney.setText(money+"");
            shop_count.setText(sum+"");

        }


    }



}
