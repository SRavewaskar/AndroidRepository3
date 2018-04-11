package com.example.calculatestorage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b = (Button) findViewById(R.id.btn);
		final TextView tv = (TextView) findViewById(R.id.tv);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String path  = Environment.
						getExternalStorageDirectory()
						.getAbsolutePath();
				
				StatFs s = new StatFs(path);
				long total = s.getTotalBytes()/(1024 * 1024);
				long free = s.getFreeBytes()/(1024 * 1024 );
				
				tv.setText("Total Space: " + String.valueOf(total)
						+ "MB" +  '\n' + "Free space: " +
						String.valueOf(free) + "MB");
				
			}
		});
		
	}
}
