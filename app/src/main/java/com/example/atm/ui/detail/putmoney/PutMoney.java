package com.example.atm.ui.detail.putmoney;

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
import com.example.atm.util.MyButton;;
import com.example.atm.R;

public class PutMoney extends MyAppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.put_money1);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EditText editText = (EditText) findViewById(R.id.editText);
        MyButton firm = findViewById(R.id.确认);
        MyButton return1 = findViewById(R.id.返回);
        MyButton back_card = findViewById(R.id.退卡);

//       确认
        firm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")){
                    Intent intent = new Intent(PutMoney.this, Remind.class);
                    intent.putExtra("data", "3");//存款金额
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
                Intent intent = new Intent(PutMoney.this, function.class);
                startActivity(intent);
                finish();
            }
        });
//       退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PutMoney.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(PutMoney.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
