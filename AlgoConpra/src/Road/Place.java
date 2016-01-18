package Road;

import java.util.ArrayList;
import java.util.List;

public class Place {
	int num;
	List<Connection> roadsFromTheCity = new ArrayList<Connection>();
	public Place(int num){
		this.num = num;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}
