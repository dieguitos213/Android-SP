package com.example.s3_data;


import com.example.s3_demo1.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	
	int[] arrayFlags = new int[] {R.drawable.brasil,
			R.drawable.mexico,
			R.drawable.colombia,
			R.drawable.argentina,
			R.drawable.peru,
			R.drawable.venezuela,
			R.drawable.chile,
			R.drawable.ecuador};
	
	String [] arrayCountries = new String [] {
			"Brasil","México","Colombia",
			"Argentina","Perú","Venezuela","Chile",
			"Ecuador"};
	
	private Resources resources;
	private LayoutInflater inflater;
	
	public ImageAdapter(Context context){
		this.resources = context.getResources();
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return arrayFlags.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.grid_image,null);
			
			holder = new ViewHolder();
			holder.txtName = (TextView)convertView.findViewById(R.id.textName);
			holder.imgFlag = (ImageView)convertView.findViewById(R.id.imageFlag);
			convertView.setTag(holder);
			
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txtName.setText(arrayCountries[position]);
		holder.imgFlag.setImageBitmap(
				decodeSampleBitmapFromResource(resources, arrayFlags[position], 400, 200));
		return convertView;
	}
	
	static class ViewHolder{
		public ImageView imgFlag;
		public TextView txtName;
	}
	
	public static Bitmap decodeSampleBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
	
		if (height > reqHeight || width > reqWidth) {
			if (width > height) {
				inSampleSize = Math.round((float)height / (float)reqHeight);
			} else {
				inSampleSize = Math.round((float)width / (float)reqWidth);
			}
		}
		return inSampleSize;
	}
}