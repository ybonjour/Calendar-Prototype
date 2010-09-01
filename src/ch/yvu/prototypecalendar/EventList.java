package ch.yvu.prototypecalendar;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class EventList extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        Uri uriEvents = Uri.parse("content://com.android.calendar/events");
        String[] projection = new String[]{"_id", "title"};
        
        //Get only active claendars (selected=1)
        Cursor cursor = managedQuery(uriEvents, projection, null, null, null);
        
        String[] fromFields = new String[]{"title"};
        int[] toLayoutIds = new int[]{android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromFields, toLayoutIds);
        
        setListAdapter(adapter);
	}
}
