package test.bwei.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import test.bwei.jingdong.R;
import test.bwei.jingdong.adapter.FenAdapter1;
import test.bwei.jingdong.adapter.FenAdapter2;
import test.bwei.jingdong.bean.Fen2Bean;
import test.bwei.jingdong.bean.FenBean;
import test.bwei.jingdong.xinfenlei.f1.presenter.FenPresenter1;
import test.bwei.jingdong.xinfenlei.f1.presenter.FenPresenter1Sx;
import test.bwei.jingdong.xinfenlei.f1.view.FenView1;
import test.bwei.jingdong.xinfenlei.f2.presenter.FenPresenter2;
import test.bwei.jingdong.xinfenlei.f2.presenter.FenPresenter2Sx;
import test.bwei.jingdong.xinfenlei.f2.view.FenView2;

/**
 * Created by 大白 on 2017/11/9.
 */

public class Fen2Fragment extends Fragment implements FenView1,FenView2{

    private View view;
    private RecyclerView re1;
    private FenPresenter2 fenPresenter2;
    private RecyclerView re2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fenlei2, null);

        initView();



        return view;
    }

    private void initView() {

        re1 = view.findViewById(R.id.re1);
        re1.setLayoutManager(new LinearLayoutManager(getActivity()));

        FenPresenter1 fenPresenter1 = new FenPresenter1Sx(this);
        fenPresenter1.passData();


        re2 = view.findViewById(R.id.re2);
        re2.setLayoutManager(new LinearLayoutManager(getActivity()));

        fenPresenter2 = new FenPresenter2Sx(this);

    }


    @Override
    public void ShowData(FenBean bean) {

        List<FenBean.DataBean> list = bean.getData();
        FenAdapter1 adapter = new FenAdapter1(list,getActivity());
        re1.setAdapter(adapter);
        adapter.setOnItemClickListener(new FenAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(FenBean.DataBean bean) {
                String cid = bean.getCid()+"";
                Toast.makeText(getActivity(),cid,Toast.LENGTH_SHORT).show();
                fenPresenter2.passData(cid);
            }
        });
    }

    @Override
    public void showData(Fen2Bean bean) {
        List<Fen2Bean.DataBean> list1 = bean.getData();
        //Log.e("sss",list1.toString());
        FenAdapter2 adapter2 = new FenAdapter2(list1,getActivity());
        re2.setAdapter(adapter2);

    }
}
