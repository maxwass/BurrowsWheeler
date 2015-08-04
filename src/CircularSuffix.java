
public class CircularSuffix implements Comparable<CircularSuffix> {
		//no new String's are created, only a reference to the original String
		String originalSuffix;
		int startIndex;
		
		public CircularSuffix(String originalSuffix, int startIndex){
			//pointer to the String object originalSuffix, no new copy
			this.originalSuffix = originalSuffix;
			//ints are passed by value
			this.startIndex = startIndex;
		}
		public char charAt(int index){
			//index is the index that would be used if we have a new String for this circular suffix
			//psuedoindex is the index back inside original suffix
			int psuedoIndex = (index + startIndex)%(this.length());
			return originalSuffix.charAt(psuedoIndex);
		}
		public int length() {
			return originalSuffix.length();}
		public int origSuffixOrder(){
			return startIndex;}
		public int compareTo(CircularSuffix that){
			if (this == that) return 0;
			
			for(int i = 0; i < this.length(); i++){
				int cmp = (this.charAt(i) - that.charAt(i));
				if (cmp != 0) return cmp; 
			}
			
			return 0;
		}
		public String toString(){
			//returns circular suffix
			char[] a = new char[this.length()];
			for(int i = 0; i  < this.length(); i++){
				a[i] = this.charAt(i);
			}
			return new String(a);
		}
	public static void main(String[] args) {
		CircularSuffix a = new CircularSuffix("mean",0);
		CircularSuffix b = new CircularSuffix("mean",1);
		
		System.out.println("Length is 4:" + ((a.length()==4) && (b.length()==4)) );
		System.out.println("char at for " + a.toString() + ": "  + a.charAt(0) +  a.charAt(1) +  a.charAt(2) +  a.charAt(3));
		System.out.println("char at for " + b.toString() + ": " +  b.charAt(0) +  b.charAt(1) +  b.charAt(2) +  b.charAt(3));
		System.out.println("compareTo mean, eanm: should be > 0 =>: " + a.compareTo(b));
		System.out.println("compareTo eanm, mean: should be < 0 =>: " + b.compareTo(a));
		System.out.println("compareTo mean, mean: should be = 0 =>: " + a.compareTo(a));
		System.out.println("compareTo eanm, eanm: should be = 0 =>: " + b.compareTo(b));
	}

}
