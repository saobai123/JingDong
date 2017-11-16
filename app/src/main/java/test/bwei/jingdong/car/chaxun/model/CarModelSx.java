package test.bwei.jingdong.car.chaxun.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.bean.carBean;
import test.bwei.jingdong.car.chaxun.view.CarFinishListener;

/**
 * Created by 大白 on 2017/11/10.
 */

public class CarModelSx implements  carModel{



    @Override
    public void getData(final CarFinishListener listener) {

        String uid = Api.preferences.getString("uid", "");

        Map<String,String> map = new HashMap<>();
        map.put("uid",uid);
        OkHttp3Utils.doPost(Api.api_getcar, map, new GsonObjectCallback<carBean>() {
            @Override
            public void onUi(carBean bean) {
                listener.Success(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {
            }
        });


    }




}
