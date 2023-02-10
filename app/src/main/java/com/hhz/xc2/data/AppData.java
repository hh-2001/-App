package com.hhz.xc2.data;

import android.app.Application;

import com.hhz.xc2.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class AppData extends Application {

        public List<Product> selectedproduct=new ArrayList<>();                //用于存放已选小吃
        public double countprice;                                         //用于存放总价
        public String countremarks;                                       //用于存放总备注
        public String check;//判断是否登录
        public String  account;//获取登录账号
        /**
         * 初始化方法
         */
        @Override
        public void onCreate() {
            super.onCreate();
        }

}
