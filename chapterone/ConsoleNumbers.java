package chapterone;

public class ConsoleNumbers {

  public static void main(String args[]) {
	int res = 1;
	for (int i = 0; i < args.length; i++){
		res *= Integer.parseInt(args[i]);
}
	System.out.println(res);
}
}