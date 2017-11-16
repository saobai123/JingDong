package test.bwei.jingdong.xinfenlei.f2.presenter;

import test.bwei.jingdong.bean.Fen2Bean;
import test.bwei.jingdong.xinfenlei.f2.model.FenModel2;
import test.bwei.jingdong.xinfenlei.f2.model.FenModel2Sx;
import test.bwei.jingdong.xinfenlei.f2.view.FenFinishListener2;
import test.bwei.jingdong.xinfenlei.f2.view.FenView2;

/**
 * Created by 大白 on 2017/11/9.
 */

public class FenPresenter2Sx implements FenPresenter2 ,FenFinishListener2{

    private FenView2 fenView2;
    private final FenModel2 fenModel2;

    public FenPresenter2Sx(FenView2 fenView2) {
        this.fenView2 = fenView2;
        fenModel2 = new FenModel2Sx();
    }

    @Override
    public void passData(String cid) {
          fenModel2.getData(this,cid);
    }


    @Override
    public void Success(Fen2Bean bean,String cid) {
          fenView2.showData(bean);
    }
}
