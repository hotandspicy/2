import java.util.*;

public class TreeSetPerformanzTest extends PerformanzTest {
	
	private Set<Object> treeSet; 
	private Iterator treeSetIterator;
	@Override
	public void untersucheSchreibzeit(Object[] testObjekte, long loops) {
		
		Set<Object> tmpTreeSet = new TreeSet<Object>();	
		long i = 0;
		this.setMesszeit(0);
		while(i <= loops) {
			tmpTreeSet.clear();
			//--Messstart--
			long startZeit = System.nanoTime();

			for(Object j: testObjekte) {
				tmpTreeSet.add(new String(j.toString()));
			}

			
			this.setMesszeit(System.nanoTime()- startZeit + this.getMesszeit());
			//--Messende--
			i++;
		}
		
		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
		this.treeSet = tmpTreeSet;

	}

	@Override
	public void untersucheHinzufügenElement(String objekt, long loops) {

		this.setMesszeit(0);
		long i = 0;

		while(i <= loops) {
			
			//--Messstart
			long startZeit = System.nanoTime();
			treeSet.add(new String(objekt));
			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende

			treeSet.remove(objekt);
			i++;

		}

		long messzeitDurchschnitt = this.getMesszeit() / (loops +1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
	}
	
	@Override
	public void untersucheLesezeit(long loops) {
			
		
		int i = 0;
		this.setMesszeit(0);
		while(i <= loops) {		
			this.treeSetIterator = this.treeSet.iterator();
			//--Messstart
			long startZeit = System.nanoTime();
			while(this.treeSetIterator.hasNext()) {
				this.treeSetIterator.next();
			}
			
			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende

			i++;
		}
		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
	}
	
	@Override
	public void untersucheLesezeitElement(Object objekt, long loops) {
		long i = 0;
		this.setMesszeit(0);
		this.treeSetIterator = treeSet.iterator();
		Object obj = null;
		while(i <= loops) {
			this.treeSetIterator = this.treeSet.iterator();
			//--Messstart
			long startZeit = System.nanoTime();
			while(treeSetIterator.hasNext()) {
				obj = treeSetIterator.next();
				if(obj.equals(objekt.toString())) {
					break;
				}
			}
		
			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende
			i++;
		}
		//DEBUG
		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
	}
	
	@Override 
	public void untersucheLesezeitTeilmenge(long loops) {
	}

	@Override 
	public String toString() {
		StringBuffer buffer = new StringBuffer("TreeSet (nano-Sek): \t ");
		String ausgabe;
		for(Long i: this.getErgebnisVektor()) {
			buffer.append(String.format("%d \t", i));
		}
		ausgabe = buffer.toString();
		return ausgabe;
	}	
}
	
