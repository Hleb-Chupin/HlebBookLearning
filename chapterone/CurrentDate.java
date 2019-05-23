package chapterone;
import java.util.Scanner;
import java.util.Date;

public class CurrentDate {
  public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Задание выполнил: Имя_Фамилия");
	String str = sc.nextLine();
	Date date = new Date();
	Date currentDate = new Date(1554282218461l);
	System.out.println(str);
	System.out.println("Задание получено к выполнению: " + currentDate);
	System.out.println("Задание выполнено: " + date);

}
}