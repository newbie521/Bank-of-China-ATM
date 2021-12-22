package com.example.atm;

import static com.example.atm.MainActivity.acc;
import static com.example.atm.MainActivity.avi_money;
import static com.example.atm.MainActivity.pas;
import static com.example.atm.MainActivity.bal;
import static com.example.atm.MainActivity.avi_bal;
import static com.example.atm.Transfer.acc1;
import static com.example.atm.Transfer.bal1;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Remind extends AppCompatActivity {
    private String flag =  "0";
    public static List<Fruit> database_tmp = new ArrayList<>();
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remind);
        TextView textView = (TextView) findViewById(R.id.textview1);
        Button return1 = (Button) findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);
        Button display = (Button) findViewById(R.id.显示余额);
        Button print = (Button) findViewById(R.id.打印凭条);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        if (data.equals("0")){
            textView.setText("提示：操作失败");
        }else if(data.equals("1")){
            textView.setText("提示：操作成功");
        }
        else if(data.equals("2")){
//           取款
            String value = intent.getStringExtra("value");
            if(Integer.parseInt(value)>bal){
//                余额不足
                textView.setText("提示：余额不足");
                Toast.makeText(this, "余额不足！", Toast.LENGTH_SHORT).show();
            }else{
                if(Integer.parseInt(value)>avi_bal){
                    if(Integer.parseInt(value)>avi_money){
                        Toast.makeText(Remind.this, "金额超出额度：10000", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Remind.this, "今日可取金额："+ avi_bal, Toast.LENGTH_SHORT).show();
                    }

                }else{
                    bal -= Integer.parseInt(value);
                    avi_bal -= Integer.parseInt(value);

                    Acc database = new Acc();
                    database.setBalance(bal);
                    database.setAvi_balance(avi_bal);
                    database.updateAll("account = ?", acc);
//              获取时间
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();

                    Information database1 = new Information();
                    database1.setAccount(acc);
                    database1.setDate(formatter.format(date));
                    database1.setExchange(value);
                    database1.setType("取款");
                    database_tmp.add(new Fruit(database1.getDate(), database1.getExchange(),database1.getType()));//记录此次操作
                    database1.save();

                    Toast.makeText(this, "取款成功！", Toast.LENGTH_SHORT).show();
                    textView.setText("提示：取款成功");
                    flag = "1";
                }
            }
            display.setVisibility(View.VISIBLE); // 查看账户余额
            print.setVisibility(View.VISIBLE); // 查看账户交易记录
        }
        else if(data.equals("3")){
//          存款
            String value = intent.getStringExtra("value");

            bal += Integer.parseInt(value);
            Acc database = new Acc();
            database.setBalance(bal);
            database.updateAll("account = ?", acc);
            Log.d("ChangePassword", "修改余额:"+acc);

//          修改自己账户记录
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取时间
            Date date = new Date();
            Information database1 = new Information();
            database1.setAccount(acc);
            database1.setDate(formatter.format(date));
            database1.setExchange(value);
            database1.setType("存款");
            database_tmp.add(new Fruit(database1.getDate(), database1.getExchange(),database1.getType()));//记录此次操作
            database1.save();

            textView.setText("提示：存款成功");
            Toast.makeText(this, "存款成功！", Toast.LENGTH_SHORT).show();
            display.setVisibility(View.VISIBLE); // 查看账户余额
            print.setVisibility(View.VISIBLE); // 查看账户交易记录

        }
        else if(data.equals("4")){
//          转账
          String value = intent.getStringExtra("value");
            if(Integer.parseInt(value)>bal){
//                余额不足
                textView.setText("提示：余额不足");
                Toast.makeText(this, "余额不足！", Toast.LENGTH_SHORT).show();
            }else{
//                修改自己账户余额
                Acc database = new Acc();
                bal -= Integer.parseInt(value);
                avi_bal -= Integer.parseInt(value);
                database.setBalance(bal);
                database.setAvi_balance(avi_bal);
                database.updateAll("account = ?", acc);

//                修改自己账户记录
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取时间
                Date date = new Date();
                Information database1 = new Information();
                database1.setAccount(acc);
                database1.setDate(formatter.format(date));
                database1.setExchange(value);
                database1.setType("转出");
                database_tmp.add(new Fruit(database1.getDate(), database1.getExchange(),database1.getType()));//记录此次操作
                database1.save();

//                修改转账账户余额
                bal1 += Integer.parseInt(value); //新增金额
                Acc database2 = new Acc();
                database2.setBalance(bal1);
                database2.updateAll("account = ?", acc1);

//                修改转入账户记录
                Information database3 = new Information();
                database3.setAccount(acc1);
                database3.setDate(formatter.format(date));
                database3.setExchange(value);
                database3.setType("转入");
                database3.save();


                Log.d("ChangePassword", "修改余额:"+acc1);
                textView.setText("提示：转账成功");
                Toast.makeText(this, "转账成功！", Toast.LENGTH_SHORT).show();
                flag = "1";

                display.setVisibility(View.VISIBLE);
                print.setVisibility(View.VISIBLE);
            }

        }

//        返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.equals("0")){
                    Intent intent1 = new Intent(Remind.this, ChangePassword.class);
                    startActivity(intent1);
                }else if(data.equals("1")){
                    Intent intent1 = new Intent(Remind.this, function.class);
                    startActivity(intent1);
                }else if(data.equals("2")&&flag.equals("0")){
                    Intent intent1 = new Intent(Remind.this, GetMoney.class);
                    startActivity(intent1);
                }else if(data.equals("2")&&flag.equals("1")){
                    Intent intent1 = new Intent(Remind.this, function.class);
                    startActivity(intent1);
                }else if(data.equals("3")){
                    Intent intent1 = new Intent(Remind.this, function.class);
                    startActivity(intent1);
                }else if(data.equals("4")&&flag.equals("0")){
                    Intent intent1 = new Intent(Remind.this, Transfer.class);
                    startActivity(intent1);
                }else if(data.equals("4")&&flag.equals("1")){
                    Intent intent1 = new Intent(Remind.this, function.class);
                    startActivity(intent1);
                }

                finish();
            }
        });
//        退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Remind.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Remind.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();

            }
        });

//        显示余额
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              跳转到余额查询界面
                Intent intent1 = new Intent(Remind.this, Display.class);
                startActivity(intent1);
                finish();
            }
        });

//        打印凭条 暂时先写成交易明细查询
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Remind.this, Print.class);
                startActivity(intent1);
                finish();

            }
        });

    }
}
