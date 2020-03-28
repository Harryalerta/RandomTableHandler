
public class rollResult {
	public int die;
	public String result;
	public String nextTable;
	
	public rollResult(int inDie, String inResult, String inNextTable) {
		die = inDie;
		result = inResult;
		nextTable = inNextTable;
	}
	
	public String getResult() {
		return result;
	}
	
	public Integer getDie() {
		return die;
	}
	
	public String getNextTable() {
		return nextTable;
	}
}
