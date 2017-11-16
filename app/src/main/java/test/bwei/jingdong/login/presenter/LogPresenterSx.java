package test.bwei.jingdong.login.presenter;

import android.content.Context;

import test.bwei.jingdong.login.LogFinishListener;
import test.bwei.jingdong.login.model.LogModel;
import test.bwei.jingdong.login.model.LogModelSx;
import test.bwei.jingdong.login.view.LogView;

/**
 * Created by 大白 on 2017/11/1.
 */

public class LogPresenterSx implements LogPresenter ,LogFinishListener{


    private LogView logView;
    private final LogModel logModel;

    public LogPresenterSx(LogView logView) {
        this.logView = logView;
        logModel = new LogModelSx(this);
    }

    @Override
    public void getData(Context context, String logMobile, String logPwd) {
        logModel.LogLogin(context,logMobile,logPwd);
    }


    @Override
    public void LogMobile() {
         logView.onLogMobile();
    }

    @Override
    public void LogPwd() {
        logView.onLogPwd();
    }

    @Override
    public void Success() {
        logView.onSuccess();
    }

    @Override
    public void Fail() {
       logView.onFial();
    }
}
