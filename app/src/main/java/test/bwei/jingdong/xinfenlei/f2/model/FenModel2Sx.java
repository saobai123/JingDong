package test.bwei.jingdong.xinfenlei.f2.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.bean.Fen2Bean;
import test.bwei.jingdong.xinfenlei.f2.view.FenFinishListener2;

/**
 * Created by 大白 on 2017/11/9.
 */

public class FenModel2Sx implements  FenModel2 {


    @Override
    public void getData(final FenFinishListener2 listener2, final String cid) {

       /* Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.api_f2+"?cid=").addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        ApiServive apiServive = retrofit.create(ApiServive.class);
        Observable<Fen2Bean> observable = apiServive.getFen2(cid);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fen2Bean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Fen2Bean bean) {
                 listener2.Success(bean,cid);
            }
        });*/


        OkHttp3Utils.doGet(Api.Api_fen2 + "?cid=" + cid, new GsonObjectCallback<Fen2Bean>() {
            @Override
            public void onUi(Fen2Bean bean) {
                listener2.Success(bean,cid);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });





    }


}
