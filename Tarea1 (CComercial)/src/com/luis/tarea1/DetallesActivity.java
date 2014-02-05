package com.luis.tarea1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class DetallesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalles);
		Intent intent = getIntent();
		String tienda = intent.getStringExtra("nombre");
		if(tienda.equals("tienda de lego")){
			String direccion = "8av 3-44 zona 4";
			String telefono = "2222222";
			String Horario ="Lunes a viernes 8am- 5pm";
			String Website = "www.lego.com";
			String email = "lego@lego.com";
			TextView nombre = (TextView)findViewById(R.id.txt);
			nombre.setText(tienda);
			TextView direccion1 = (TextView)findViewById(R.id.txt2);
			direccion1.setText(direccion);
			TextView telefono1 = (TextView)findViewById(R.id.textView4);
			telefono1.setText(telefono);
			TextView horario1 = (TextView)findViewById(R.id.textView6);
			horario1.setText(Horario);
			TextView website1 = (TextView)findViewById(R.id.textView8);			
			website1.setText(Website);
			TextView email1 = (TextView)findViewById(R.id.textView10);
			email1.setText(email);
		}else{
			String direccion = "9 3-44 zona 41";
			String telefono = "33333333";
			String Horario ="Lunes a viernes 8am- 10pm";
			String Website = "www.zapatos.com";
			String email = "zapatos@zapatos.com";
			TextView nombre = (TextView)findViewById(R.id.txt);
			nombre.setText(tienda);
			TextView direccion1 = (TextView)findViewById(R.id.textView2);
			direccion1.setText(direccion);
			TextView telefono1 = (TextView)findViewById(R.id.textView4);
			telefono1.setText(telefono);
			TextView horario1 = (TextView)findViewById(R.id.textView6);
			horario1.setText(Horario);
			TextView website1 = (TextView)findViewById(R.id.textView8);			
			website1.setText(Website);
			TextView email1 = (TextView)findViewById(R.id.textView10);
			email1.setText(email);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalles, menu);
		return true;
	}

}
