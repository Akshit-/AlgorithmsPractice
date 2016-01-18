package Networking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TSSGS {
	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		int numberOfCases = s.nextInt();
		numberOfCases = numberOfCases < 0 ? 0 : numberOfCases;
		int currentCase = 1;
		while (currentCase <= numberOfCases) {
			int numberOfPeople = s.nextInt();
			numberOfPeople = numberOfPeople < 0 ? 0 : numberOfPeople;
			List<Person> persons = new ArrayList<Person>();
			for (int index = 0; index < numberOfPeople; index++) {
				persons.add(new Person(index + 1));
			}
			int i = 0;

			PriorityQueue priorityQueue = new PriorityQueue();
			int[][] graph = new int[numberOfPeople][numberOfPeople]; 
			while (i < numberOfPeople) {
				int j = 0;
				while (j < numberOfPeople) {
					int distance = s.nextInt();
					if (i != j) {
						graph[i][j] = distance;
					}
					j++;
				}
				i++;
			}

			List<Person> minimumSpammingTree = new ArrayList<Person>();
			Person currentPerson = persons.get(0);
			persons.remove(currentPerson);
			while(persons.size()>0) {
				for(int edge = 0; edge < persons.size(); edge++){
					Person p = persons.get(edge);
//					int value = graph[currentPerson.ID -1][p.ID - 1];
//					if(value == 0)
//						value = graph[p.ID-1][currentPerson.ID -1];
					priorityQueue.insert(currentPerson, p, graph[currentPerson.ID -1][p.ID - 1]);
				}
				Person next = priorityQueue.getMin();
				if (next != null) {
					persons.remove(next);
					minimumSpammingTree.add(next);
					currentPerson = next;
				}
			}
			System.out.println("Case #" + currentCase + ":");
			while (minimumSpammingTree.size() > 0) {
				Person current = minimumSpammingTree.get(0);
				for (Person p : minimumSpammingTree) {
					current = p.compareTo(current);
				}
				System.out.println(current);
				minimumSpammingTree.remove(current);
			}
			System.out.println();
			currentCase++;
		}
	}

}
