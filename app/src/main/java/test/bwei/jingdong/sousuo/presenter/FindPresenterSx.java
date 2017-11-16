package test.bwei.jingdong.sousuo.presenter;

import test.bwei.jingdong.bean.FindBean;
import test.bwei.jingdong.sousuo.FindFinishListener;
import test.bwei.jingdong.sousuo.model.FindModel;
import test.bwei.jingdong.sousuo.model.FindModelSx;
import test.bwei.jingdong.sousuo.view.FindView;

/**
 * Created by 大白 on 2017/11/7.
 */

public class FindPresenterSx implements FindPresenter ,FindFinishListener{


    private FindView findView;
    private final FindModel findModel;

    public FindPresenterSx(FindView findView) {
        this.findView = findView;
        findModel = new FindModelSx();
    }

    @Override
    public void passData() {
        findModel.getData(this);
    }

    @Override
    public void Success(FindBean bean) {
        findView.showData(bean);
    }
}
