package test.bwei.jingdong.fenlei.view.presenter;

import test.bwei.jingdong.bean.FenBean;
import test.bwei.jingdong.fenlei.view.view.FenFinishListener;
import test.bwei.jingdong.fenlei.view.model.FenModel;
import test.bwei.jingdong.fenlei.view.model.FenModelSx;
import test.bwei.jingdong.fenlei.view.view.FenView;

/**
 * Created by 大白 on 2017/11/2.
 */

public class FenPresenterSx implements FenPresenter ,FenFinishListener{

    private FenView fenView;
    private final FenModel fenModel;

    public FenPresenterSx(FenView fenView) {
        this.fenView = fenView;
        fenModel = new FenModelSx();
    }

    @Override
    public void passData() {
        fenModel.getData(this);
    }


    @Override
    public void Success(FenBean bean) {
        fenView.showData(bean);
    }
}
