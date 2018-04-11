package com.example.readfile;

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
					
			         FileOutputStream out=openFileOutput(file,MODE_PRIVATE);
			         OutputStreamWriter fout=new OutputStreamWriter(out);
			         fout.append(data);
			         fout.flush();
			         fout.close();
			         Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
			         ed1.setText("");
					
				}catch(Exception e){}
				
				b2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						try{
							String temp="";
							StringBuffer stringBuffer = 
									new StringBuffer();
							
							//Type 1:
						/*
						 FileInputStream fin = openFileInput(file);
				         int c;
				         
				         while( (c = fin.read()) != -1){
				            temp = temp + Character.toString((char)c);
				         }
				         ed1.setText(temp);
				     */
							
							//Type 2
						/*
							 FileInputStream in = openFileInput(file);
							 InputStreamReader isr=new InputStreamReader(in);
							 char[] inputBuffer=new char[10];
							 int charRead;
							 while ((charRead = isr.read(inputBuffer))>0) {  
		                        String readString=String.copyValueOf(inputBuffer,0,charRead);
		                        temp+= readString;
		                        inputBuffer=new char[10];  
		                    }
		                     ed1.setText(temp);
		                		
						*/
							
							
							//Type 3
					
							BufferedReader inputReader = new BufferedReader(
							new InputStreamReader(openFileInput(file)));
							
							while ((temp = inputReader.readLine()) != null) {  
		                        stringBuffer.append(temp + "\n");  
		                       
		                    }  
							 ed1.setText(stringBuffer.toString());
							
					
							
							
				         Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
					}catch(Exception w){}
						}
				});
				
			}
		});
	}

	

}
