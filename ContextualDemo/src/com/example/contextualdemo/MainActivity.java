package com.example.contextualdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	ActionMode.Callback callback;
	ActionMode mymode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b  = (Button) findViewById(R.id.btn);

		b.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				
				mymode = startActionMode(callback);
				return false;
			}
		});
				
		callback = new Callback() {
			
			@Override
			public boolean onCreateActionMode(ActionMode mode,
					Menu menu) {
				
				mode.setTitle("MyContextualActionBar");
				getMenuInflater().inflate(
						R.menu.contextual_menu, menu);
				return true;
			}
			
			@Override
			public boolean onPrepareActionMode(ActionMode mode,
					Menu menu) {
				return false;
				// e.g: increasing count of 
				// selected images in gallery
			}
			
			@Override
			public void onDestroyActionMode(ActionMode mode) {
				mode = null;
			}
			
			
			@Override
			public boolean onActionItemClicked(ActionMode mode,
					MenuItem item) {
				
				if(item.getItemId() == R.id.delete)
					Toast.makeText(getBaseContext(), 
							"Deleted", Toast.LENGTH_SHORT).show();
					mymode.finish(); // to remove the contextual Actions
				return false;
			}
		};	
	}
	

}
