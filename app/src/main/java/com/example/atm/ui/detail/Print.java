package com.example.atm.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.atm.ui.detail.Remind.database_tmp;
import androidx.appcompat.app.AppCompatActivity;

import com.example.atm.MainActivity;
import com.example.atm.R;
import com.example.atm.util.FruitAdapter;

public class Print extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display1);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("交易凭条");
        FruitAdapter adapter = new FruitAdapter(Print.this, R.layout.fruit_item, database_tmp);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Button return1 = (Button)findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);

//        返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Print.this, function.class);
                startActivity(intent);
                finish();
            }
        });
//       退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Print.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Print.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
