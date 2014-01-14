package alex.project19;

import java.io.Serializable;
import java.util.ArrayList;
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6442778445458906466L;
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> davlenie = new ArrayList<String>();
	private ArrayList<String> sugar = new ArrayList<String>();
	private ArrayList<String> pulse = new ArrayList<String>();
	private ArrayList<String> wes = new ArrayList<String>();
	
	public void setName(String n){
		
		if (name.size() < 5) name.add(n);
		else if (name.size() >= 5){
			
			name.remove(0);
			name.add(n);
		}	
	}
	
	
	public void setDavlenie(String dav){
		
		if (davlenie.size() < 5) davlenie.add(dav);
		else if (davlenie.size() >= 5){
			
			davlenie.remove(0);
			davlenie.add(dav);
		}
	}
	
	
    public void setSugar(String sug){
		
		if (sugar.size() < 5) sugar.add(sug);
		else if (sugar.size() >= 5){
			
			sugar.remove(0);
			sugar.add(sug);
		}
	}
	
    
     public void setWes(String w){
		
		if (wes.size() < 5) wes.add(w);
		else if (wes.size() >= 5){
			
			wes.remove(0);
			wes.add(w);
		}
	}
    
	
     public void setPuls(String pul){
 		
		if (pulse.size() < 5) pulse.add(pul);
		else if (pulse.size() >= 5){
			
			pulse.remove(0);
			pulse.add(pul);
		}
	}
     
     
     public String getName(int i){
 		
 		return name.get(i);
 	}
     
	
     public String getDavlenie(int i){
  		
  		return davlenie.get(i);
  	}
     
     
     public String getSugar(int i){
   		
  		return sugar.get(i);
  	} 
     
     
     public String getPuls(int i){
   		
  		return pulse.get(i);
  	}
     
     
     public String getWes(int i){
   		
  		return wes.get(i);
  	}
     
     public int getSize(){
    	 
    	 return name.size();
     }
	
}
