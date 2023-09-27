package generator;
import java.util.*;
import test.*;

public class DatenGenerierung implements TestDaten {
	private String[] stringListe;
	public String[] generiereStringListe(int anzahl) {
		stringListe = new String[anzahl];
		
		int j = 0; // Restklassenring A - Z
		for(int i = 0; i < anzahl; i++) {

			stringListe[i] = Character.toString(Integer.parseInt(String.format("%d", j + 41), 16));

			if(i >= 18) 
				stringListe[i] = stringListe[i].concat(stringListe[i - 18]);

			if(j < 18) 
				j++;
			else 
				j = 0;
		}
		return stringListe;
	}
	
	@Override
	public void setTestDaten(int anzahl) {
		this.generiereStringListe(anzahl);
	}
	
	@Override	
	public Object[] getTestDaten() {
		return this.stringListe;
	}
}
