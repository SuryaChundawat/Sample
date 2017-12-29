package com.example.suryanarayan.sample.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.ExpandDrawer.data.BaseItem;
import com.example.suryanarayan.sample.ExpandDrawer.data.CustomDataProvider;
import com.example.suryanarayan.sample.ExpandDrawer.views.LevelBeamView;
import com.example.suryanarayan.sample.Fragment.DashBoard;
import com.example.suryanarayan.sample.Fragment.Feedback;
import com.example.suryanarayan.sample.Fragment.FragmentSetting;
import com.example.suryanarayan.sample.Fragment.LiveSiteReview;
import com.example.suryanarayan.sample.Fragment.OnFragmentInteractionListener;
import com.example.suryanarayan.sample.Fragment.SelectRegion;
import com.example.suryanarayan.sample.Fragment.ServiceRequest;
import com.example.suryanarayan.sample.Fragment.SystemHeath;
import com.example.suryanarayan.sample.R;

import java.util.List;

import pl.openrnd.multilevellistview.ItemInfo;
import pl.openrnd.multilevellistview.MultiLevelListAdapter;
import pl.openrnd.multilevellistview.MultiLevelListView;
import pl.openrnd.multilevellistview.OnItemClickListener;

public class MainActivity extends BaseActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener,OnFragmentInteractionListener
{

