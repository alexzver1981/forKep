package alex.project19;

import java.io.ObjectInputStream;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Serv extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.d("myLogs", "onCreate");
		
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Log.d("myLogs", "onStartCommand");
			
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream(openFileInput("Alex"));
			
			Patient obj = (Patient)ois.readObject();
			
			ois.close();
			
			Log.d("myLogs", "patient прочтён");
			
			//return obj;

		} catch (Exception e) {
			e.printStackTrace();
		
			Log.d("myLogs", "patient не прочтён");
		}
		
		
		stopSelf();
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		Log.d("myLogs", "onDestroy");
		
	}
	
	
	
}
