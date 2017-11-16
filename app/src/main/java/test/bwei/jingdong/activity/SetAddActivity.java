package test.bwei.jingdong.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.R;
import test.bwei.jingdong.bean.addAdd;

public class SetAddActivity extends BaseActivity {

    private EditText et_addadd;
    private EditText et_addmobile;
    private EditText et_addname;
    private TextView add_keep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_add);


        et_addadd = (EditText) findViewById(R.id.et_addadd);
        et_addmobile = (EditText) findViewById(R.id.et_addmobile);
        et_addname = (EditText) findViewById(R.id.et_addname);
        add_keep = (TextView) findViewById(R.id.add_keep);


        add_keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uid = Api.preferences.getString("uid", "");
                Map<String,String> map = new HashMap<String, String>();
                map.put("uid",uid);
                map.put("addr",et_addadd.getText().toString());
                map.put("mobile",et_addmobile.getText().toString());
                map.put("name",et_addname.getText().toString());
                OkHttp3Utils.doPost(Api.api_addadd, map, new GsonObjectCallback<addAdd>() {
                    @Override
                    public void onUi(addAdd addAdd) {
                        if (addAdd.getCode().equals("0")){
                            Toast.makeText(SetAddActivity.this,addAdd.getMsg()+"",Toast.LENGTH_SHORT).show();
                        }else if(addAdd.getCode().equals("1")){
                            Toast.makeText(SetAddActivity.this,addAdd.getMsg()+"",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });

            }
        });

    }





}
