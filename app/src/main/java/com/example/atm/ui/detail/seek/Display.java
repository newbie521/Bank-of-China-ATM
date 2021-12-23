package com.example.atm.ui.detail.seek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.atm.MainActivity.bal;
import static com.example.atm.MainActivity.avi_bal;
import static com.example.atm.MainActivity.avi_money;

import com.example.atm.ui.detail.function;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.MainActivity;
import com.example.atm.R;
import com.example.atm.util.MyAppCompatActivity;

public class Display extends MyAppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        Button return1 = (Button)findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);
        textView1.setText(String.valueOf(bal));
        textView2.setText(String.valueOf(avi_bal));
        textView3.setText(String.valueOf(avi_money));

//       返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Display.this, function.class);
                startActivity(intent);
                finish();
            }
        });
//       退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                退卡界面
                Intent intent1 = new Intent(Display.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Display.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
