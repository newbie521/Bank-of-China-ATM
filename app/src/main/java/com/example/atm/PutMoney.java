package com.example.atm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PutMoney extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.put_money1);

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
                //                退卡界面
                Intent intent1 = new Intent(PutMoney.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(PutMoney.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
