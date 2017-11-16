package test.bwei.jingdong.login.model;

import android.content.Context;
import android.text.TextUtils;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.bean.LoginBean;
import test.bwei.jingdong.login.LogFinishListener;

/**
 * Created by 大白 on 2017/11/1.
 */

public class LogModelSx implements LogModel {

    private LogFinishListener logFinishListener;

    public LogModelSx(LogFinishListener logFinishListener) {
        this.logFinishListener = logFinishListener;
    }

    @Override
    public void LogLogin(Context context, String logMobile, String logPwd) {
          if (TextUtils.isEmpty(logMobile)){
              logFinishListener.LogMobile();
              return;
          }
        if (TextUtils.isEmpty(logPwd)){
            logFinishListener.LogPwd();
            return;
        }

          LogRequest(context,logMobile,logPwd);
    }

    @Override
    public void LogRequest(Context context, String logMobile, String logPwd) {

        Map<String,String> map = new HashMap<>();
        map.put("mobile",logMobile);
        map.put("password",logPwd);

        OkHttp3Utils.doPost(Api.Api_login, map, new GsonObjectCallback<LoginBean>() {
            @Override
            public void onUi(LoginBean loginBean) {
                if (loginBean.getCode().equals("0")){
                    logFinishListener.Success();
                    Api.edit.putString("uid", loginBean.getData().getUid() + "").commit();
                    Api.edit.putString("createtime", loginBean.getData().getCreatetime() + "").commit();
                    Api.edit.putString("username", loginBean.getData().getUsername() + "").commit();

                }else if (loginBean.getCode().equals("1")){
                    logFinishListener.Fail();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }



}
