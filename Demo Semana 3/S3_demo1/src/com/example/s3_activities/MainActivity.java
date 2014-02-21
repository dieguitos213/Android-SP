package com.example.s3_activities;

import com.example.s3_data.ImageAdapter;
import com.example.s3_demo1.R;
import android.os.Bundle;
import android.app.Activity;

import android.widget.GridView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView = (GridView)findViewById(R.id.grid);
		gridView.setAdapter(new ImageAdapter(this));
		
	}

}
