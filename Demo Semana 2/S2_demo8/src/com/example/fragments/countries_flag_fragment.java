package com.example.fragments;

import com.example.data.FlagPagerAdapter;
import com.example.demo1semana2.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class countries_flag_fragment extends Fragment {

	ViewPager viewpager;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		FlagPagerAdapter adapter =  new FlagPagerAdapter(getChildFragmentManager());
		viewpager.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_countries_flags, container,false);
		viewpager = (ViewPager)view.findViewById(R.id.pager);
		return view;
	}

	
}
