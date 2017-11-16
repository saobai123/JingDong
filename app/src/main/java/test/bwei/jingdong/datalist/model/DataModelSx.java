package test.bwei.jingdong.datalist.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwei.jingdong.Api;
import test.bwei.jingdong.ApiServive;
import test.bwei.jingdong.bean.FenBeanList;
import test.bwei.jingdong.datalist.view.DataFinishListener;

/**
 * Created by 大白 on 2017/11/9.
 */

public class DataModelSx implements  DataModel {


    @Override
    public void getData(final DataFinishListener listener,String pscid) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.api_list).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiServive apiServive = retrofit.create(ApiServive.class);
        Observable<FenBeanList> observable = apiServive.getBeanList(pscid);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenBeanList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(FenBeanList beanList) {
                 listener.Success(beanList);
            }
        });

    /*    Map<String,String> map = new HashMap<>();
        map.put("pscid",pscid);
        OkHttp3Utils.doPost(Api.api_data, map, new GsonObjectCallback<FenBeanList>() {
            @Override
            public void onUi(FenBeanList beanList) {
                listener.Success(beanList);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });*/


    }



}
