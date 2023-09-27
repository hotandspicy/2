import java.util.*;

public abstract class PerformanzTest {
	
	private List<Long> ergebnisVektor = new ArrayList<Long>();
	private long messzeit = 0;
	
	public abstract void untersucheSchreibzeit(Object[] testObjekte, long loops);
	public abstract void untersucheHinzufügenElement(String objekt, long loops);
	public abstract void untersucheLesezeit(long loops);
	public abstract void untersucheLesezeitElement(Object objekt, long loops);
	public abstract void untersucheLesezeitTeilmenge(long loop);

	public void setMesszeit(long messzeit) {
		this.messzeit= messzeit;
	}
	public long getMesszeit() {
		return this.messzeit;
	}
	
	public void addToErgebnisVektor(Long messzeit) {
		this.ergebnisVektor.add(messzeit);
	}
	
	public List<Long> getErgebnisVektor() {
		return this.ergebnisVektor;
	}

	public void clearErgebnisVektor() {
		this.ergebnisVektor.clear();
	}
	
}
