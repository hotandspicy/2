import java.util.*;
public class Auswertung {

	public Auswertung(String[] label) {
		this.setSpaltenLabel(label);
	}

	private List<String> zeilenLabel = new ArrayList<String>();
	private List<String> spaltenLabel;
	private List<List> matrix = new ArrayList<List>();
	public void initialisiereMatrix(List<Long> vektor, String label) {
			this.matrix.add(new ArrayList<Long>(vektor));
			this.setZeilenLabel(label);
	}
	
	public void setZeilenLabel(String label) {
		this.zeilenLabel.add(label);
	}

	public List<String> getZeilenLabel() {
		return this.zeilenLabel;
	}

	public void setSpaltenLabel(String[] label) {
		spaltenLabel = new ArrayList<String>(label.length);
		for(int i = 0; i < label.length; i++) {
			spaltenLabel.add(label[i]);
		}
	}

	public List<String> getSpaltenLabel() {
		return this.spaltenLabel;
	}

	@Override
	public String toString() {
		StringBuffer strB = new StringBuffer();
		if(spaltenLabel.isEmpty() || zeilenLabel.isEmpty()) {
			System.out.println("Es fehlen Label!");
			System.exit(1);
		}
		
		int m = this.matrix.get(0).size();
		int n = this.matrix.size();
		int i = 0;
		int j = 0;
		System.out.println(String.format("%41s%10s%10s\n", this.zeilenLabel.get(0), this.zeilenLabel.get(1), this.zeilenLabel.get(2)));


		while(j < m) {
			
			if(i != 0)
				strB.append(String.format("%10d", this.matrix.get(i).get(j)));
			else
				strB.append(String.format("%-30s %10d", this.spaltenLabel.get(j), this.matrix.get(i).get(j)));		
			if(i+1 == n) {
				i = 0;
				j++;
				strB.append("\n");
			} else
			       i++;	
			
		}
		return strB.toString();
	}

	
}
