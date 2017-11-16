package test.bwei.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.R;
import test.bwei.jingdong.adapter.AddAdapter;
import test.bwei.jingdong.bean.addList;

public class AddressActivity extends BaseActivity {

    private RecyclerView re_address;
    private TextView tv_newadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        re_address = (RecyclerView) findViewById(R.id.re_address);
        re_address.setLayoutManager(new LinearLayoutManager(this));

        String uid = Api.preferences.getString("uid", "");
        Map<String,String> map = new HashMap<>();
        map.put("uid",uid);
        OkHttp3Utils.doPost(Api.api_addlist, map, new GsonObjectCallback<addList>() {
            @Override
            public void onUi(addList addList) {

                List<addList.DataBean> list = addList.getData();
                AddAdapter adapter = new AddAdapter(list,AddressActivity.this);
                re_address.setAdapter(adapter);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


        tv_newadd = (TextView) findViewById(R.id.tv_newadd);
        tv_newadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddressActivity.this,SetAddActivity.class);
                startActivity(intent);

            }
        });

    }


}
