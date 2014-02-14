package com.example.data;


import com.example.demo1semana2.R;
import com.example.fragments.flagfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

public class FlagPagerAdapter extends FragmentPagerAdapter {

	public FlagPagerAdapter(FragmentManager fm){
		super(fm);
	}
	
	@Override
	public Fragment getItem(int position) {
		int [] arraysFlags = new int[]{
				R.drawable.brasil,
				R.drawable.argentina,
				R.drawable.chile,
				R.drawable.colombia,
				R.drawable.ecuador,
				R.drawable.mexico,
				R.drawable.peru,
				R.drawable.venezuela
		};
		Fragment fragment = new flagfragment();
		Bundle args = new Bundle();
		args.putInt(flagfragment.RESOURCE, arraysFlags[position]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 8;
	}

}