    private Toolbar toolbar;
    private Context context;
    public static int navItemIndex = 0;
    private static final String TAG = "DashboardActivity";
    private static final String TAG_HOME = "DashBoard";
    private static final String TAG_LISTSITEREVIEW = "Live Site Review";
    private static final String TAG_SERIVCEREVIEW = "Service Request";
    private static final String TAG_SYSTEMHEALTH = "System Health";
    private static final String TAG_SELECTREGION = "Select Region";
    private static final String TAG_FEEDBACK = "Feedback";
    private static final String TAG_SETTINGS = "Setting";
    public static String CURRENT_TAG = TAG_HOME;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Handler mHandler;
    private TextView txtfeedback,txtsettings;
    private int mSelectedItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getView();
            InitiStatus();
            Log.e(TAG, "savedInstanceState:==null " );
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment(getString(R.string.app_name));
        }
    }

    //load the defaul fragment
    private void loadHomeFragment(String string) {
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            return;
        }
        Log.e(TAG,"Current tag for loading the fragment"+CURRENT_TAG);

        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.container, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        //drawer.closeDrawers();
        invalidateOptionsMenu();

    }


    //Declering all the fragment
    private Fragment getHomeFragment() {
        Log.e(TAG, "getHomeFragment: " );
        switch (navItemIndex) {
            case 0:
                //home
                DashBoard dashBoard = new DashBoard();
                return dashBoard;

            case 1:
                SelectRegion selectRegion = new SelectRegion();
                return selectRegion;

            case 2:
                LiveSiteReview liveSiteReview = new LiveSiteReview();
                return liveSiteReview;

            case 3:
                ServiceRequest serviceRequest= new ServiceRequest();
                return serviceRequest;

            case 4:
                SystemHeath systemHeath = new SystemHeath();
                return systemHeath;

            case 5:
                FragmentSetting fragmentSetting = new FragmentSetting();
                return fragmentSetting;
            case 6:
                Feedback feedback = new Feedback();
                return feedback;

            default:
                return new DashBoard();
        }
    }

    private void  getView() {
        context=MainActivity.this;
        mHandler = new Handler();
        navigationView();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setLogo(getResources().getDrawable(R.drawable.dashboardlogo));
        //OnNavigationItemSelectedListener
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        confMenu();

    }

    private void navigationView() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        navigationView.setItemIconTintList(null);
        TextView user_name = (TextView)header.findViewById(R.id.username);
        txtfeedback = (TextView)findViewById(R.id.fragmentFeedback);
        txtsettings = (TextView)findViewById(R.id.fragmentsettings);
        txtsettings.setOnClickListener(this);
        txtfeedback.setOnClickListener(this);
        //Spinner useremail = (Spinner) header.findViewById(R.id.useremail);
        user_name.setText("John Doe");
        //firstName.setText(stririd);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_mainmenu, menu);
        return true;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.e(TAG, "onNavigationItemSelected: "+id );

        if (id == R.id.Dashboard) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment(getString(R.string.app_name));

        } else if (id == R.id.SelectRegion) {
            navItemIndex = 1;
            CURRENT_TAG = TAG_SELECTREGION;
            loadHomeFragment(getString(R.string.app_name));

        } else if (id == R.id.LiveSiteReview) {
            navItemIndex = 2;
            CURRENT_TAG = TAG_LISTSITEREVIEW;
            loadHomeFragment(getString(R.string.app_name));

        } else if (id == R.id.ServiceRequest) {
            navItemIndex = 3;
            CURRENT_TAG = TAG_SERIVCEREVIEW;
            loadHomeFragment(getString(R.string.app_name));


        } else if (id == R.id.SystemHealth) {
            navItemIndex = 4;
            CURRENT_TAG = TAG_SYSTEMHEALTH;
            loadHomeFragment(getString(R.string.app_name));
        }
        else{
            loadHomeFragment(getString(R.string.app_name));
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int getId =  item.getItemId();
        switch (getId) {
            case R.id.action_alert:
                showSnackbar(drawer,"Alert is Clicked");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == txtfeedback)
        {
            navItemIndex = 6;
            loadFragmentStep("Feedback");
            /*CURRENT_TAG = TAG_SYSTEMHEALTH;
            loadHomeFragment(getString(R.string.app_name));
            drawer.closeDrawer(GravityCompat.START);
            fab.setVisibility(View.INVISIBLE);*/
        }

        if (v == txtsettings)
        {
            navItemIndex = 5;
            loadFragmentStep("Setting");
            /*CURRENT_TAG = TAG_SETTINGS;
            loadHomeFragment(getString(R.string.app_name));
            drawer.closeDrawer(GravityCompat.START);
            fab.setVisibility(View.INVISIBLE);*/

        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static void StartActivity(Context context) {
        context.startActivity(new Intent(context,MainActivity.class));
    }

    //This is the part for the multilevel listview
    private void confMenu() {
        MultiLevelListView multiLevelListView = (MultiLevelListView) findViewById(R.id.multiLevelMenu);

        // custom ListAdapter
        ListAdapter listAdapter = new ListAdapter();

        multiLevelListView.setAdapter(listAdapter);


       // multiLevelListView.setOnItemClickListener(mOnItemClickListener);
        multiLevelListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(MultiLevelListView parent, View view, Object object, ItemInfo itemInfo)
            {
                //int position = (int) view.getX();
                //view.setBackgroundColor(getResources().getColor(R.color.transparent_orange));
                StringBuilder builder = new StringBuilder("\"");
                builder.append(((BaseItem) object).getName());
                builder.append("\" clicked!\n");
                builder.append(getItemInfoDsc(itemInfo));
                String name = ((BaseItem) object).getName();
                loadFragmentStep(name);
                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGroupItemClicked(MultiLevelListView parent, View view, Object item, ItemInfo itemInfo) {

            }
        });


        listAdapter.setDataItems(CustomDataProvider.getInitialItems());
    }


    private void loadFragmentStep(String name) {
        switch (name) {
            case TAG_HOME:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);

                break;
            case TAG_SELECTREGION:
                navItemIndex = 1;
                CURRENT_TAG = TAG_SELECTREGION;
                //loadHomeFragment(getString(R.string.app_name));

                break;
            case TAG_LISTSITEREVIEW:
                navItemIndex = 2;
                CURRENT_TAG = TAG_LISTSITEREVIEW;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);

                break;
            case TAG_SERIVCEREVIEW:
                navItemIndex = 3;
                CURRENT_TAG = TAG_SERIVCEREVIEW;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);

                break;
            case TAG_SYSTEMHEALTH:
                navItemIndex = 4;
                CURRENT_TAG = TAG_SYSTEMHEALTH;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);
                break;
            case TAG_SETTINGS:
                navItemIndex = 5;
                CURRENT_TAG = TAG_SETTINGS;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);
                break;
            case TAG_FEEDBACK:
                navItemIndex = 6;
                CURRENT_TAG = TAG_FEEDBACK;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);
                break;

            default:
                /*loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);*/
                break;
        }







    }



   /* private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {

        private void showItemDescription(Object object, ItemInfo itemInfo) {
            StringBuilder builder = new StringBuilder("\"");
            builder.append(((BaseItem) object).getName());
            builder.append("\" clicked!\n");
            builder.append(getItemInfoDsc(itemInfo));



            String name = ((BaseItem) object).getName();
            if (name.equals(TAG_HOME)) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);

            } else if (name.equals(TAG_SELECTREGION)) {
                navItemIndex = 1;
                CURRENT_TAG = TAG_SELECTREGION;
                //loadHomeFragment(getString(R.string.app_name));

            } else if (name.equals(TAG_LISTSITEREVIEW)) {
                navItemIndex = 2;
                CURRENT_TAG = TAG_LISTSITEREVIEW;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);

            } else if (name.equals(TAG_SERIVCEREVIEW)) {
                navItemIndex = 3;
                CURRENT_TAG = TAG_SERIVCEREVIEW;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);

            } else if (name.equals(TAG_SYSTEMHEALTH)) {
                navItemIndex = 4;
                CURRENT_TAG = TAG_SYSTEMHEALTH;
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);
            }
            else{
                loadHomeFragment(getString(R.string.app_name));
                drawer.closeDrawer(GravityCompat.START);
            }

            Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onItemClicked(MultiLevelListView parent, View view, Object item, ItemInfo itemInfo) {
            showItemDescription(item, itemInfo);
        }

        @Override
        public void onGroupItemClicked(MultiLevelListView parent, View view, Object item, ItemInfo itemInfo) {
            showItemDescription(item, itemInfo);
        }
    };*/

    private class ListAdapter extends MultiLevelListAdapter {

        private class ViewHolder {
            TextView nameView;
            TextView infoView;
            ImageView arrowView,iconimage;
            LevelBeamView levelBeamView;
        }


        @Override
        public List<?> getSubObjects(Object object) {
            // DIEKSEKUSI SAAT KLIK PADA GROUP-ITEM
            return CustomDataProvider.getSubItems((BaseItem) object);
        }

        @Override
        public boolean isExpandable(Object object) {
            return CustomDataProvider.isExpandable((BaseItem) object);
        }

        @SuppressLint("CutPasteId")
        @Override
        public View getViewForObject(Object object, View convertView, ItemInfo itemInfo) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.data_item, null);
                //viewHolder.infoView = (TextView) convertView.findViewById(R.id.dataItemInfo);
                viewHolder.nameView = (TextView) convertView.findViewById(R.id.dataItemName);
                viewHolder.arrowView = (ImageView) convertView.findViewById(R.id.dataItemArrow);
                viewHolder.iconimage = (ImageView) convertView.findViewById(R.id.imageicon);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.nameView.setText(((BaseItem) object).getName());
            String imagename = ((BaseItem) object).getName();

            int servicerequest = R.mipmap.service_request;
            int dashboard = R.mipmap.dashboard;
            int livesitereview = R.mipmap.live_site_review;
            int systemhealth = R.mipmap.system_health;
            int selectregion = R.mipmap.select_region;
            if (imagename.equals("Select Region"))
            {
                viewHolder.iconimage.setVisibility(View.VISIBLE);
                viewHolder.iconimage.setImageResource(R.mipmap.select_region);
            }
            if (imagename.equals("DashBoard"))
            {
                viewHolder.iconimage.setVisibility(View.VISIBLE);
                viewHolder.iconimage.setImageResource(R.mipmap.dashboard);
            }
            if (imagename.equals("Live Site Review"))
            {
                viewHolder.iconimage.setVisibility(View.VISIBLE);
                viewHolder.iconimage.setImageResource(R.mipmap.live_site_review);
            }
            if (imagename.equals("Service Request"))
            {
                viewHolder.iconimage.setVisibility(View.VISIBLE);
                viewHolder.iconimage.setImageResource(R.mipmap.service_request);
            }
            if (imagename.equals("System Health"))
            {
                viewHolder.iconimage.setVisibility(View.VISIBLE);
                viewHolder.iconimage.setImageResource(R.mipmap.system_health);
            }

            if (imagename.equals("All"))
            {
                viewHolder.iconimage.setVisibility(View.INVISIBLE);
            }

            if (imagename.equals("North"))
            {
                viewHolder.iconimage.setVisibility(View.INVISIBLE);
            }

            if (imagename.equals("South"))
            {
                viewHolder.iconimage.setVisibility(View.INVISIBLE);
            }

            if (imagename.equals("East"))
            {
                viewHolder.iconimage.setVisibility(View.INVISIBLE);
            }

            if (imagename.equals("West"))
            {
                viewHolder.iconimage.setVisibility(View.INVISIBLE);
            }






            if (itemInfo.isExpandable()) {
                viewHolder.arrowView.setVisibility(View.VISIBLE);
                viewHolder.arrowView.setImageResource(itemInfo.isExpanded() ?
                        R.mipmap.minus : R.mipmap.add);
            } else {
                viewHolder.arrowView.setVisibility(View.GONE);
                //viewHolder.iconimage.setVisibility(View.GONE);
            }
            //viewHolder.levelBeamView.setLevel(itemInfo.getLevel());
            return convertView;
        }
    }


    @SuppressLint("DefaultLocale")
    private String getItemInfoDsc(ItemInfo itemInfo) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("level[%d], idx in level[%d/%d]",
                itemInfo.getLevel() + 1, /*Indexing starts from 0*/
                itemInfo.getIdxInLevel() + 1 /*Indexing starts from 0*/,
                itemInfo.getLevelSize()));

        if (itemInfo.isExpandable()) {
            builder.append(String.format(", expanded[%b]", itemInfo.isExpanded()));
        }
        return builder.toString();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
