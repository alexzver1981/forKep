package alex.project19;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class PatientRez extends Activity {
	
	private LinearLayout ll;
	private TextView tv;
	private Patient patient;
	private android.view.ViewGroup.LayoutParams lp;
	
	private TextView tvout1, tvout2, tvout3, tvout4, tvout5;

	private TextView[] tvout = {tvout1, tvout2, tvout3, tvout4, tvout5};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient);
		
		tv = (TextView) findViewById(R.id.tv);
		ll = (LinearLayout) findViewById(R.id.ll);
		
	    lp = tv.getLayoutParams();
		
		patient = (Patient) getIntent().getSerializableExtra("pat");
	}

	
	@Override
	protected void onStart() {
		super.onStart();
		
		int number = patient.getSize();
		String outText = "";
		
		for (int i = 0; i < number; i++){
			
			outText = patient.getName(i) + "\n";
			outText += patient.getDavlenie(i) + "\n";
			outText += patient.getSugar(i) + "\n";
			outText += patient.getPuls(i) + "\n";
			outText += patient.getWes(i) + "\n" + "\n";
			
			tvout[i] = new TextView(getApplicationContext());
			tvout[i].setText(outText);
			tvout[i].setLayoutParams(lp);
			tvout[i].setTextColor(Color.BLACK);
			ll.addView(tvout[i]);
			
		}
	}

}
