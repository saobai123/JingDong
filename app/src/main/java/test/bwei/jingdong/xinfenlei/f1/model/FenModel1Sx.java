package test.bwei.jingdong.xinfenlei.f1.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.ApiServive;
import test.bwei.jingdong.bean.FenBean;
import test.bwei.jingdong.xinfenlei.f1.view.FenFinishListener1;

/**
 * Created by 大白 on 2017/11/9.
 */

public class FenModel1Sx implements FenModel1 {


    @Override
    public void getData(final FenFinishListener1 listener1) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.api_f1).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServive apiServive = retrofit.create(ApiServive.class);
        Observable<FenBean> observable = apiServive.getFen1();
        observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(FenBean bean) {
              listener1.Success(bean);
            }
        });


    }


}
