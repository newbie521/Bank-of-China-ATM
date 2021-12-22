package com.example.atm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    private  int pas_error = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        TextView textView = (TextView) findViewById(R.id.textView1);
        EditText password = (EditText) findViewById(R.id.password);
        Button confirm = (Button) findViewById(R.id.确认);
        Button clear = (Button) findViewById(R.id.清除);
        Button quit = (Button) findViewById(R.id.退卡);

//        确认
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals("")){
                }
                else{
//                加载框
                    ProgressDialog progressDialog = new ProgressDialog(login.this);
                    progressDialog.setTitle("登录");
                    progressDialog.setMessage("加载中...");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                    Handler handler = new Handler();
//                    延迟执行
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.cancel();
//                            登陆成功，转到功能 function界面
                            if(password.getText().toString().equals(MainActivity.pas)){
                                Intent intent = new Intent(login.this, function.class);
                                startActivity(intent);
                                Toast.makeText(login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
//                            登陆失败，转到提示 remind界面
                            else {
                                if(pas_error<2){
                                    textView.setText("提示：密码错误，请重新输入");
                                    password.setText("");
                                    pas_error += 1;
                                    Toast.makeText(login.this, "密码错误，还可尝试"+(3-pas_error)+"次，失败后将吞卡", Toast.LENGTH_SHORT).show();

                                }else {
                                    Intent intent1 = new Intent(login.this, MainActivity.class);
                                    startActivity(intent1);
                                    pas_error = 0;

                                    finish();
                                    Toast.makeText(login.this, "已吞卡，请您到前台领取", Toast.LENGTH_LONG).show();
                                }

                            }
                        }
                    }, 1000);//2秒后执行Runnable中的run方法

                }
            }
        });

//        清除
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setText(null);
            }
        });

//        退卡
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(login.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(login.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
