package com.example.atm.ui.detail.getmoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.MainActivity;
import com.example.atm.ui.detail.Remind;
import com.example.atm.ui.detail.function;
import com.example.atm.util.MyAppCompatActivity;
import com.example.atm.util.MyButton;
import com.example.atm.R;

public class GetMoney extends MyAppCompatActivity {
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_money1);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EditText editText = (EditText) findViewById(R.id.editText);
        MyButton button_100 = findViewById(R.id.button_100);
        MyButton button_200 = findViewById(R.id.button_200);
        MyButton button_500 = (MyButton) findViewById(R.id.button_500);
        MyButton button_1000 = (MyButton) findViewById(R.id.button_1000);
        MyButton firm = (MyButton) findViewById(R.id.确认);
        MyButton return1 = (MyButton)findViewById(R.id.返回);
        MyButton back_card = (MyButton) findViewById(R.id.退卡);

//       100
        button_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("100");
            }
        });
//       200
        button_200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("200");
            }
        });
//       500
        button_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("500");
            }
        });
//       1000
        button_1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("1000");
            }
        });
//       确认
        firm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")){
                    Intent intent = new Intent(GetMoney.this, Remind.class);
                    intent.putExtra("data", "2");//取款金额
                    intent.putExtra("value", editText.getText().toString());
                    startActivity(intent);
                    finish();
                }

            }
        });
//       返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetMoney.this, function.class);
                startActivity(intent);
                finish();
            }
        });
 //       退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                退卡界面
                Intent intent1 = new Intent(GetMoney.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(GetMoney.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
