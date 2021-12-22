package com.example.atm;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.atm.Remind.database_tmp;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Print extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display1);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("交易凭条");

        FruitAdapter adapter = new FruitAdapter(Print.this, R.layout.fruit_item, database_tmp);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Button return1 = (Button)findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);

//        textView.setText(Html.fromHtml(news));//这是显示段落文本的,通过解析html
//        textView.setText(news);
//        textView.setMovementMethod(ScrollingMovementMethod.getInstance());//段落文本的话要加这个
//       返回
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
//                退卡界面
                Intent intent1 = new Intent(Print.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Print.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
