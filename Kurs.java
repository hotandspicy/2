import java.util.*;

public class Kurs implements Comparable<Kurs> {
	public static Kurs[] kursObjekte;

	private String kursName;

	public Kurs() { }
	public Kurs(String kursName) {
		this();
		this.kursName = kursName;
	}

	public static Kurs[] instanziiereKursObjekte(String[] kursnamenListe) {
		kursObjekte = new Kurs[kursnamenListe.length];
		for(int i = 0; i < kursnamenListe.length; i++) {
			kursObjekte[i] = new Kurs(kursnamenListe[i]);
		}

		return kursObjekte;
	}


	public void setKursName(String kursName) {
		this.kursName = kursName;
	}

	public String getKursname() {
		return this.kursName;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		
		if(o instanceof Kurs) {
			Kurs kursToCheck = (Kurs)o;

			return this.kursName == kursToCheck.kursName;
		} else
			return super.equals(o);
	}

	@Override
	public int compareTo(Kurs kurs) {
		return this.kursName.compareTo(kurs.kursName);
	}

	@Override
	public String toString() {
		return this.kursName;
	}
}

