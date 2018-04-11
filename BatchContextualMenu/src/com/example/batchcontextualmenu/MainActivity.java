package com.example.batchcontextualmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ActionMode.Callback mcml;
	ActionMode mymode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv = (ListView) findViewById(R.id.lv);
		
		String [] items = getResources().
				getStringArray(R.array.listitems);	
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
		(getBaseContext(), 
		android.R.layout.simple_list_item_multiple_choice, items);
		
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				mymode = startActionMode(mcml);
			}
		});
		
		
		mcml =  new MultiChoiceModeListener() {
			
			@Override
			public boolean onCreateActionMode(ActionMode mode, 
					Menu menu) {
				mode.setTitle("MyContextualTitle");
				getMenuInflater().inflate(R.menu.context_menu, 
						menu);
				return true;
			}
			
			@Override
			public boolean onPrepareActionMode(ActionMode arg0, Menu arg1) {
				return false;
			}
			
			
			@Override
			public boolean onActionItemClicked(ActionMode arg0, MenuItem item) {
				
				if(item.getItemId() == R.id.delete)
					Toast.makeText(getBaseContext(), "Deleted", Toast.LENGTH_SHORT).show();
					mymode.finish(); // to remove the contextual Actions
				return false;
			}
			
			@Override
			public void onDestroyActionMode(ActionMode arg0) {
				arg0 = null;
			}
			
			
			@Override
			public void onItemCheckedStateChanged(
					ActionMode arg0, int arg1, long arg2,
					boolean arg3) {
				
			}
		};
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
