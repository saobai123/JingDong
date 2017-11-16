package test.bwei.jingdong;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import test.bwei.jingdong.bean.Fen2Bean;
import test.bwei.jingdong.bean.FenBean;
import test.bwei.jingdong.bean.FenBeanList;

/**
 * Created by 大白 on 2017/11/9.
 */

public interface ApiServive {

    //http://120.27.23.105/product/getCatagory

    @GET ("getCatagory")
    Observable<FenBean> getFen1();

    //http://120.27.23.105/product/getProductCatagory?cid=1
    @GET("getProductCatagory")
    Observable<Fen2Bean> getFen2(@Query("cid") String cid);


    //http://120.27.23.105/product/getProducts?pscid=1
    @GET("getProducts")
    Observable<FenBeanList> getBeanList(@Query("pscid") String pscid);

}
