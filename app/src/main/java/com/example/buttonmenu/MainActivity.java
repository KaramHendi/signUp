package com.example.buttonmenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFrag;
    private DashboardFragment dashFrag;
    private LoginFragment loginFrag;
    private signUpFragment signUpFrag;
    private FrameLayout homeFrame,dashboardFrame,loginFrame,signUpFrame;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        homeFrame=findViewById(R.id.home_frame);
        dashboardFrame=findViewById(R.id.dashboard_frame);
        loginFrame=findViewById(R.id.login_frame);
        signUpFrame=findViewById(R.id.signUp_frame);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        begain();
    }

    private void begain(){
        homeFrag=new HomeFragment();
        dashFrag=new DashboardFragment();
        loginFrag=new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame,homeFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_frame,dashFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.login_frame,loginFrag).commit();
        homeFrame.setVisibility(View.INVISIBLE);
        dashboardFrame.setVisibility(View.INVISIBLE);
        loginFrame.setVisibility(View.INVISIBLE);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.menu_home){
                    homeFrame.setVisibility(View.VISIBLE);
                    dashboardFrame.setVisibility(View.INVISIBLE);
                    loginFrame.setVisibility(View.INVISIBLE);
                }
                if(item.getItemId()==R.id.menu_dashboard){
                    homeFrame.setVisibility(View.INVISIBLE);
                    dashboardFrame.setVisibility(View.VISIBLE);
                    loginFrame.setVisibility(View.INVISIBLE);
                }
                if(item.getItemId()==R.id.menu_login){
                    homeFrame.setVisibility(View.INVISIBLE);
                    dashboardFrame.setVisibility(View.INVISIBLE);
                    loginFrame.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });



    }
}