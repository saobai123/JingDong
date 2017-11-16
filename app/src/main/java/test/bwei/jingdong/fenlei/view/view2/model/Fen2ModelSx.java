package test.bwei.jingdong.fenlei.view.view2.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.bean.Fen2Bean;
import test.bwei.jingdong.fenlei.view.view2.view.Fen2FinishListener;

/**
 * Created by 大白 on 2017/11/8.
 */

public class Fen2ModelSx implements  Fen2Model {


    @Override
    public void getData(final Fen2FinishListener listener,int cid) {

        OkHttp3Utils.doGet(Api.Api_fen2+"?cid="+cid, new GsonObjectCallback<Fen2Bean>() {
            @Override
            public void onUi(Fen2Bean bean) {
                listener.Success(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }



}
