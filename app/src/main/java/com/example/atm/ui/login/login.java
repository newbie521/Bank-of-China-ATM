package com.example.atm.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.MainActivity;
import com.example.atm.R;
import com.example.atm.ui.detail.function;
import com.example.atm.util.MyAppCompatActivity;

public class login extends MyAppCompatActivity {
    private  int pas_error = 0;
    private password password;
    private  String temp ="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = (TextView) findViewById(R.id.textView1);
        password password= findViewById(R.id.pc_1);
        Button confirm = (Button) findViewById(R.id.确认);
        Button clear = (Button) findViewById(R.id.清除);
        Button quit = (Button) findViewById(R.id.退卡);

        confirm.setClickable(false);
//        确认
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                            if(temp.equals(MainActivity.pas)){
                                Intent intent = new Intent(login.this, function.class);
                                startActivity(intent);
                                Toast.makeText(login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
//                            登陆失败，转到提示 remind界面
                            else {
                                if(pas_error<2){
                                    textView.setText("提示：密码错误，请重新输入");
                                    password.et_code.setText("");
                                    password.codes.clear();
                                    password.showCode();

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
        });

//        清除
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                password.setText(null);
                password.codes.clear();
                password.showCode();
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

//注册事件回调（根据实际需要，可写，可不写）
        password.setOnInputListener(new password.OnInputListener() {
            @Override
            public void onSucess(String code) {
                //TODO: 例如底部【下一步】按钮可点击
//                Toast.makeText(login.this, "sdddddddddd", Toast.LENGTH_SHORT).show();
                confirm.setClickable(true);
                temp = code;
            }

            @Override
            public void onInput() {
                //TODO:例如底部【下一步】按钮不可点击
            }
        });

    }

}
