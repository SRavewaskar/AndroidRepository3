package com.monster.ContextMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class ContextMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnCreateContextMenuListener(this); 
        }

//For context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
    ContextMenuInfo menuInfo)
    {
	    // ContextMenuInfo holds more info about the view 
    	// E.g: If we have registered Context menu Listn to many views then 
    	// to know addn info about the View we need menuInfo object. 
    	// Used only if we want to show different Context Menu for different views.  
    	
    	//super.onCreateContextMenu(menu, view, menuInfo);
    	
	    CreateMenu(menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
		return MenuChoice(item);
    }
    
    
    
    
    
    
    
    
    private void CreateMenu(Menu menu)
    {
    	//To enable shortcut keys, need to call setQwertyMode() method  
    	//menu.setQwertyMode(true);
    	
	    MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
	    
	    //mnu1.setAlphabeticShortcut('a');
		mnu1.setIcon(R.drawable.icon);
	    
	    MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
	    
	    MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
	    
		MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
	    
		menu.add(0, 4, 4, "Item 5");
	    menu.add(0, 5, 5, "Item 6");
	    menu.add(0, 6, 6, "Item 7");
    }

    
    private boolean MenuChoice(MenuItem item)
    {
	    switch (item.getItemId()) {
	    case 0:
		    Toast.makeText(this, "You clicked on Item 1",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 1:
		    Toast.makeText(this, "You clicked on Item 2",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 2:
		    Toast.makeText(this, "You clicked on Item 3",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 3:
		    Toast.makeText(this, "You clicked on Item 4",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 4:
		    Toast.makeText(this, "You clicked on Item 5",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 5:
		    Toast.makeText(this, "You clicked on Item 6",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 6:
			Toast.makeText(this, "You clicked on Item 7",
			Toast.LENGTH_LONG).show();
		return true;
		}
	return false;
	}
}