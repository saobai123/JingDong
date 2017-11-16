package test.bwei.jingdong.sousuo.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.bean.FindBean;
import test.bwei.jingdong.sousuo.FindFinishListener;

/**
 * Created by 大白 on 2017/11/7.
 */

public class FindModelSx implements  FindModel {


    @Override
    public void getData(final FindFinishListener listener) {

        OkHttp3Utils.doGet(Api.Api_find, new GsonObjectCallback<FindBean>() {
            @Override
            public void onUi(FindBean bean) {
                listener.Success(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {
            }
        });

    }



}
