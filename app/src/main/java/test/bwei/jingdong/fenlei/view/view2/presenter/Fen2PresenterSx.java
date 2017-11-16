package test.bwei.jingdong.fenlei.view.view2.presenter;

import test.bwei.jingdong.bean.Fen2Bean;
import test.bwei.jingdong.fenlei.view.view2.model.Fen2Model;
import test.bwei.jingdong.fenlei.view.view2.model.Fen2ModelSx;
import test.bwei.jingdong.fenlei.view.view2.view.Fen2FinishListener;
import test.bwei.jingdong.fenlei.view.view2.view.Fen2View;

/**
 * Created by 大白 on 2017/11/8.
 */

public class Fen2PresenterSx implements  Fen2Presenter ,Fen2FinishListener{

    private Fen2View fen2View;
    private final Fen2Model fen2Model;

    public Fen2PresenterSx(Fen2View fen2View) {
        this.fen2View = fen2View;
        fen2Model = new Fen2ModelSx();

    }

    @Override
    public void passData(int cid) {
        fen2Model.getData(this,cid);
    }

    @Override
    public void Success(Fen2Bean bean) {
        fen2View.Show2Data(bean);
    }
}
