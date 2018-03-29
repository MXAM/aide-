package com.mxaide.jl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new xuexi()).commit();    
					return true;
                case R.id.navigation_dashboard:
					getSupportFragmentManager().beginTransaction().replace(R.id.content,new shiping()).commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new gongju()).commit();
                    return true;
					
					
            }
			
			
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		getSupportFragmentManager().beginTransaction().replace(R.id.content,new xuexi()).commit();   
     
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		
	
		
		
		
		
    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //四个参数的含义。1，group的id,2,item的id,3,是否排序，4，将要显示的内容
        menu.add(0,1,0,"关于");
        
        

        return true;
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
				Intent intent =new Intent(MainActivity.this, about.class);
				startActivity(intent);                break;
        
        }
        return true;
    }
}
