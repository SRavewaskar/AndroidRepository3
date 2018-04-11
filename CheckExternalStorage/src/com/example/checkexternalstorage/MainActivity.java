package com.example.checkexternalstorage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		Button check = (Button) findViewById(R.id.check);
		
		check.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String state = Environment.getExternalStorageState();
				
				if(Environment.MEDIA_MOUNTED.equals(state))
					Toast.makeText(getBaseContext(), "External storage present", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getBaseContext(), "External storage not found", Toast.LENGTH_SHORT).show();	
			}
		});
	
	}

}
