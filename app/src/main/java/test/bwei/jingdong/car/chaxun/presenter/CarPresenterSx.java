package test.bwei.jingdong.car.chaxun.presenter;

import test.bwei.jingdong.bean.carBean;
import test.bwei.jingdong.car.chaxun.model.CarModelSx;
import test.bwei.jingdong.car.chaxun.view.CarFinishListener;
import test.bwei.jingdong.car.chaxun.view.CarView;

/**
 * Created by 大白 on 2017/11/10.
 */

public class CarPresenterSx implements CarPresenter ,CarFinishListener{


    private CarView carView;
    private final test.bwei.jingdong.car.chaxun.model.carModel carModel;

    public CarPresenterSx(CarView carView) {
        this.carView = carView;
        carModel = new CarModelSx();
    }

    @Override
    public void passData() {
        carModel.getData(this);
    }


    @Override
    public void Success(carBean bean) {
        carView.showData(bean);
    }
}
