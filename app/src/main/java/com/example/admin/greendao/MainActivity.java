package com.example.admin.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.greendao.bean.UserBean;

import java.util.List;

import greendao.UserBeanDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button main_ins, main_del, main_chaung, main_cha;
    private UserBeanDao mUserBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        main_del = findViewById(R.id.main_del);
        main_ins = findViewById(R.id.main_ins);
        main_chaung = findViewById(R.id.main_chaung);
        main_cha = findViewById(R.id.main_cha);
        main_ins.setOnClickListener(this);
        main_del.setOnClickListener(this);
        main_chaung.setOnClickListener(this);
        main_cha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_del:
                mUserBeanDao.deleteByKey(2l);
                break;

            case R.id.main_ins:
                mUserBeanDao.insert(new UserBean(null,"短裤超人"));
                break;

            case R.id.main_chaung:
                mUserBeanDao = MyApp.getInstances().getDaoSession().getUserBeanDao();

                break;

            case R.id.main_cha:
                List<UserBean> user = mUserBeanDao.loadAll();
                for (int i = 0; i < user.size(); i++) {
                    Log.i(TAG, "onClick: "+user.get(i).getId()+","+user.get(i).getName());
                }
                /*UserBean load = mUserBeanDao.load(2l);
                Log.d(TAG, "onClick: "+load.getName()+","+load.getId());*/
                break;
        }
    }
}
