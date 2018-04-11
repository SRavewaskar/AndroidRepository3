package com.example.writefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String file = "mydata";
	EditText ed1;
	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		ed1=(EditText)findViewById(R.id.editText1);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String data=ed1.getText().toString();
				try{
					//type 1

					 FileOutputStream fOut=openFileOutput(file,
							 MODE_PRIVATE);
					 fOut.write(data.getBytes());
			         fOut.close();
			         Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
			         ed1.setText("");
			        
					 
			       //type2
					/*
			         FileOutputStream out=openFileOutput(file,MODE_PRIVATE);
			         OutputStreamWriter fout=new OutputStreamWriter(out);
			         fout.append(data);
			         fout.close();
			         Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
			         ed1.setText("");
					*/
					
			       //type 3
				  /*
					BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput(file,MODE_PRIVATE))); 
				    //bufferedWriter.write(data);
					bufferedWriter.append(data);
				    bufferedWriter.close();
				    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
				    ed1.setText("");
				    
				   */     
			         
				}catch(Exception e){}
				
				b2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						try{
							String temp="";
							
							
							//Type 1:
						FileInputStream fin = openFileInput(file);
				         int c;
				         
				         while( (c = fin.read()) != -1){
				            temp = temp + Character.toString((char)c);
				         }
				         ed1.setText(temp);
			         Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
					}catch(Exception w){}
						}
				});
				
			}
		});
	}

	

}

