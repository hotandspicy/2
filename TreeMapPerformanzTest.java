import java.util.*;
public class TreeMapPerformanzTest extends PerformanzTest {
	private Map<Object, Object> treeMap;
	private Iterator keySetIterator;
	// Rückgabetyp durch void ersetzen
	public void untersucheSchreibzeit(Object[] testObjekte, long loops) {
		
		Map<Object, Object> tmpTreeMap = new TreeMap<Object, Object>();
		long i = 0;
		this.setMesszeit(0);
		while(i <= loops) {
			
			tmpTreeMap.clear();
			//--Messstart--
			long startZeit = System.nanoTime();
			

			for(Object j: testObjekte) {
				tmpTreeMap.put(new String(j.toString()), new String(j.toString()));
			}


			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende--

			i++;

		}	

		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
		this.treeMap = tmpTreeMap;

	}

	@Override
	public void untersucheHinzufügenElement(String objekt, long loops)
	{ 

		this.setMesszeit(0);
		long i = 0;

		while(i <= loops) {
			
			//--Messstart
			long startZeit = System.nanoTime();
			treeMap.put(new String(objekt), new String(objekt));
			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende
			treeMap.remove(objekt);
			i++;

		}
		long messzeitDurchschnitt = this.getMesszeit() / (loops +1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
	}

	@Override
	public void untersucheLesezeit(long loops) {

		Set keySet = this.treeMap.keySet();
		
		long i = 0;
		this.setMesszeit(0);	
		while(i <= loops) {
			this.keySetIterator = keySet.iterator();
			//--Messstart
			long startZeit = System.nanoTime();
			
			while(this.keySetIterator.hasNext()) {
				treeMap.get(this.keySetIterator.next());
			}
			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//-Messende
			

			i++;
		}

		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
		
	}
	@Override
	public void untersucheLesezeitElement(Object objekt, long loops) {

		long i = 0;
		this.setMesszeit(0);
		while(i <= loops) {
			//--Messstart
			long startZeit = System.nanoTime();
			this.treeMap.get(objekt);
			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende
			i++;
		}
		long messzeitDurchschnitt = this.getMesszeit() / (loops +1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
	}
	
	@Override 
	public void untersucheLesezeitTeilmenge(long loops) {
	}

	@Override 
	public String toString() {
		StringBuffer buffer = new StringBuffer("TreeMap (nano-Sek): \t ");
		String ausgabe;
		for(Long i: this.getErgebnisVektor()) {
			buffer.append(String.format("%d \t", i));
		}
		ausgabe = buffer.toString();
		return ausgabe;
	}
}
