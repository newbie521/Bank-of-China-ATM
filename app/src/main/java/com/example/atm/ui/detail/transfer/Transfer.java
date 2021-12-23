package com.example.atm.ui.detail.transfer;

import static com.example.atm.MainActivity.acc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.ui.detail.Remind;
import com.example.atm.ui.detail.function;
import com.example.atm.util.MyButton;
import com.example.atm.R;
import com.example.atm.database.Acc;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Transfer extends AppCompatActivity {
    public static String acc1; //转账账号
    public static int bal1;
    public static int  state = 0;//区别在 转账账号 和 转账金额 界面

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer1);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView1 = (TextView) findViewById(R.id.textview1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        EditText editText = (EditText) findViewById(R.id.editText);
        MyButton button1 = findViewById(R.id.确认);
        MyButton button2 = findViewById(R.id.清除);
        MyButton button3 = findViewById(R.id.返回);
//        判定转账金额还是转账账号
        if(state == 1){
            textView1.setText("转账金额");
            textView2.setText("请输入金额：");
            editText.setText("");
            editText.setHint("请输入转账金额");
        }else{
            textView1.setText("转账账号");
            textView2.setText("请输入账号：");
            editText.setText("");
            editText.setHint("请输入转账账号");
        }

//        确认
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")){
                    if(editText.getText().toString().equals(acc)){
                        Toast.makeText(Transfer.this,"提示;不能给自己转账",Toast.LENGTH_SHORT).show();
                    }
                    else if(state == 0){
                        List<Acc> some = DataSupport.findAll(Acc.class);
                        System.out.println(some);
                        for(Acc book:some) {
                            if(editText.getText().toString().equals(book.getAccount())){
                                acc1 = editText.getText().toString();
                                bal1 = book.getBalance();
                                state = 1;
                                Intent intent = new Intent(Transfer.this, Transfer.class);
                                startActivity(intent);
                                finish();
                            };
                        }
                    }else if(state == 1){
                        Intent intent = new Intent(Transfer.this, Remind.class);
                        intent.putExtra("data", "4");//转账金额
                        intent.putExtra("value", editText.getText().toString());
                        startActivity(intent);
                        state = 0;
                        finish();
                    }
                }
                else{
                }
            }
        });
//        清除
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
//        返回
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state==1) {
                    Intent intent = new Intent(Transfer.this, Transfer.class);
                    startActivity(intent);
                    finish();
                    state = 0;
                }else{
                    Intent intent = new Intent(Transfer.this, function.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
