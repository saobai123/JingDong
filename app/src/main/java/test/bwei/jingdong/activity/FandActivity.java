package test.bwei.jingdong.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import test.bwei.jingdong.R;
import test.bwei.jingdong.adapter.FindAdapter;
import test.bwei.jingdong.bean.FindBean;
import test.bwei.jingdong.sousuo.presenter.FindPresenter;
import test.bwei.jingdong.sousuo.presenter.FindPresenterSx;
import test.bwei.jingdong.sousuo.view.FindView;

public class FandActivity extends BaseActivity implements FindView{

    private RecyclerView find_recycler;
    private TextView tv_find;
    private FindPresenter findPresenter;
    private FindAdapter adapter;
    private List<FindBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fand);


        tv_find = (TextView) findViewById(R.id.tv_find);
        tv_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                find_recycler = (RecyclerView) findViewById(R.id.find_recycler);
                find_recycler.setLayoutManager(new LinearLayoutManager(FandActivity.this));

                findPresenter = new FindPresenterSx(FandActivity.this);
                findPresenter.passData();

            }
        });

    }



    @Override
    public void showData(final FindBean bean) {
        list = bean.getData();
        adapter = new FindAdapter(list,FandActivity.this);
        find_recycler.setAdapter(adapter);

    }
}
