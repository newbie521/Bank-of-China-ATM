package com.example.atm.ui.detail;

import static com.example.atm.MainActivity.acc;
import static com.example.atm.MainActivity.avi_money;
import static com.example.atm.MainActivity.bal;
import static com.example.atm.MainActivity.avi_bal;
import static com.example.atm.ui.detail.transfer.Transfer.acc1;
import static com.example.atm.ui.detail.transfer.Transfer.bal1;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.MainActivity;
import com.example.atm.R;
import com.example.atm.database.Acc;
import com.example.atm.database.Information;
import com.example.atm.ui.detail.changeMoney.ChangePassword;
import com.example.atm.ui.detail.getmoney.GetMoney;
import com.example.atm.ui.detail.seek.Display;
import com.example.atm.ui.detail.transfer.Transfer;
import com.example.atm.util.Fruit;

import org.litepal.crud.DataSupport;

import java.text.BreakIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Remind extends AppCompatActivity {
    private String flag =  "0";
    public static List<Fruit> database_tmp = new ArrayList<>();
    private TextView textView;
    private Button return1;
    private Button back_card;
    private Button display;
    private Button print;
    private String data;

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remind);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView = (TextView) findViewById(R.id.textview1);
        return1 = (Button) findViewById(R.id.返回);
        back_card = (Button) findViewById(R.id.退卡);
        display = (Button) findViewById(R.id.显示余额);
        print = (Button) findViewById(R.id.打印凭条);
//        接收数据

        try{
            getData() ;
        }catch(ParseException e){

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
                Intent intent1 = new Intent(Remind.this, Display.class);
                startActivity(intent1);
                finish();
            }
        });
//        打印凭条
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Remind.this, Print.class);
                startActivity(intent1);
                finish();
            }
        });

    }
    private void getData()throws ParseException {
        Intent intent = getIntent();

        data = intent.getStringExtra("data");

        if (data.equals("0")){
            textView.setText("提示：操作失败");
        }else if(data.equals("1")){
            textView.setText("提示：操作成功");
        }
        else if(data.equals("2")){
//           取款
            String value = intent.getStringExtra("value");

//          每天可取款值为1000
            List<Information> some = DataSupport.findAll(Information.class);
            for(int i = some.size()-1;i>=0;i--){
                if(acc.equals(some.get(i).getAccount())){
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    int x = differentDays(new Date() ,df.parse(some.get(i).getDate())); // 与上次相差几天
//                    long time = (new Date().getTime() - df.parse(some.get(i).getDate()).getTime());
//                    String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
                    if(x > 0){
                        avi_bal = 10000;
                        Acc database = new Acc();
                        database.setAvi_balance(avi_bal);
                        database.updateAll("account = ?", acc);
                    }
                    break;
                }
            }

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

    }

    public static int differentDays(Date beforeDate, Date currentDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(beforeDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(currentDate);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }


}
