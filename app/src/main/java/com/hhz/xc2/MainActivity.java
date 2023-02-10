package com.hhz.xc2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.hhz.xc2.data.AppData;
import com.hhz.xc2.fragment.NewFragment;
import com.hhz.xc2.fragment.ProducstFragment;
import com.hhz.xc2.fragment.SettlementFragment;
import com.hhz.xc2.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 vp;
    public static ImageView homeiv;
    public static TextView hometv;
    public static ImageView productiv;
    public static TextView producttv;
    public static ImageView settlementiv;
    public static TextView settlementtv;
    public static ImageView useriv;
    public static TextView usertv;
    private AppData app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        setContentView(R.layout.activity_main);
        initFragment();
        initClick();

        app= (AppData) MainActivity.this.getApplication();              //获得全局类
        Intent i=getIntent();
        String account=i.getStringExtra("account");//获取登录状态
        String name=i.getStringExtra("state");
        app.check=name;
        app.account=account;
      //  Toast.makeText(MainActivity.this,app.check,Toast.LENGTH_LONG).show();

    }
    private void initFragment(){
        //创建Fragment集合
        final List<Fragment> list=new ArrayList<>();
        list.add(new NewFragment());
        list.add(new ProducstFragment());
        list.add(new SettlementFragment());
        list.add(new UserFragment());

        vp=findViewById(R.id.viewPager2);               //获得ViewPager2控件
        //设置预加载的Fragment页面数量，可防止流式布局StaggeredGrid数组越界错误。
        vp.setOffscreenPageLimit(list.size() - 1);                                                                     													//设置适配器
        FragmentStateAdapter adapter=new FragmentStateAdapter(MainActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return list.get(position);
            }
            @Override
            public int getItemCount() {
                return list.size();
            }
        };

        vp.setAdapter(adapter);                     //把适配器添加给ViewPager2
    }

    private  void initClick(){
        homeiv=findViewById(R.id.imageHome);
        hometv=findViewById(R.id.textHome);
        productiv=findViewById(R.id.imageProduct);
        producttv=findViewById(R.id.textProduct);
        settlementiv=findViewById(R.id.imageSettlement);
        settlementtv=findViewById(R.id.textSettlement);
        useriv=findViewById(R.id.imageUser);
        usertv=findViewById(R.id.textUser);

        //给新品选项添加点击事件
        LinearLayout btnhome=findViewById(R.id.btnHome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0,false);
                initHomeBtnColor();
            }
        });

        //给点菜选项添加添加事件
        LinearLayout btnproduct=findViewById(R.id.btnProduct);
        btnproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1,false);
                initProductBtnColor();
            }
        });
        //给下单选项添加点击事件
        LinearLayout btnsettlement=findViewById(R.id.btnSettlement);
        btnsettlement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(2,false);
                initSettlementBtnColor();
            }
        });
        //给我的选项添加点击事件
        LinearLayout btnuser=findViewById(R.id.btnUser);
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(3,false);
                initUserBtnColor();
            }
        });
    }
    /**
     * 选中新品选项时的颜色
     */
    public static void initHomeBtnColor(){
        homeiv.setImageResource(R.mipmap.home1);
        hometv.setTextColor(Color.rgb(0,188,212));
        productiv.setImageResource(R.mipmap.product2);
        producttv.setTextColor(Color.rgb(148,148,148));
        settlementiv.setImageResource(R.mipmap.settlement2);
        settlementtv.setTextColor(Color.rgb(148,148,148));
        useriv.setImageResource(R.mipmap.user2);
        usertv.setTextColor(Color.rgb(148,148,148));
    }
    /**
     * 选中点菜选项时的颜色
     */
    public static void initProductBtnColor(){
        homeiv.setImageResource(R.mipmap.home2);
        hometv.setTextColor(Color.rgb(148,148,148));
        productiv.setImageResource(R.mipmap.product1);
        producttv.setTextColor(Color.rgb(0,188,212));
        settlementiv.setImageResource(R.mipmap.settlement2);
        settlementtv.setTextColor(Color.rgb(148,148,148));
        useriv.setImageResource(R.mipmap.user2);
        usertv.setTextColor(Color.rgb(148,148,148));
    }

    /**
     * 选中下单选项时的颜色
     */
    public static void initSettlementBtnColor(){
        homeiv.setImageResource(R.mipmap.home2);
        hometv.setTextColor(Color.rgb(148,148,148));
        productiv.setImageResource(R.mipmap.product2);
        producttv.setTextColor(Color.rgb(148,148,148));
        settlementiv.setImageResource(R.mipmap.settlement1);
        settlementtv.setTextColor(Color.rgb(0,188,212));
        useriv.setImageResource(R.mipmap.user2);
        usertv.setTextColor(Color.rgb(148,148,148));
    }

    /**
     * 选中我的选项时的颜色
     */
    public static void initUserBtnColor(){
        homeiv.setImageResource(R.mipmap.home2);
        hometv.setTextColor(Color.rgb(148,148,148));
        productiv.setImageResource(R.mipmap.product2);
        producttv.setTextColor(Color.rgb(148,148,148));
        settlementiv.setImageResource(R.mipmap.settlement2);
        settlementtv.setTextColor(Color.rgb(148,148,148));
        useriv.setImageResource(R.mipmap.user1);
        usertv.setTextColor(Color.rgb(0,188,212));
    }
}