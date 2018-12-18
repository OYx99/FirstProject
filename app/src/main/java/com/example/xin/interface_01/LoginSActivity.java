package com.example.xin.interface_01;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.design.widget.NavigationView;
import java.lang.reflect.Method;


public class LoginSActivity extends AppCompatActivity {
    private DrawerLayout mSDrawlayout;
    private Button button1;
    private NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_s);
        button1 = (Button) findViewById(R.id.button1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        mSDrawlayout = findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        setListeners();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return  super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.backup_item:
            {Toast.makeText(this,"you click backup",Toast.LENGTH_SHORT).show();break;}
            case android.R.id.home :
            {mSDrawlayout.openDrawer(GravityCompat.START);Toast.makeText(this,"you click home",Toast.LENGTH_SHORT).show();break;}
            default:break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        NavigationItem navigationItem = new NavigationItem();
        button1.setOnClickListener(onClick);
        navView.setNavigationItemSelectedListener(navigationItem);

    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()){
                case R.id.button1:
                    intent = new Intent(LoginSActivity.this, DormitoryActivity.class);
                    break;
//                case R.id.bt_2:
//                    intent = intent = new Intent(LoginSActivity.this, DormitoryActivity.class);
//                    break;
            }
            startActivity(intent);
        }
    }
    private class NavigationItem implements NavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Intent intent = null;
            switch(item.getItemId()){
                case R.id.nav_call:
                    intent = new Intent(LoginSActivity.this, SelfInfo.class);
                    break;

            }
            startActivity(intent);
            return true;
        }
    }
}
