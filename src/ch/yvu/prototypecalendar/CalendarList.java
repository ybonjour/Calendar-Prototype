package ch.yvu.prototypecalendar;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class CalendarList extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        Uri uriCalendars = Uri.parse("content://com.android.calendar/calendars");
        String[] projection = new String[]{"_id", "name"};
        
        //Get only active claendars (selected=1)
        Cursor cursor = managedQuery(uriCalendars, projection, "selected=1", null, null);
        
        String[] fromFields = new String[]{"name"};
        int[] toLayoutIds = new int[]{android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromFields, toLayoutIds);
        
        setListAdapter(adapter);
	}
}
