package com.example.atm.ui.detail.seek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import static com.example.atm.MainActivity.acc;

import com.example.atm.ui.detail.function;
import com.example.atm.MainActivity;
import com.example.atm.R;
import com.example.atm.database.Information;
import com.example.atm.util.Fruit;
import com.example.atm.util.FruitAdapter;
import com.example.atm.util.MyAppCompatActivity;

public class Display1 extends MyAppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display1);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FruitAdapter adapter = new FruitAdapter(Display1.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter) ;
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("交易明细查询");
        Button return1 = (Button)findViewById(R.id.返回);
        Button back_card = (Button) findViewById(R.id.退卡);
//      ListView 数据获取
        List<Information> some = DataSupport.findAll(Information.class);
        for(Information book:some) {
            if(acc.equals(book.getAccount())){
                Fruit apple = new Fruit(book.getDate(), book.getExchange(),book.getType());
                fruitList.add(apple);
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
                Intent intent1 = new Intent(Display1.this, MainActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(Display1.this, "欢迎下次使用", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
