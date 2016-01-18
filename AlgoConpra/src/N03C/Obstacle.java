package N03C;

public class Obstacle  {
	public int startPos = 0;
	public int endPos = 0;
	public Boolean isSnake = false;
	
	public Boolean visited = false;
	public Obstacle(int startPos, int endPos, Boolean isSnake){
		this.startPos = startPos;
		this.endPos = endPos;
		this.isSnake = isSnake;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Obstacle)){
    		return false;
    	}
		Obstacle other = (Obstacle)obj;
    	return startPos == other.startPos && endPos == other.endPos;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "From:" + startPos + " to:" + endPos + " isSnake:" + isSnake;
	}
	
	
}
