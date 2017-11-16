package test.bwei.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.R;
import test.bwei.jingdong.adapter.DingAdapter;
import test.bwei.jingdong.bean.BuildDing;
import test.bwei.jingdong.bean.DingList;
import test.bwei.jingdong.bean.MoAdd;
import test.bwei.jingdong.zhifu.PayDemoActivity;

public class DingdanActivity extends BaseActivity {

    private String shop_allmoney;
    private RecyclerView re_ding;
    private String uid;
    private TextView ding_set;
    private TextView moding_add;
    private TextView moding_mobile;
    private TextView moding_name;
    private TextView tv_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);

        Intent intent = getIntent();
        shop_allmoney = intent.getStringExtra("price");

        //创建订单
        Map<String,String> map = new HashMap<String, String>();
        uid = Api.preferences.getString("uid", "");
        map.put("uid", uid);
        map.put("price", shop_allmoney);
        OkHttp3Utils.doPost(Api.api_builedingdan, map, new GsonObjectCallback<BuildDing>() {
            @Override
            public void onUi(BuildDing buildDing) {
                     if (buildDing.getCode().equals("0")){
                           Toast.makeText(DingdanActivity.this,buildDing.getMsg().toString(),Toast.LENGTH_SHORT);
                        }else if (buildDing.getCode().equals("1")){
                           Toast.makeText(DingdanActivity.this,buildDing.getMsg().toString(),Toast.LENGTH_SHORT);
                     }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


        //查询订单列表
        re_ding = (RecyclerView) findViewById(R.id.re_ding);
        re_ding.setLayoutManager(new LinearLayoutManager(this));
        Map<String,String> map1 = new HashMap<>();
        map1.put("uid",uid);
        OkHttp3Utils.doPost(Api.api_dinglist, map1, new GsonObjectCallback<DingList>() {
            @Override
            public void onUi(DingList dingList) {
                List<DingList.DataBean> list = dingList.getData();
                DingAdapter adapter = new DingAdapter(list,DingdanActivity.this);
                re_ding.setAdapter(adapter);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


        //订单设置跳转收货地址列表
        ding_set = (TextView) findViewById(R.id.ding_set);
        ding_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(DingdanActivity.this,AddressActivity.class);
                startActivity(intent1);

            }
        });



        //获取默认地址
        moding_add = (TextView) findViewById(R.id.moding_add);
        moding_mobile = (TextView) findViewById(R.id.moding_mobile);
        moding_name = (TextView) findViewById(R.id.moding_name);

        Map<String,String> map2 = new HashMap<>();
        map2.put("uid",uid);
        OkHttp3Utils.doPost(Api.api_moadd, map2, new GsonObjectCallback<MoAdd>() {
            @Override
            public void onUi(MoAdd moAdd) {
                MoAdd.DataBean data = moAdd.getData();
                moding_name.setText(data.getName());
                moding_add.setText(data.getAddr());
                moding_mobile.setText(data.getMobile()+"");
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });



        //立即支付

        tv_pay = (TextView) findViewById(R.id.tv_pay);
        tv_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent1 = new Intent(DingdanActivity.this, PayDemoActivity.class);
                startActivity(intent1);


            }
        });







    }


}
