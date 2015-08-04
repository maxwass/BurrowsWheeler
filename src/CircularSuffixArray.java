import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;


public class CircularSuffixArray {
	
	ArrayList<CircularSuffix> orderCircSuff;
	ArrayList<CircularSuffix> origCircSuff;
	
	public CircularSuffixArray(String S) {
		//create array of CircularSuffixes, add each suffix into array, sort array
		
		//comparator for treemap
		Comparator<CircularSuffix> circSuffComp = new CircularSuffixComparator();
		
		ArrayList<CircularSuffix> a = new ArrayList<CircularSuffix>();
		ArrayList<CircularSuffix> b = new ArrayList<CircularSuffix>();
		
		for(int i = 0; i < S.length(); i++){
			CircularSuffix c = new CircularSuffix(S,i);
			a.add(c);
			b.add(c);
		}
//		//Should I implement LSD/MSD sort??
		Collections.sort(a,  circSuffComp);
		this.origCircSuff = b;
		this.orderCircSuff = a;
		
	}
	public int length(){ 
		return orderCircSuff.size();}
	public int index(int i){
		CircularSuffix a = this.origCircSuff.get(i);
		return Collections.binarySearch(this.orderCircSuff, a);
	}
	private void printOrderCircSuff(){
	//print out of all suffixes in alphabetical order
		System.out.println("Ordered Circular Suffixes");
		for(CircularSuffix a: this.orderCircSuff){
				System.out.println(a.toString());
			}
		
	}
		private static class CircularSuffixComparator implements Comparator<CircularSuffix>{
	
		public int compare(CircularSuffix a, CircularSuffix b){
			return a.compareTo(b);
		}
	}
	public static void main(String[] args) {
		CircularSuffixArray a = new CircularSuffixArray("mean");
		a.printOrderCircSuff();
		
		//test index
		System.out.println("Word 'mean': ");
		System.out.println("mean appears 2nd in sorted order: 2 ?= " + a.index(0));
		System.out.println("eanm appears 1st in sorted order: 1 ?= " + a.index(1));
		System.out.println("mean appears 0th in sorted order: 0 ?= " + a.index(2));
		

	}

}
