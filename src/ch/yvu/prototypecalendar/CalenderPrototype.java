package ch.yvu.prototypecalendar;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class CalenderPrototype extends TabActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        //Calendars
        intent = new Intent(this, CalendarList.class);
        spec = tabHost.newTabSpec("calendars").setIndicator("Calenders").setContent(intent);
        tabHost.addTab(spec);

        //Events
        intent = new Intent(this, EventList.class);
        spec = tabHost.newTabSpec("events").setIndicator("Events").setContent(intent);
        tabHost.addTab(spec);

        //Create Event
        intent = new Intent(this, CreateEvent.class);
        spec = tabHost.newTabSpec("crateEvent").setIndicator("Create Event").setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(0);
    }
}