package test.bwei.jingdong.register.presenter;

import android.content.Context;

import test.bwei.jingdong.register.FinishListener;
import test.bwei.jingdong.register.model.RegModel;
import test.bwei.jingdong.register.model.RegModelSx;
import test.bwei.jingdong.register.view.RegView;

/**
 * Created by 大白 on 2017/11/1.
 */

public class RegPresenterSx implements RegPresenter ,FinishListener{


    private RegView regView;
    private final RegModel regModel;

    public RegPresenterSx(RegView regView) {
        this.regView = regView;
        regModel = new RegModelSx(this);

    }

    @Override
    public void getData(Context context, String regmobile, String regwd) {

       regModel.regLogin(context,regmobile,regwd);

    }


    @Override
    public void RegModile() {
        regView.onRegModile();
    }

    @Override
    public void RegPwd() {
       regView.onRegPwd();
    }

    @Override
    public void Success() {
       regView.onSuccess();
    }

    @Override
    public void Fail() {
       regView.onFail();
    }
}
