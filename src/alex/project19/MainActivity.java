package alex.project19;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText etName;
	private EditText etDavlenie;
	private EditText etSugar;
	private EditText etPuls;
	private EditText etWei;
	
	private SharedPreferences pref;
	private WorkerFile wf;
	
	private final int ID_REPORT = 1;
	private final int ID_SAVE = 2;
	private final int ID_EXIT = 3;
	private final int ID_SETT = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		etName = (EditText) findViewById(R.id.etName);
		etDavlenie = (EditText) findViewById(R.id.etDavlenie);
		etSugar = (EditText) findViewById(R.id.etSugar);
		etPuls = (EditText) findViewById(R.id.etPuls);
		etWei = (EditText) findViewById(R.id.etWei);
		
		pref = PreferenceManager.getDefaultSharedPreferences(this);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, ID_REPORT, 0, "����������");
		menu.add(0, ID_SAVE, 0, "���������");
		menu.add(0, ID_EXIT, 0, "�����");
		menu.add(0, ID_SETT, 0, "���������");

		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case ID_REPORT:

			statistics();
			break;

		case ID_SAVE:

			saveFile();
			break;

		case ID_EXIT:

			finish();
			break;
			
		case ID_SETT:

			Intent intent = new Intent(this, PreferencesActivity.class);
			startActivity(intent);
			
			break;
		}

		return super.onOptionsItemSelected(item);
	}
	
	
	private void statistics(){
		
	//	startService(new Intent(this, Serv.class));
		
		Patient patient = read();
		
		Bundle mybundl = new Bundle();
		mybundl.putSerializable("pat", patient);
		
		Intent intent = new Intent(this, PatientRez.class);
		intent.putExtras(mybundl);
		startActivity(intent);
	}
	
	
	private void saveFile(){
		
	//	Patient patient = read();
		Patient patient =  wf.read("Alex", this);
		
		
		
		patient.setName(etName.getText().toString());
		
		String str = pref.getString("davlenie", "");
		if (str.equals("C������������")) patient.setDavlenie("C������������ �������� " + etDavlenie.getText().toString());
		if (str.equals("��������������")) patient.setDavlenie("�������������� �������� " + etDavlenie.getText().toString());
		else patient.setDavlenie("��� ������, ������� ���������");
		
		if (pref.getBoolean("mm", false)) patient.setSugar("������� ������ " + etSugar.getText().toString() + " �����/�");
		if (pref.getBoolean("mg", false)) patient.setSugar("������� ������ " + etSugar.getText().toString() + " ��%");
		else patient.setSugar("��� ������, ������� ���������");
		
		if (pref.getBoolean("puls", false)) patient.setPuls("����� ����� ������ � ������ " + etPuls.getText().toString());
		if (!pref.getBoolean("puls", false)) patient.setPuls("����� ����� ������ � ������� " + etPuls.getText().toString());
		else patient.setPuls("��� ������, ������� ���������");
		
		if (pref.getBoolean("weis", false)) patient.setWes("��� " + etWei.getText().toString() + " ��");
		if (!pref.getBoolean("weis", false)) patient.setWes("��� " + etWei.getText().toString() + " ������");
		else patient.setWes("��� ������, ������� ���������");
		
		Log.d("myLogs", "save all");
		
		wf.save(patient, "Alex", this);
		
		//save(patient, etName.getText().toString());
	}
	
	
    public void save(Patient obj, String fileName){
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(openFileOutput(etName.getText().toString(), MODE_MULTI_PROCESS));
					
			oos.writeObject(obj);
			oos.close();

			Log.d("myLogs", "patient �������");

		} catch (Exception e) {
			e.printStackTrace();
			
			Log.d("myLogs", "�� ������� " + e);
		}	
	}
	
    
    public Patient read(){
		
		try {
		
			ObjectInputStream ois = new ObjectInputStream(openFileInput(etName.getText().toString()));
			
			Patient obj = (Patient)ois.readObject();
			
			ois.close();
			
			Log.d("myLogs", "patient ������");
			
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
		
			Log.d("myLogs", "patient �� ������");
		}
		
		Patient patient = new Patient();
		Log.d("myLogs", "new patient");
		return patient;
	}
    
    
}
