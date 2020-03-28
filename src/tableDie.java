import java.io.*;

public class tableDie{
	public static int die(RandomAccessFile file) {
	    RandomAccessFile fileHandler = null;
	    try {
	        fileHandler = file;
                int diceSum = 0;
                String lineRead;
                String[] lineSplit;
                int diceValue;
                while ((lineRead = fileHandler.readLine())!= null){
                    lineSplit = lineRead.split(";");
                    diceValue = Integer.parseInt(lineSplit[1]);
                    diceSum += diceValue;
                }
	        return diceSum;
	    } catch( java.io.FileNotFoundException e ) {
	        e.printStackTrace();
	        return 0;
	    } catch( java.io.IOException e ) {
	        e.printStackTrace();
	        return 0;
	    } 
	}
	
	public static String inline(String input) {
		String[] inputSplit = input.split("%");
		System.out.println(inputSplit[0]);
		System.out.println(inputSplit[1]);
		System.out.println(inputSplit[2]);
        String[] diceDescription = inputSplit[1].split("d");
		int i, j, total = 0;
		for(i=1; i <=  Integer.parseInt(diceDescription[0]); i++){
			for(j=1; j <=  Integer.parseInt(diceDescription[1]); j++){
				total += (int) Math.random()*j;
			}
		}
		String output = inputSplit[0]+total+inputSplit[2];
        return output;
	}
}