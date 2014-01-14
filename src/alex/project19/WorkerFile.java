package alex.project19;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class WorkerFile  {
	
	public void save(Patient obj, String fileName, Context context){
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput("Alex", context.MODE_MULTI_PROCESS));
			
			oos.writeObject(obj);
			oos.close();

			Log.d("myLogs", "patient записан");

		} catch (Exception e) {
			e.printStackTrace();
			
			
			Log.d("myLogs", "не сохранён " + e.getStackTrace());
		}	
	}
	
	
	public Patient read(String fileName, Context context){
		
		try {
		
			ObjectInputStream ois = new ObjectInputStream(context.openFileInput(fileName));
			
			Patient obj = (Patient)ois.readObject();
			
			ois.close();
			
			Log.d("myLogs", "patient прочтён");
			
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
		
			Log.d("myLogs", "exc ");
		}
		
		Patient patient = new Patient();
		Log.d("myLogs", "new patient");
		return patient;
	}
	
	
}
