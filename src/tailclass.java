import java.io.*;

public class tailclass {
	public static String tail( RandomAccessFile file ) {
	    RandomAccessFile fileHandler = null;
	    try {
	        fileHandler = file;
	        long fileLength = fileHandler.length() - 1;
	        StringBuilder sb = new StringBuilder();
	
	        for(long filePointer = fileLength; filePointer != -1; filePointer--){
	            fileHandler.seek( filePointer );
	            int readByte = fileHandler.readByte();
	
	            if( readByte == 0xA ) {
	                if( filePointer == fileLength ) {
	                    continue;
	                }
	                break;
	
	            } else if( readByte == 0xD ) {
	                if( filePointer == fileLength - 1 ) {
	                    continue;
	                }
	                break;
	            }
	
	            sb.append( ( char ) readByte );
	        }
	
	        String lastLine = sb.reverse().toString();
	        return lastLine;
	    } catch( java.io.FileNotFoundException e ) {
	        e.printStackTrace();
	        return null;
	    } catch( java.io.IOException e ) {
	        e.printStackTrace();
	        return null;
	    } 
	}
}