package com.luis.tarea1;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetallesActivity extends Activity {

	Intent call;
	Button call_btn;
	String telefono;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalles);
		Intent intent = getIntent();
		String tienda = intent.getStringExtra("nombre");
		if(tienda.equals("tienda de lego")){
			String direccion = "8av 3-44 zona 4";
			telefono = "2222222";
			String Horario ="Lunes a viernes 8am- 5pm";
			String Website = "www.lego.com";
			String email = "lego@lego.com";
			TextView nombre = (TextView)findViewById(R.id.nombre);
			nombre.setText(tienda);
			TextView direccion1 = (TextView)findViewById(R.id.direccion);
			direccion1.setText(direccion);
			TextView telefono1 = (TextView)findViewById(R.id.telefono);
			telefono1.setText(telefono);
			Linkify.addLinks(telefono1, Linkify.ALL);
			TextView horario1 = (TextView)findViewById(R.id.horarios);
			horario1.setText(Horario);
			TextView website1 = (TextView)findViewById(R.id.website);			
			website1.setText(Website);
			Linkify.addLinks(website1, Linkify.ALL);
			TextView email1 = (TextView)findViewById(R.id.email);
			email1.setText(email);
			Linkify.addLinks(email1, Linkify.ALL);
			call_btn = (Button)findViewById(R.id.call);
			ButtonListener listener = new ButtonListener();
			call_btn.setOnClickListener(listener);
		}else{
			String direccion = "9 3-44 zona 41";
			telefono = "33333333";
			String Horario ="Lunes a viernes 8am- 10pm";
			String Website = "www.zapatos.com";
			String email = "zapatos@zapatos.com";
			TextView nombre = (TextView)findViewById(R.id.nombre);
			nombre.setText(tienda);
			TextView direccion1 = (TextView)findViewById(R.id.direccion);
			direccion1.setText(direccion);
			TextView telefono1 = (TextView)findViewById(R.id.telefono);
			telefono1.setText(telefono);
			Linkify.addLinks(telefono1, Linkify.ALL);
			TextView horario1 = (TextView)findViewById(R.id.horarios);
			horario1.setText(Horario);
			TextView website1 = (TextView)findViewById(R.id.website);			
			website1.setText(Website);
			Linkify.addLinks(website1, Linkify.ALL);
			TextView email1 = (TextView)findViewById(R.id.email);
			email1.setText(email);
			Linkify.addLinks(email1, Linkify.ALL);
			call_btn = (Button)findViewById(R.id.call);
			ButtonListener listener = new ButtonListener();
			call_btn.setOnClickListener(listener);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalles, menu);
		return true;
	}
	
class ButtonListener implements OnClickListener{
		
		@Override
		public void onClick(View v) {
			if(v.getId() == call_btn.getId()){
				call = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: " + telefono));
				startActivity(call);
			}
		}
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
	return true;
}

}
