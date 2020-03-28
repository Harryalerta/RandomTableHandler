import java.io.*;

public class table {
	private String tableName;
	private RandomAccessFile tableFile;
	private int tableDice;
	
	public table(String inTableName){
		try {
			tableName = inTableName;
			tableFile = new RandomAccessFile(mainclass.localDir + "\\tables\\" + tableName, "r");
			tableFile.seek(0);
/* 			String lastLine = tailclass.tail(tableFile);
//			System.out.printf("%s\n", lastLine);
			String[] lastLineSplit = lastLine.split(";");
			tableDice = Integer.parseInt(lastLineSplit[1]); */
      tableDice = tableDie.die(tableFile);
		} catch(FileNotFoundException ex){
			System.out.println("Tabela não encontrada");			
		} catch(IOException ex) {
			System.out.printf("Erro ao consultar tabela");
		} 
	}

	public rollResult makeRoll() {
		try {
			int diceRoll = (int) (Math.random()*tableDice);
			System.out.printf("%d\n", diceRoll);
         	tableFile.seek(0);
			String lineRead = tableFile.readLine();
			String[] lineReadSplit = lineRead.split(";");
			int diceRead =Integer.parseInt(lineReadSplit[1]);
			while(diceRead < diceRoll) {
				lineRead = tableFile.readLine();
				lineReadSplit = lineRead.split(";");
				diceRead += Integer.parseInt(lineReadSplit[1]);
				}
			String resultDescription = tableDie.inline(lineReadSplit[0]);
			String resultNextTable = lineReadSplit[2];
			rollResult result = new rollResult(diceRoll, resultDescription, resultNextTable);
			tableFile.close();
			return result;
		} catch(IOException ex) {
			System.out.printf("Erro ao consultar tabela");
			rollResult result = new rollResult(0, " ", " ");
			return result;
		} 
	}
		
}
