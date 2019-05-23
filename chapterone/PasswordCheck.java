package chapterone;
import java.util.Scanner;

public class PasswordCheck {

  public static void main(String args[]) {
	String str = "Apple";
	Scanner sc = new Scanner(System.in);
	System.out.println("Введите пароль: ");
	String n = sc.nextLine();
	if (n.equals(str)){
		System.out.println("success");
}
	else {
		System.out.println("wrong password");
}
}
}