import java.util.*;

public class history {
	private String nextTable = "aquaticoteste";
	private ArrayList<roll> rollSeries = new ArrayList<roll>();
	private boolean isHistoryComplete = false;
	public void addRoll(roll inRoll){
		rollSeries.add(inRoll);
	}
	public void removeLast(){
	}
	public void createEncouter(){
		while (!isHistoryComplete) {
			roll currentRoll = new roll(nextTable);
			currentRoll.makeRoll();
			rollSeries.add(currentRoll);
			System.out.printf("%d %s \n",currentRoll.getDie(), currentRoll.getResult());
			nextTable = currentRoll.getNextTable();
			System.out.printf("%s\n", nextTable);
			if(nextTable.equals(" ")) {
				isHistoryComplete = true;
			}
		}
	
	}
}
