package com.example.atm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String  acc;
    public static String pas;
    public static int bal;
    public static int avi_bal;//    当日可用金额
    public static final int avi_money = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                finish();
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