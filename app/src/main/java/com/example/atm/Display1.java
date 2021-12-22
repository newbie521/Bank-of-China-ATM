package com.example.atm;

import static com.example.atm.MainActivity.avi_bal;
import static com.example.atm.MainActivity.avi_money;
import static com.example.atm.MainActivity.bal;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import static com.example.atm.MainActivity.acc;

public class Display1 extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display1);

        FruitAdapter adapter = new FruitAdapter(Display1.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter) ;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("交易明细查询");

//        TextView textView1 = (TextView) findViewById(R.id.textView4);
//        TextView textView2 = (TextView) findViewById(R.id.textView5);
//        TextView textView3 = (TextView) findViewById(R.id.textView6);
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setMovementMethhod(ScrollingMovementMethod.getInstance());
//        textView3.setMovementMethod(new ScrollingMovementMethod());
        Button return1 = (Button)findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);

        List<Information> some = DataSupport.findAll(Information.class);
        for(Information book:some) {
            if(acc.equals(book.getAccount())){
                Fruit apple = new Fruit(book.getDate(), book.getExchange(),book.getType());
                fruitList.add(apple);
//                textView1.append(book.getDate() + "\n");
//                textView2.append(book.getExchange() + "\n");
//                textView3.append(book.getType() + "\n");
            }
        }

//       返回
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Display1.this, function.class);
                startActivity(intent);
                finish();
            }
        });

        //       退卡
        back_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                退卡界面
                Intent intent1 = new Intent(Display1.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Display1.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
