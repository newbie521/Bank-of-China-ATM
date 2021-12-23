package com.example.atm.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.ui.detail.changeMoney.ChangePassword;
import com.example.atm.MainActivity;
import com.example.atm.R;
import com.example.atm.ui.detail.getmoney.GetMoney;
import com.example.atm.ui.detail.putmoney.PutMoney;
import com.example.atm.ui.detail.seek.Seek;
import com.example.atm.ui.detail.transfer.Transfer;

public class function extends AppCompatActivity {

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button1 = (Button) findViewById(R.id.取款);
        Button button2 = (Button) findViewById(R.id.存款);
        Button button3 = (Button) findViewById(R.id.查询);
        Button button4 = (Button) findViewById(R.id.转账);
        Button button5 = (Button) findViewById(R.id.修改密码);
        Button button6 = (Button) findViewById(R.id.退卡);

//      取款
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(function.this, GetMoney.class);
                startActivity(intent1);
                Toast.makeText(function.this, "取款", Toast.LENGTH_SHORT).show();
            }
        });
//      存款
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(function.this, PutMoney.class);
                startActivity(intent1);
                Toast.makeText(function.this, "存款", Toast.LENGTH_SHORT).show();
            }
        });
//      查询
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(function.this, Seek.class);
                startActivity(intent1);
                Toast.makeText(function.this, "查询", Toast.LENGTH_SHORT).show();
            }
        });
//      转账
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              转到修改转账Transfer界面
                Intent intent = new Intent(function.this, Transfer.class);
                startActivity(intent);
                Toast.makeText(function.this, "转账", Toast.LENGTH_SHORT).show();
            }
        });
//      修改密码
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              转到修改密码ChangePassword界面
                Intent intent = new Intent(function.this, ChangePassword.class);
                startActivity(intent);
                Toast.makeText(function.this, "修改密码", Toast.LENGTH_SHORT).show();
            }
        });
//      退卡
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(function.this, MainActivity.class);
                startActivity(intent1);
                Toast.makeText(function.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
