package com.example.meiakirazen.wego_app;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private  Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment

    private void initFragment() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragments = new Fragment[]{fragment1,fragment2,fragment3};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment1).show(fragment1).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(lastfragment!=0){
                        switchFragment(lastfragment,0);
                        lastfragment=0;
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if(lastfragment!=1){
                        switchFragment(lastfragment,1);
                        lastfragment=1;
                    }
                    return true;
                case R.id.navigation_notifications:
                    if(lastfragment!=2){
                        switchFragment(lastfragment,2);
                        lastfragment=2;
                    }
                    return true;
            }
            return false;
        }
    };

    private void switchFragment(int lastfragment,int index) {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false) {
            transaction.add(R.id.mainview,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setContentView(R.layout.activity_main);
        initFragment();;
//        replaceFragment(new Fragment());
//        /**
//         * 轮播图
//         */
//        pager = (ViewPager) findViewById(R.id.view_pager);
//        PagerAdapter adapter = new ViewAdapter(pages);
//        pager.setAdapter(adapter);

//        button_1 = (ImageButton)findViewById(R.id.imageButton1);
//        button_2 = (ImageButton)findViewById(R.id.imageButton2);
//        button_3 = (ImageButton)findViewById(R.id.imageButton3);
//        button_4 = (ImageButton)findViewById(R.id.imageButton4);
//        button_5 = (ImageButton)findViewById(R.id.imageButton5);
//        button_6 = (ImageButton)findViewById(R.id.imageButton6);
//        //设置监听方法
//        button_1.setOnClickListener(this);
//        button_2.setOnClickListener(this);
//        button_3.setOnClickListener(this);
//        button_4.setOnClickListener(this);
//        button_5.setOnClickListener(this);
//        button_6.setOnClickListener(this);
    }
//
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.)
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    /**
     * 这个地方对侧边栏的内容相应进行定义，未完成
     */
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            /**
             * 调用摄像头
             */
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            /**
             * 启用本地相册
             */
        } else if (id == R.id.nav_share) {
            /**
             * 社交软件分享作用
             */
        } else if (id == R.id.nav_set) {
            /**
             * 个人信息设置功能
             */
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 用于轮播图
     */
    private class ViewAdapter extends PagerAdapter {
        private List<View> datas;

        public ViewAdapter(List<View>list) {
            datas = list;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = datas.get(position);
            container.addView(view);
            return view;
        }

        public void destoryItem(ViewGroup container, int position, Object object){
            container.removeView(datas.get(position));
        }
    }

    private TextView mTextMessage;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };
    /**
     * 重写主类的按钮点击方法
     * @param v
//     */
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.imageButton1:
//                Intent intent1 = new Intent(MainActivity.this, RunActivity.class);
//                startActivity(intent1);
//                break;
//            case R.id.imageButton2:
//                Intent intent2 = new Intent(MainActivity.this, MatchActivity.class);
//                startActivity(intent2);
//                break;
//            case R.id.imageButton3:
//                Intent intent3 = new Intent(MainActivity.this, BrandActivity.class);
//                startActivity(intent3);
//                break;
//            case R.id.imageButton4:
//                Intent intent4 = new Intent(MainActivity.this, ChatActivity.class);
//                startActivity(intent4);
//                break;
//            case R.id.imageButton5:
//                Intent intent5 = new Intent(MainActivity.this, ItemActivity.class);
//                startActivity(intent5);
//                break;
//            case R.id.imageButton6:
//                Intent intent6 = new Intent(MainActivity.this, ReviewActivity.class);
//                startActivity(intent6);
//                break;
//        }
//    }
}
