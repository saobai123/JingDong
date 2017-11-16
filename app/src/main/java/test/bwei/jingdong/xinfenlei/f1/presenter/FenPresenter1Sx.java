package test.bwei.jingdong.xinfenlei.f1.presenter;

import test.bwei.jingdong.bean.FenBean;
import test.bwei.jingdong.xinfenlei.f1.model.FenModel1;
import test.bwei.jingdong.xinfenlei.f1.model.FenModel1Sx;
import test.bwei.jingdong.xinfenlei.f1.view.FenFinishListener1;
import test.bwei.jingdong.xinfenlei.f1.view.FenView1;

/**
 * Created by 大白 on 2017/11/9.
 */

public class FenPresenter1Sx implements FenPresenter1 ,FenFinishListener1{
    private FenView1 fenView1;
    private final FenModel1 fenModel1;

    public FenPresenter1Sx(FenView1 fenView1) {
        this.fenView1 = fenView1;
        fenModel1 = new FenModel1Sx();
    }

    @Override
    public void passData() {
        fenModel1.getData(this);
    }

    @Override
    public void Success(FenBean bean) {
        fenView1.ShowData(bean);
    }
}
