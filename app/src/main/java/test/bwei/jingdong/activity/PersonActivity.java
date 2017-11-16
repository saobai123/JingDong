package test.bwei.jingdong.activity;

import android.os.Bundle;
import android.widget.TextView;

import test.bwei.jingdong.Api;
import test.bwei.jingdong.R;

public class PersonActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        TextView name = (TextView) findViewById(R.id.name);
        String uid = Api.preferences.getString("uid", "");
        name.setText(uid);

        TextView tv2 = (TextView) findViewById(R.id.username);
        String username = Api.preferences.getString("username", "");
        tv2.setText(username);

        TextView tv3 = (TextView) findViewById(R.id.createtime);
        String createtime = Api.preferences.getString("createtime", "");
        tv3.setText(createtime);

    }




}
