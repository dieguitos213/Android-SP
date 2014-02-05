package com.luis.tarea1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity {
	
	private final static String nombre_tiendas = "nombres de tiendas";
	private final static String Date_added = "date";
	private List<HashMap<String,String>> tiendas = new ArrayList<HashMap<String,String>>();
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SimpleAdapter adapter = new SimpleAdapter(this,tiendas,android.R.layout.simple_list_item_1,new String[]{
				nombre_tiendas,Date_added
		},new int[]{android.R.id.text1,android.R.id.text2});
		setListAdapter(adapter);
		String tienda1 = "tienda de lego";
		String date1 = "gh";
		String tienda2 = "tienda de zapatos";
		String date2 = "g";
		HashMap<String,String> element = new HashMap<String,String>();
		element.put(nombre_tiendas, tienda1);
		element.put(Date_added,date1);
		tiendas.add(element);
		HashMap<String,String> element1 = new HashMap<String,String>();
		element1.put(nombre_tiendas, tienda2);
		element1.put(Date_added,date2);
		tiendas.add(element1);
		ListView list = (ListView) findViewById(android.R.id.list);
		list.setOnItemClickListener(new OnItemClickListener() {
				  @Override
				  public void onItemClick(AdapterView<?> parent, View view,
				    int position, long id) {
					  if(position==0){
						  intent = new Intent(MainActivity.this,
									DetallesActivity.class);
						  String tienda1 = "tienda de lego";
						  
						  intent.putExtra("nombre", tienda1);
						  startActivity(intent); 
					  }else
						  if(position==1){
							  intent = new Intent(MainActivity.this,
										DetallesActivity.class);
							  String tienda1 = "tienda de zapatos";
							  
							  intent.putExtra("nombre", tienda1);
							  startActivity(intent); 
						  }
				  }
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
