package N03C;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner s;
	private static int MAX_NUMBER = 10020;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int numberOfCases = s.nextInt();
		int currentCase = 1;
		while (currentCase <= numberOfCases) {
			Map<Integer, Integer> dices = new HashMap<Integer, Integer>();
			
			int numberOfFields = s.nextInt();
			int numberOfSnakes = s.nextInt();
			int numberOfLadders = s.nextInt();
			
			
			Obstacle[] board = new Obstacle[MAX_NUMBER];
			Boolean[] used = new Boolean[MAX_NUMBER];
			
			for(int i = 0; i< numberOfSnakes; i++){
				int startPos = s.nextInt();
				int endPos = s.nextInt();
				Obstacle s = new Obstacle(startPos, endPos, true);
				board[startPos] = s;
			}
			for(int i = 0; i< numberOfLadders; i++){
				int startPos = s.nextInt();
				int endPos = s.nextInt();
				Obstacle s = new Obstacle(startPos, endPos, false);
				board[startPos] = s;
			}
			dices.put(1, Integer.MAX_VALUE);
			dices.put(2, Integer.MAX_VALUE);
			dices.put(3, Integer.MAX_VALUE);
			dices.put(4, Integer.MAX_VALUE);
			dices.put(5, Integer.MAX_VALUE);
			dices.put(6, Integer.MAX_VALUE);

			PriorityQueue<Path> queue = new PriorityQueue<Path>();
			for(int diceNumber =1; diceNumber<= 6; diceNumber++){
				Path initial = new Path(1,0);
				queue.add(initial);
				for(int i=0; i< used.length; i++)
					used[i] =false;
				
				while(!queue.isEmpty()){
					Path p = queue.poll();
//					System.out.println(p + " diceNumber: " + diceNumber);
					// Check if this turn will end the board
					if(p.currentPos >= numberOfFields){
						int currentBest = dices.get(diceNumber);
						if(p.numberOfRolls < currentBest){
							dices.put(diceNumber, p.numberOfRolls);
						}
					}
					else{
//						System.out.println("Start Post: " + p.currentPos + " obstacje:"+ board[p.currentPos]);
						if(board[p.currentPos] == null){
							if(!used[p.currentPos + diceNumber]){
								Path newPath =  new Path(p.currentPos + diceNumber, p.numberOfRolls + 1);
								queue.add(newPath);
								used[p.currentPos + diceNumber] = true;
							}
						}
						else{
							Obstacle current = board[p.currentPos];
							if(current.isSnake){
								if(!used[current.endPos]){
									Path newPath =  new Path(current.endPos, p.numberOfRolls);
									queue.add(newPath);
									used[current.endPos] = true;
								}
							}
							else{
								if(!used[current.endPos]){
									Path newPath =  new Path(current.endPos, p.numberOfRolls);
									queue.add(newPath);
									used[current.endPos] = true;
								}
								if(!used[p.currentPos + diceNumber]){
									Path newPath =  new Path(p.currentPos + diceNumber, p.numberOfRolls + 1);
									queue.add(newPath);
									used[p.currentPos + diceNumber] = true;
								}
							}
						}
					}
				}
			}
//			for(Integer diceNumber : dices.keySet()){
//				System.out.println("Value for key:" + diceNumber + " is:" + dices.get(diceNumber));
//			}
			String output = "";
			int minimum = -1;
			for (Integer diceNumber : dices.keySet()){
				int value = dices.get(diceNumber);
				if((value < minimum || minimum == -1) && value != Integer.MAX_VALUE){
					minimum = value;
					output = diceNumber + " ";
				}
				else if(value == minimum){
					output += diceNumber + " ";
				}
			}
			if(output == "")
				output = "impossible";
			System.out.println("Case #" + currentCase + ": " + output.trim());
			
			currentCase++;
		}
	}
}
