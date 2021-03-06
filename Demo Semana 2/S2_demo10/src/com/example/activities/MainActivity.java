package com.example.activities;

import com.example.demo1semana2.R;
import com.example.fragments.about_fragment;
import com.example.fragments.countries_content_fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private String [] drawerOptions;
	private ActionBarDrawerToggle drawerToggle;
	private Fragment[] fragments = new Fragment[]{
			new countries_content_fragment(), new about_fragment()};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerList = (ListView) findViewById(R.id.leftDrawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerOptions = getResources().getStringArray(R.array.drawer_options);
		drawerList.setAdapter(new ArrayAdapter<String> (this,R.layout.drawer_list_item,drawerOptions));
		
		drawerList.setItemChecked(0, true);
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, 
													R.string.drawer_open, R.string.drawer_close){
			public void onDrawerClosed(View view){
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
			
			public void onDrawerOpened(View view){
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
		};
		
		drawerLayout.setDrawerListener(drawerToggle);
		ActionBar actionBar= getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle(drawerOptions[0]);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.contentFrame, fragments[0])
								.add(R.id.contentFrame, fragments[1])
								.hide(fragments[1])
								.commit();
	}
	
	public void SetContent(int index){
		Fragment toHide = null;
		Fragment toShow = null;
		ActionBar actionBar = getSupportActionBar();
		if(index == 0){
			toHide = fragments[1];
			toShow = fragments[0];
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		}else{
			toHide = fragments[0];
			toShow = fragments[1];
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		}
		actionBar.setTitle(drawerOptions[index]);
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().hide(toHide).show(toShow).commit();
		drawerList.setItemChecked(index, true);
		drawerLayout.closeDrawer(drawerList);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == android.R.id.home){
			if(drawerLayout.isDrawerOpen(drawerList)){
				drawerLayout.closeDrawer(drawerList);
			}else{
				drawerLayout.openDrawer(drawerList);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			SetContent(position);
		}
		
	}
}
