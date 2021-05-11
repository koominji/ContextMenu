package com.kmj.contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    LinearLayout baseLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        registerForContextMenu(btn1);

        btn2 =(Button)findViewById(R.id.btn2);
        registerForContextMenu(btn2);

        baseLayout=(LinearLayout)findViewById(R.id.baseLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //인플레이터 생성
        MenuInflater mInflater = getMenuInflater();

        //롱클릭한 위젯이 btn1이면
        if(v==btn1){
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1,menu);
        }
        //롱클릭한 위젯이 btn2이면
        if(v==btn2){
            mInflater.inflate(R.menu.menu2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.rotate45:
                btn2.setRotation(45);
                return true;
            case R.id.size2:
                btn2.setScaleX(2);
                return true;
        }
        return false;

    }
}

