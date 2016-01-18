package Networking;

public class Person {
	int ID;
	Person from;
	public Person(int ID){
		this.ID = ID;
	}
	public Person compareTo(Person other){
		if(getMin() < other.getMin())
			return this;
		else if(getMin() == other.getMin()){
			if(getOtherMin() < other.getOtherMin())
				return this;
			else
				return other;
		}
		else
			return other;
	}
	
	public int getMin(){
		return ID < from.ID ? ID : from.ID;
	}
	
	public int getOtherMin(){
		return ID < from.ID ? from.ID: ID ;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ID < from.ID ? ID + " " + from.ID : from.ID + " " + ID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID != other.ID)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		return true;
	}
	
	
}
