import java.util.*;

public class roll {
	private ArrayList<Integer> dice = new ArrayList<Integer>(); 
	private ArrayList<String> result = new ArrayList<String>();
	private ArrayList<String> tables = new ArrayList<String>();
	private table rollTable;
	
	public roll(String tableName){
		rollTable = new table(tableName);
	}
	public void makeRoll(){
		rollResult currentRoll = rollTable.makeRoll();
		result.add(currentRoll.getResult());
		dice.add(currentRoll.getDie());
		tables.add(currentRoll.getNextTable());
	}
	public String getResult(int index) {
		return result.get(index);
	}
	public int getDie(int index) {
		return dice.get(index);
	}
	public String getNextTable(int index) {
		return tables.get(index);
	}
	public String getResult() {
		return result.get(result.size() - 1);
	}
	public int getDie() {
		return dice.get(dice.size() - 1);
	}
	public String getNextTable() {
		return tables.get(tables.size() - 1);
	}
}
