package chapterone;
import java.util.Scanner;
import java.util.Random;

public class SimpleNumbers {

  public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Введите максимальное количество случайных чисел: ");
	int n = sc.nextInt();
	Random rd = new Random();
	for (int i = 0; i < n; i++){
		int num = rd.nextInt();
		System.out.print(num + " ");
}
}
}