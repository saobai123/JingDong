package test.bwei.jingdong.bean;

import java.util.List;

/**
 * Created by 大白 on 2017/11/14.
 */

public class DingList {


    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-11-14T16:01:23","orderid":1576,"price":99.99,"status":0,"title":null,"uid":1383},{"createtime":"2017-11-14T16:27:53","orderid":1577,"price":2.131558629E9,"status":0,"title":null,"uid":1383},{"createtime":"2017-11-14T20:00:46","orderid":1584,"price":0,"status":0,"title":null,"uid":1383},{"createtime":"2017-11-14T20:01:54","orderid":1585,"price":233.99,"status":0,"title":null,"uid":1383}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-14T16:01:23
         * orderid : 1576
         * price : 99.99
         * status : 0
         * title : null
         * uid : 1383
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private Object title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
