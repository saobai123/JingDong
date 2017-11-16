package test.bwei.jingdong.datalist.presenter;

import test.bwei.jingdong.bean.FenBeanList;
import test.bwei.jingdong.datalist.model.DataModel;
import test.bwei.jingdong.datalist.model.DataModelSx;
import test.bwei.jingdong.datalist.view.DataFinishListener;
import test.bwei.jingdong.datalist.view.DataShow;

/**
 * Created by 大白 on 2017/11/9.
 */

public class DataPresenerSx implements  DataPresener ,DataFinishListener{

    private DataShow dataShow;
    private final DataModel dataModel;

    public DataPresenerSx(DataShow dataShow) {
        this.dataShow = dataShow;
        dataModel = new DataModelSx();
    }

    @Override
    public void passData(String pscid) {
        dataModel.getData(this,pscid);
    }


    @Override
    public void Success(FenBeanList beanList) {
        dataShow.showData(beanList);
    }
}
