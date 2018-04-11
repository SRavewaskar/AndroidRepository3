package com.suven.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class ActionBarDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        
        // In Api 15 and lower we have to ask to show an Action Bar 
        // else it only creates Options Menu
        
        setContentView(R.layout.main);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.actionbar, menu);
    	return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.cut:
    		return showToast("Cut");
    	case R.id.copy:
    		return showToast("Copy");
    	case R.id.paste:
    		return showToast("Paste");
    	default:
    		return false; 
    	}
    }
    
    private boolean showToast(String message){
    	Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    	return true;
    }
}