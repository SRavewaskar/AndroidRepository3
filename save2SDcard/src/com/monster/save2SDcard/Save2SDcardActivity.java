package com.monster.save2SDcard;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Save2SDcardActivity extends Activity {
	private EditText textBox;
	private static final int READ_BLOCK_SIZE = 100;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textBox = (EditText) findViewById(R.id.txtText1);
        Button saveBtn = (Button) findViewById(R.id.btnSave);
        Button loadBtn = (Button) findViewById(R.id.btnLoad);
        
        saveBtn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
    	String str = textBox.getText().toString();

	    	try
	        {
	    		//---SD Card Storage---
	    		File sdCard = Environment.getExternalStorageDirectory(); 
	    		// /mnt/media-rw/sdcard/
	    		
	    		File directory = new File (sdCard.getAbsolutePath() +
	    		"/MyFiles");
	    		directory.mkdirs();
	    		
	    		File file = new File(directory, "textfile.txt");

	    		FileOutputStream fOut = new FileOutputStream(file);
	    		OutputStreamWriter osw = new OutputStreamWriter(fOut);
	        
		        //---write the string to the file---
		        osw.write(str);
		        osw.flush();
		        osw.close();
	        
		        //---display file saved message---
		        Toast.makeText(getBaseContext(), 
		        		"File saved successfully!", Toast.LENGTH_SHORT).show();
	        
		        //---clears the EditText---
		        textBox.setText("");
	        }
	
	        catch (IOException ioe) 
	        {
	        	ioe.printStackTrace();
	        }
        }
    });

        loadBtn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        try
        {
        	//---SD Storage---
        	File sdCard = Environment.getExternalStorageDirectory();
        	File directory = new File (sdCard.getAbsolutePath() +
        	"/MyFiles");
        	File file = new File(directory, "textfile.txt");

        	FileInputStream fIn = new FileInputStream(file);
        	InputStreamReader isr = new InputStreamReader(fIn);

        	//
        	//

        	char[] inputBuffer = new char[READ_BLOCK_SIZE];
	        String s = "";
	        int charRead;

        while ((charRead = isr.read(inputBuffer))>0)
        {
	        //---convert the chars to a String---
	        String readString =
	        String.copyValueOf(inputBuffer, 0,
	        charRead);
	        s += readString;
	        inputBuffer = new char[READ_BLOCK_SIZE];
        }
      //---set the EditText to the text that has been
      // read---
      textBox.setText(s);
      Toast.makeText(getBaseContext(),
      "File loaded successfully!",
      Toast.LENGTH_SHORT).show();
      }
      catch (IOException ioe) {
      ioe.printStackTrace();
      }
      }
      });
    }
}