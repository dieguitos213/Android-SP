package com.luis.tarea1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends ActionBarActivity {
	
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
		
		String tienda1 = "tienda de lego";
		String date1 = "gh";
		String tienda2 = "tienda de zapatos";
		String date2 = "g";
		String date3 = "g";
		String tienda3 = "Ihop";
		
		HashMap<String,String> element = new HashMap<String,String>();
		element.put(nombre_tiendas, tienda1);
		element.put(Date_added,date1);
		tiendas.add(element);
		
		HashMap<String,String> element1 = new HashMap<String,String>();
		element1.put(nombre_tiendas, tienda2);
		element1.put(Date_added,date2);
		tiendas.add(element1);
		
		HashMap<String,String> element2 = new HashMap<String,String>();
		element2.put(nombre_tiendas, tienda3);
		date3 = "g";
		element2.put(Date_added,date3 );
		tiendas.add(element2);
		
		ActionBar actionbar = getSupportActionBar();
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		

		
		ActionBar.TabListener tablistener = new TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
				Toast.makeText(getApplicationContext(), arg0.getText(), Toast.LENGTH_SHORT).show();
				
				
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
		};
		
		for(int i = 0; i < 2; i++){
			actionbar.addTab(
					actionbar.newTab().setText("Listado").setTabListener(tablistener));
		}
		
		ListView list = (ListView)findViewById(android.R.id.list);
		list.setAdapter(adapter);
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
						  }else
							  if(position==2){
								  intent = new Intent(MainActivity.this,
										  Image.class);
								  String tienda1 = "Ihop";
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int item_id = item.getItemId();
		Intent intent;
		if(item_id == R.id.imagen){
			intent = new Intent(this,
					Image.class);
			 startActivity(intent);
		}
		
		if(item_id == R.id.share){
			
		}
		
		if(item_id ==  R.id.important){
			
		}
		return true;
	}
	
	

}
