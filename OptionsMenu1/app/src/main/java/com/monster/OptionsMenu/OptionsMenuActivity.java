package com.monster.OptionsMenu;

import android.app.Activity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class OptionsMenuActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    //For Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	    //super.onCreateOptionsMenu(menu);
	    CreateMenu(menu);
	    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	return MenuChoice(item);
    }

    private void CreateMenu(Menu menu)
    {
	    MenuItem mnu1 = menu.add(0, 0, 0, "Menu 1");
	    // parameters : int groupId, int itemId, int order, 
	    //CharSequence title
	     
	    //  mnu1.setAlphabeticShortcut('a');
		    mnu1.setIcon(R.drawable.icon);
	    
	    MenuItem mnu2 = menu.add(0, 1, 1, "Menu 2");
	    mnu2.setIcon(R.drawable.icon);
	    
	    MenuItem mnu3 = menu.add(0, 2, 2, "Menu 3");
	    mnu3.setIcon(R.drawable.icon);
	    
	    menu.add(0, 3, 3, "Menu 4");
	    menu.add(0, 4, 4, "Menu 5");
	    menu.add(0, 5, 5, "Menu 6");
	    menu.add(0, 6, 6, "Menu 7");
    }

    private boolean MenuChoice(MenuItem item)
    {
	    switch (item.getItemId()) {
	    case 0:
		    Toast.makeText(this, "You clicked on Menu 1",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 1:
		    Toast.makeText(this, "You clicked on Menu 2",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 2:
		    Toast.makeText(this, "You clicked on Menu 3",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 3:
		    Toast.makeText(this, "You clicked on Menu 4",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 4:
		    Toast.makeText(this, "You clicked on Menu 5",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 5:
		    Toast.makeText(this, "You clicked on Menu 6",
		    Toast.LENGTH_LONG).show();
	    return true;
	    case 6:
			Toast.makeText(this, "You clicked on Menu 7",
			Toast.LENGTH_LONG).show();
		return true;
		}
	return false;
	}
}