package test.bwei.jingdong.bean;

import java.util.List;

/**
 * Created by 大白 on 2017/11/15.
 */

public class addList {


    /**
     * msg : 地址列表请求成功
     * code : 0
     * data : [{"addr":"北京市昌平区金域国际1-1-1","addrid":75,"mobile":18612991023,"name":"kson","status":0,"uid":1383},{"addr":"北京市海淀区1-1-1","addrid":76,"mobile":13683190902,"name":"dabai","status":0,"uid":1383},{"addr":"北京市海淀区1-1-1","addrid":77,"mobile":13552335238,"name":"bai","status":1,"uid":1383},{"addr":"北京市海淀区上地七街八维研修学院7325","addrid":79,"mobile":13521728200,"name":"李安江","status":0,"uid":1383}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * addr : 北京市昌平区金域国际1-1-1
         * addrid : 75
         * mobile : 18612991023
         * name : kson
         * status : 0
         * uid : 1383
         */

        private String addr;
        private int addrid;
        private long mobile;
        private String name;
        private int status;
        private int uid;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getAddrid() {
            return addrid;
        }

        public void setAddrid(int addrid) {
            this.addrid = addrid;
        }

        public long getMobile() {
            return mobile;
        }

        public void setMobile(long mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
