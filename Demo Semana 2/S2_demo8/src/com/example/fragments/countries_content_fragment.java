package com.example.fragments;

import com.example.demo1semana2.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.activities.MainActivity;;

public class countries_content_fragment extends Fragment implements TabListener{
		
		//son los fagmentos que se van a ocultar y se van a mostrar
		Fragment[] fragments = new Fragment[] {new countries_list_fragment(), new countries_flag_fragment()};
		
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			ActionBar actionbar = ((MainActivity) getActivity()).getSupportActionBar();
			actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			actionbar.addTab(actionbar.newTab().setText(getString(R.string.title_fragment_list)).setTabListener(this));
			actionbar.addTab(actionbar.newTab().setText(getString(R.string.title_fragment_flags)).setTabListener(this));
			FragmentManager manager = getActivity().getSupportFragmentManager();
			manager.beginTransaction()
			.add(R.id.mainContent, fragments[0])
			.add(R.id.mainContent, fragments[1])
			.commit();
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_countries_content, container, false);
		}


		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
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
		}	
	}
