import java.util.*;
public class ArrayListPerformanzTest extends PerformanzTest {
	
	List<Object> arrayList;
	Iterator arrayListIterator;

	@Override
	public void untersucheSchreibzeit(Object[] testObjekte, long loops) {
		
		Object[] tmpObj = null;
		if(testObjekte instanceof String[])
			tmpObj = (String[])testObjekte;
		else
			System.exit(1);
		
		List<Object> tmpArrayList = new ArrayList<Object>();
		long i = 0;
		this.setMesszeit(0);
		while(i <= loops) {
			tmpArrayList.clear();
			//--Messstart--
			long startZeit = System.nanoTime();
			for(Object j: tmpObj) {
				tmpArrayList.add(new String(j.toString()));
			}


			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende--
						
			i++;
		}

		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);

		this.addToErgebnisVektor(messzeitDurchschnitt);
		this.arrayList = tmpArrayList;

	}

	@Override
	public void untersucheHinzufügenElement(String objekt, long loops) {
			
		this.setMesszeit(0);
		long i = 0;
		while(i <= loops) {
			
			//--Messstart
			long startZeit = System.nanoTime();

			arrayList.add(1, new String(objekt));

			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende
			arrayList.remove(1);
			i++;
		}


		long messzeitDurchschnitt = this.getMesszeit() / (loops +1);
		this.addToErgebnisVektor(messzeitDurchschnitt);
	}

	
	@Override
	public void untersucheLesezeit(long loops) {

		//TODO: Typgleichheit prüfen
		//TODO: Iterator implementierten
		this.setMesszeit(0);
		long i = 0;	
		while(i <= loops) {
			this.arrayListIterator = this.arrayList.iterator();	
			//--Messstart
			long startZeit = System.nanoTime();
			
			while(arrayListIterator.hasNext()) {
				this.arrayListIterator.next();
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
		while(i <= loops) {

			this.arrayListIterator = this.arrayList.iterator();
			//--Messstart
			long startZeit = System.nanoTime();
			
			int j = this.arrayList.indexOf(objekt);
				arrayList.get(j);		

			this.setMesszeit(System.nanoTime() - startZeit + this.getMesszeit());
			//--Messende
			i++;

		
		}
		long messzeitDurchschnitt = this.getMesszeit() / (loops + 1);
		this.addToErgebnisVektor(messzeitDurchschnitt);	
	}
	
	@Override 
	public void untersucheLesezeitTeilmenge(long loops) {
		List<Object> subList = new ArrayList<Object>();
		List<Object> subList2 = new ArrayList<Object>();
		for(int i = 1; i <= 99; i += 2) {
			subList.add(new String(arrayList.get(i).toString()));
			subList2.add(new String(arrayList.get(i-1).toString()));
		}
		for(Object i: subList) {
			System.out.println(i.toString());
		}
		for(Object i: subList2) {
			System.out.println(i.toString());
		}

		arrayList.retainAll(subList);
		arrayList.retainAll(subList2);
		

		System.out.println(arrayList.isEmpty());




	}

	@Override 
	public String toString() {
		StringBuffer buffer = new StringBuffer("ArrayList (nano-Sek): \t ");
		String ausgabe;
		for(Long i: this.getErgebnisVektor()) {
			buffer.append(String.format("%d \t", i));
		}
		ausgabe = buffer.toString();
		return ausgabe;
	}

	
}
