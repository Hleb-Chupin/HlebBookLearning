package chapterone;
import java.util.Scanner;

public class SayHello {

  public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);

	System.out.println("What is your name?");
	String i = sc.nextLine();
	System.out.println("Hello " + i);
	
}
}