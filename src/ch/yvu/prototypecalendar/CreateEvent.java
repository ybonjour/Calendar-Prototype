package ch.yvu.prototypecalendar;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEvent extends Activity {

	//Request Codes
	private static final int REQUEST_EVENT = 1; 
	
	private Button mCreateEventButton;
	private EditText mEventTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_event);
		
		mEventTitle = (EditText) findViewById(R.id.eventTitle);
		
		mCreateEventButton = (Button) findViewById(R.id.createEvent);
		
		mCreateEventButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_EDIT);
				
				Date start = new Date();
				Date end = new Date();
				end.setHours(end.getHours() + 2);
								
				intent.setType("vnd.android.cursor.item/event");
				intent.putExtra("beginTime", start);
				intent.putExtra("endTime",end);
				intent.putExtra("title", mEventTitle.getText().toString());
				
				startActivityForResult(intent, REQUEST_EVENT);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if(requestCode == REQUEST_EVENT)
		{
			Toast t = Toast.makeText(this, "Result code: " + resultCode, Toast.LENGTH_LONG);
			t.show();
		}
	}
}
