package test.bwei.jingdong;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 大白 on 2017/11/1.
 */

public class Api {


       public  static  final  String Api_regist= "http://120.27.23.105/user/reg";

       public  static  final  String Api_login= "http://120.27.23.105/user/login";

       public  static  final  String Api_userinfo= "http://120.27.23.105/user/getUserInfo";

       public  static  final  String Api_fen1="http://120.27.23.105/product/getCatagory";

       public  static  final  String Api_fen2="http://120.27.23.105/product/getProductCatagory";

       public  static final  String Api_show="http://120.27.23.105/ad/getAd";

       public  static  final  String Api_find="http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1";


       public  static SharedPreferences preferences;
       public  static SharedPreferences.Editor edit;

       public static  void  init(Context context){
              preferences = context.getSharedPreferences("name",Context.MODE_PRIVATE);
              edit = preferences.edit();
       }


       public  static  final  String api_f1="http://120.27.23.105/product/";

       public  static  final  String api_f2="http://120.27.23.105/";

      public  static  final  String api_list="http://120.27.23.105/product/";


       public static  final  String api_data="http://120.27.23.105/product/getProducts";

       public static  final  String api_info="http://120.27.23.105/product/getProductDetail";

       public  static  final String api_add="http://120.27.23.105/product/addCart";

       public  static  final  String api_getcar="http://120.27.23.105/product/getCarts";

      public  static  final  String api_builedingdan="http://120.27.23.105/product/createOrder";


       public  static  final  String api_dinglist="http://120.27.23.105/product/getOrders";

       public  static  final String api_moadd="http://120.27.23.105/user/getDefaultAddr";

       public  static  final String api_addlist="http://120.27.23.105/user/getAddrs";

      public  static  final  String api_addadd="http://120.27.23.105/user/addAddr";


}
