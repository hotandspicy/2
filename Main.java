import java.util.*;
import test.*;
import generator.*;

public class Main {

	public static void main(String[] args) {
		int d = 1000;
		long n = (long)Math.pow(10, 6);
		String testElement = "TEST";
		String gesuchtesElement = "EFGHIP";
		TestDaten testDaten = new DatenGenerierung();

		TreeMapPerformanzTest testTreeMap = new TreeMapPerformanzTest();
		TreeSetPerformanzTest testTreeSet = new TreeSetPerformanzTest();
		ArrayListPerformanzTest testArrayList = new ArrayListPerformanzTest();
		String[] label = {"write", "add element", "read (all elements)", "read (one element)"};
		Auswertung ausgabe = new Auswertung(label);
		testDaten.setTestDaten(d);
			
		// Testen der Datenstruktur - ArrayList
		testArrayList.untersucheSchreibzeit(testDaten.getTestDaten(), n);
		testArrayList.untersucheHinzufügenElement(testElement, n);
		testArrayList.untersucheLesezeit(n);
		testArrayList.untersucheLesezeitElement(gesuchtesElement, n);

		// Testen der Datenstruktur - TreeMap
		testTreeMap.untersucheSchreibzeit(testDaten.getTestDaten(), n);
		testTreeMap.untersucheHinzufügenElement(testElement, n);
		testTreeMap.untersucheLesezeit(n);
		testTreeMap.untersucheLesezeitElement(gesuchtesElement, n);
		
		// Testen der Datenstruktur - TreeSet
		testTreeSet.untersucheSchreibzeit(testDaten.getTestDaten(), n);
		testTreeSet.untersucheHinzufügenElement(testElement, n);
		testTreeSet.untersucheLesezeit(n);
		testTreeSet.untersucheLesezeitElement(gesuchtesElement, n);
		
		
		ausgabe.initialisiereMatrix(testArrayList.getErgebnisVektor(), "ArrayList");
		ausgabe.initialisiereMatrix(testTreeMap.getErgebnisVektor(), "TreeMap");
		ausgabe.initialisiereMatrix(testTreeSet.getErgebnisVektor(), "TreeSet");

		System.out.println(ausgabe);
	}
}
