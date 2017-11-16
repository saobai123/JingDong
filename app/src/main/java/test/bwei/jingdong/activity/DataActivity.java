package test.bwei.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import test.bwei.jingdong.R;
import test.bwei.jingdong.adapter.DataAdapter;
import test.bwei.jingdong.bean.FenBeanList;
import test.bwei.jingdong.datalist.presenter.DataPresener;
import test.bwei.jingdong.datalist.presenter.DataPresenerSx;
import test.bwei.jingdong.datalist.view.DataShow;

public class DataActivity extends BaseActivity implements DataShow{


    private RecyclerView re4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data2);

        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");

        re4 = (RecyclerView) findViewById(R.id.re4);
        re4.setLayoutManager(new LinearLayoutManager(DataActivity.this));


        DataPresener dataPresener = new DataPresenerSx(this);
        dataPresener.passData(pscid);


    }



    @Override
    public void showData(FenBeanList beanList) {
        List<FenBeanList.DataBean> list = beanList.getData();
        DataAdapter adapter = new DataAdapter(list,DataActivity.this);
        re4.setAdapter(adapter);

        adapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FenBeanList.DataBean bean) {
                String pid = bean.getPid()+"";
               // Toast.makeText(DataActivity.this,pid,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DataActivity.this,DataInfoActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }


}
