package com.example.atm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.atm.MainActivity.bal;
import static com.example.atm.MainActivity.avi_bal;
import static com.example.atm.MainActivity.avi_money;




import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Display extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        Button return1 = (Button)findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);

        textView1.setText(String.valueOf(bal));
        textView2.setText(String.valueOf(avi_bal));
        textView3.setText(String.valueOf(avi_money));

//        List<Information> some = DataSupport.findAll(Information.class);
//        for(Information book:some) {
//            if(acc.equals(book.getAccount())){
//
//            }
//        }

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
