package test.bwei.jingdong.register.model;

import android.content.Context;

/**
 * Created by 大白 on 2017/11/1.
 */

public interface RegModel {

    void  regLogin(Context context,String regmobile,String regwd);
    void  regRequest(Context context,String regmobile,String regwd);

}
