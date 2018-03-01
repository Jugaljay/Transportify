package taappscom.ta.bnb;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MenuActivity extends FragmentActivity implements View.OnClickListener
{
    private ResideMenu resideMenu;

    private MenuActivity mContext;

    private ResideMenuItem itemHome;

    private ResideMenuItem itemProfile;

    private ResideMenuItem itemCalendar;

    private ResideMenuItem itemSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attach to current activity;
        mContext = this;

        setUpMenu();

        //if( savedInstanceState == null )

           // changeFragment(new HomeFragment());

    }
    private void setUpMenu() {



        // attach to current activity;

        resideMenu = new ResideMenu(this);

//        resideMenu.setUse3D(true);

        resideMenu.setBackground(R.drawable.bachgrnd);

        resideMenu.attachToActivity(this);

        resideMenu.setMenuListener(menuListener);

        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.

        resideMenu.setScaleValue(0.6f);



        // create menu items;

        itemHome     = new ResideMenuItem(this, R.drawable.bwr,     "Home");

        itemProfile  = new ResideMenuItem(this, R.drawable.core8,  "Profile");

        itemCalendar = new ResideMenuItem(this, R.drawable.fs1, "Calendar");

        itemSettings = new ResideMenuItem(this, R.drawable.ft, "Settings");



        itemHome.setOnClickListener(this);

        itemProfile.setOnClickListener(this);

        itemCalendar.setOnClickListener(this);

        itemSettings.setOnClickListener(this);



        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);

        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);

        resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);

        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);



        // You can disable a direction by setting ->

        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);



        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);

            }

        });

        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);

            }

        });

    }
    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {

        @Override

        public void openMenu() {

            //Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();

        }



        @Override

        public void closeMenu() {

            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();

        }

    };
    private void changeFragment(android.support.v4.app.Fragment targetFragment){

        resideMenu.clearIgnoredViewList();

        getSupportFragmentManager()

                .beginTransaction()

                .replace(R.id.main_fragment, targetFragment, "fragment")

                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

                .commit();

    }


    @Override

    public void onClick(View view) {



        if (view == itemHome){

            changeFragment(new Fragment1());

        }else if (view == itemProfile){

            //changeFragment(new Fragment2());

        }else if (view == itemCalendar){

            //changeFragment(new Fragment3());

        }else if (view == itemSettings){

            //changeFragment(new Fragment4());

        }



        resideMenu.closeMenu();

    }



    public ResideMenu getResideMenu(){

        return resideMenu;

    }


}
