package test.bwei.jingdong.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.bwei.jingdong.Api;
import test.bwei.jingdong.R;
import test.bwei.jingdong.login.presenter.LogPresenter;
import test.bwei.jingdong.login.presenter.LogPresenterSx;
import test.bwei.jingdong.login.view.LogView;

public class Login2Activity extends BaseActivity implements LogView{

    private EditText et_modile;
    private EditText et_pwd;
    private Button bt_commit;
    private LogPresenter logPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        et_modile = (EditText) findViewById(R.id.et_mobile);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        bt_commit = (Button) findViewById(R.id.bt_commit);
        logPresenter = new LogPresenterSx(this);
        bt_commit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
           logPresenter.getData(Login2Activity.this,et_modile.getText().toString(),et_pwd.getText().toString());

           }
       });



    }


    @Override
    public void onLogMobile() {
        et_modile.setError("手机号不能为空");
    }

    @Override
    public void onLogPwd() {
        et_pwd.setError("密码不能为空");
    }

    @Override
    public void onSuccess() {
        Toast.makeText(Login2Activity.this,"登录成功",Toast.LENGTH_SHORT).show();
        Api.edit.putBoolean("isLogin",true).commit();
        setResult(2);
        finish();
    }

    @Override
    public void onFial() {
        Toast.makeText(Login2Activity.this,"登录失败",Toast.LENGTH_SHORT).show();
    }







}
