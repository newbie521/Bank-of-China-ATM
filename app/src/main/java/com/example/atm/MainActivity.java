package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.atm.database.Acc;
import com.example.atm.database.Information;
import com.example.atm.ui.login.login;
import com.example.atm.ui.login.password;
import com.example.atm.util.MyAppCompatActivity;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends MyAppCompatActivity {

    public static String  acc;
    public static String pas;
    public static int bal;
    public static int avi_bal;//    当日可用金额
    public static final int avi_money = 10000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

//        设置全透明状态栏
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
//        }

//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.waiting);
        Button button = (Button) findViewById(R.id.button); // 插卡
        EditText account = (EditText) findViewById(R.id.account); // 卡号
        Button warn = (Button) findViewById(R.id.用户须知); //用户须知

//        初始化数据库
        Button addData= (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建数据库
                LitePal.getDatabase();
                // list表

                DataSupport.deleteAll(Information.class);
                DataSupport.deleteAll(Acc.class);

                Acc database = new Acc();
                database.setAccount("08192977");
                database.setPassword("123456");
                database.setBalance(50000);
                database.setAvi_balance(10000);
                database.save();


                Acc database1 = new Acc();
                database1.setAccount("08192978");
                database1.setPassword("123456");
                database1.setBalance(60000);
                database1.setAvi_balance(10000);
                database1.save();

                Acc database2 = new Acc();
                database2.setAccount("08192979");
                database2.setPassword("123456");
                database2.setBalance(70000);
                database2.setAvi_balance(10000);
                database2.save();
//
//                Information database3 = new Information();
//                database3.setDate("2000");
//                database3.setExchange("00");
//                database3.setType("dsa");
//                database3.save();

            }
        });
//        插入卡
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (account.getText().equals("")){

                }
                else {
                    List<Acc> some = DataSupport.findAll(Acc.class);
                    System.out.println(some);
                    for(Acc book:some) {
                        if(account.getText().toString().equals(book.getAccount())){
                            acc = book.getAccount();
                            pas = book.getPassword();
                            bal = book.getBalance();
                            avi_bal = book.getAvi_balance();

                            Log.d("MainActivity", "account " + book.getAccount());
                            Log.d("MainActivity", "password " + book.getPassword());
                            Log.d("MainActivity", "balance " + book.getBalance());

//                          加载中
//                           转到输入密码login界面
                            Intent intent = new Intent(MainActivity.this, login.class);
//                           intent.putExtra("password",pas);
                            startActivity(intent);

                            break;
                        }else {
                            Toast.makeText(MainActivity.this, "用户账号不存在", Toast.LENGTH_SHORT).show();
                        }
                    }

                }



            }
        });
//        用户须知
        warn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Warn.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText account = (EditText) findViewById(R.id.account); // 卡号
        account.setText("");
    }

}