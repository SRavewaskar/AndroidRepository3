package com.example.filestorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String file = "MyFiles";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText name = (EditText) findViewById(R.id.name);
		final EditText pass = (EditText) findViewById(R.id.pass);
		final TextView tv1 = (TextView) findViewById(R.id.tv1);
		final TextView tv2 = (TextView) findViewById(R.id.tv2);
		Button b1 = (Button) findViewById(R.id.b1);
		Button b2 = (Button) findViewById(R.id.b2);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
			if(name.getText().toString().equals("")==false && pass.getText().toString().equals("")==false)
			{
				File Sdcard = Environment.getExternalStorageDirectory();
				File directory = new File(Sdcard.getAbsolutePath() ,  file);
				directory.mkdir();
				File f = new File(directory, "data.txt");
				
				try {
					f.createNewFile(); // optional step
					FileOutputStream fos = new FileOutputStream(f);
					OutputStreamWriter osw = new OutputStreamWriter(fos);
					osw.write(name.getText().toString() + '\n' + pass.getText().toString());
					osw.flush();
					osw.close();
					Toast.makeText(getBaseContext(), "File saved", Toast.LENGTH_SHORT).show();
					tv1.setText("File Path: "+ f.getAbsolutePath());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}else
				Toast.makeText(getBaseContext(), "Enter all the fields", Toast.LENGTH_SHORT).show();
			
			}
		});
		
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				if(name.getText().toString().equals("")==false && pass.getText().toString().equals("")==false)
				{
					File f = new File(getExternalFilesDir(null), "myfiles.txt");
					
					try {
						f.createNewFile();
						FileOutputStream fos = new FileOutputStream(f);
						OutputStreamWriter osw = new OutputStreamWriter(fos);
						osw.write(name.getText().toString() + '\n' + pass.getText().toString());
						osw.flush();
						osw.close();
						Toast.makeText(getBaseContext(), "File saved", Toast.LENGTH_SHORT).show();
						tv2.setText("File Path: "+ f.getAbsolutePath());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}else
					Toast.makeText(getBaseContext(), "Enter all the fields", Toast.LENGTH_SHORT).show();
			
				
				
			}
		});
		
		}
}
