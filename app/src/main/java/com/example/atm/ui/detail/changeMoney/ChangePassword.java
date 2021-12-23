package com.example.atm.ui.detail.changeMoney;

import static com.example.atm.MainActivity.acc;
import static com.example.atm.MainActivity.pas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.ui.detail.Remind;
import com.example.atm.ui.detail.function;
import com.example.atm.util.MyAppCompatActivity;
import com.example.atm.util.MyButton;
import com.example.atm.R;
import com.example.atm.database.Acc;

public class ChangePassword extends MyAppCompatActivity {

private String password1 = "";

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        //        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = (TextView) findViewById(R.id.textview);
        EditText editText = (EditText) findViewById(R.id.password);
        MyButton firm = findViewById(R.id.确认);
        MyButton clear = findViewById(R.id.清除);
        MyButton return1 = findViewById(R.id.返回);

//      确认
        firm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")||editText.getText().toString().equals(pas)){
//                    使用LitePal更新数据
                    Log.d("ChangePassword", " sds  " +password1);
                    if(password1.equals("")){
                        textView.setText("请再次输入新密码");
                        password1 = editText.getText().toString();
                        editText.setText("");
                    }else if(password1.equals(editText.getText().toString())){
                        Acc database = new Acc();
                        database.setPassword(editText.getText().toString());
                        database.updateAll("account = ?", acc);
                        Log.d("ChangePassword", "修改密码:"+acc);
                        password1 = "";
//                        转到提示成功界面
                        Intent intent = new Intent(ChangePassword.this, Remind.class);
                        intent.putExtra("data", "1");
                        startActivity(intent);
                        finish();

                    }else if(!password1.equals(editText.getText().toString())){
//                       转到提示错误界面
                        Intent intent = new Intent(ChangePassword.this, Remind.class);
                        intent.putExtra("data", "0");
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
//      清除
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(null);
            }
        });
//      返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePassword.this, function.class);
                intent.putExtra("data", "0");
                startActivity(intent);
                finish();
            }
        });

    }
}
