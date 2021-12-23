package com.example.atm.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.atm.R;

import androidx.annotation.Nullable;
// 自定义Button按钮
public class MyButton extends LinearLayout {
    LinearLayout myButton;
    TextView mybutton1;

    public MyButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mybutton,this,true);
//        myButton = findViewById(R.id.mybutton);
        mybutton1 = findViewById(R.id.mybutton1);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyButton);
        mybutton1.setText(typedArray.getText((R.styleable.MyButton_mybutton_text)));
        typedArray.recycle();
    }
}
