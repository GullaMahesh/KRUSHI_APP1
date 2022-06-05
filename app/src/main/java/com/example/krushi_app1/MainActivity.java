package com.example.krushi_app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView s= (ImageView) findViewById(R.id.image_view);
       // s.setY(0);
      //  s.setX(-100);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mAuth = FirebaseAuth.getInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new home_fragment()).commit();
        nav.setCheckedItem(R.id.nav_Home);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_Home:
                        temp=new home_fragment();
                        break;

                    case R.id.nav_addequipment:
                        temp=new Addequip_Fragment();
                        break;

                    case R.id.nav_myequipment:
                        temp=new myequip_Fragment();
                        break;
                    case R.id.nav_categories:
                        temp=new catogories_Fragment();
                        break;
                    case R.id.nav_callcentersupport:
                        temp=new callcenter_Fragment();
                        break;
                    case R.id.nav_faq:
                        temp=new faq_Fragment();
                        break;
                    case R.id.nav_settings:
                       temp=new settings_Fragment();
                        break;
                    case R.id.nav_logout:
                        temp=new logout_Fragment();

                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).addToBackStack("home_fragment").commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }
}
