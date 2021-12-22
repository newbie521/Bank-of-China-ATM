package com.example.atm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Seek extends AppCompatActivity {

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seek);

        MyButton seek1 = findViewById(R.id.余额查询);
        MyButton seek2 = findViewById(R.id.交易明细查询);
        MyButton return1 = findViewById(R.id.返回);
        MyButton back_card = findViewById(R.id.退卡);

//        余额查询
        seek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Seek.this, Display.class);
                startActivity(intent1);
                finish();
            }
        });

//        交易明细查询
        seek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Seek.this, Display1.class);
                startActivity(intent1);
                finish();
            }
        });

//        返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Seek.this, function.class);
                startActivity(intent1);
                finish();
            }
        });

//        退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Seek.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Seek.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
