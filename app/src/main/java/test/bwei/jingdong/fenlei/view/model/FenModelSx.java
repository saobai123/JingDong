package test.bwei.jingdong.fenlei.view.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.bean.FenBean;
import test.bwei.jingdong.fenlei.view.view.FenFinishListener;

/**
 * Created by 大白 on 2017/11/2.
 */

public class FenModelSx implements FenModel {


    @Override
    public void getData(final FenFinishListener listener) {

        OkHttp3Utils.doGet(Api.Api_fen1, new GsonObjectCallback<FenBean>() {
            @Override
            public void onUi(FenBean fenBean) {
               listener.Success(fenBean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


    }



}
