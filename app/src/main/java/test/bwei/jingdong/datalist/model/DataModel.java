package test.bwei.jingdong.datalist.model;

import test.bwei.jingdong.datalist.view.DataFinishListener;

/**
 * Created by 大白 on 2017/11/9.
 */

public interface DataModel {

    void  getData(DataFinishListener listener,String pscid);

}
