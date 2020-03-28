public class mainclass {
	static String localDir;
	public static void main(String[] args) {
		localDir = System.getProperty("user.dir");
		// TODO Auto-generated method stub
		System.out.println("inicio");
		history currentHistory = new history();
		currentHistory.createEncouter();
	}

}
