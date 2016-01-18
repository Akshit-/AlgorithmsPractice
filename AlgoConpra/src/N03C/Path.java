package N03C;

public class Path implements Comparable<Path> {
	int currentPos;
	int numberOfRolls;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Path other = (Path) obj;
		if (currentPos != other.currentPos)
			return false;
		if (numberOfRolls != other.numberOfRolls)
			return false;
		return true;
	}



	public Path(int currentPos, int numberOfRolls){
		this.currentPos = currentPos;
		this.numberOfRolls = numberOfRolls; 
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CurrentPos: " + currentPos + " NumberOFRolls:" + numberOfRolls;
	}
	
	@Override
	public int compareTo(Path o) {
		// TODO Auto-generated method stub
		if(this.numberOfRolls < o.numberOfRolls)
			return -1;
		if(this.numberOfRolls == o.numberOfRolls)
			return 0;
		else
			return 1;
	}
}
