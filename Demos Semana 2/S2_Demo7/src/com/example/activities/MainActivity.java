package com.example.activities;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.demo1semana2.R;
import com.example.fragments.Country_info_fragment;
import com.example.fragments.countries_flag_fragment;
import com.example.fragments.countries_list_fragment;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements TabListener{
	
	//son los fagmentos que se van a ocultar y se van a mostrar
	Fragment[] fragments = new Fragment[] {new countries_list_fragment(), new countries_flag_fragment()};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionbar = getSupportActionBar();
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionbar.addTab(actionbar.newTab().setText(getString(R.string.title_fragment_list)).setTabListener(this));
		actionbar.addTab(actionbar.newTab().setText(getString(R.string.title_fragment_flags)).setTabListener(this));
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction()
		.add(R.id.mainContent, fragments[0])
		.add(R.id.mainContent, fragments[1])
		.commit();
		
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment toHide = null;
		Fragment toShow = null;
		if(tab.getPosition() == 0){
			toHide = fragments[1];
			toShow = fragments[0];
		}else{
			toHide = fragments[0];
			toShow = fragments[1];
		}
		ft.hide(toHide).show(toShow);
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}	
}
