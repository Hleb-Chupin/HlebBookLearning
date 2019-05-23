package chupin.booklearning.chapter.first.b;
import java.util.Scanner;

public class NumberWork {

  public static void main(String args[]) {
	NumberWork number = new NumberWork();
	Scanner sc = new Scanner(System.in);
	System.out.println("Введите количество целых чисел: ");
	int quantity = sc.nextInt();
	int[] str = new int[quantity];
	System.out.println("Введите " + quantity + " целых чисел через пробел: ");
	for (int i = 0; i < quantity; i++) {
		str[i] = sc.nextInt();
}
	number.getOdd(str);
	number.getEven(str);
	number.getSpec(str);
	number.getSpecFive(str);
	number.getSmallBig(str);
	number.getBubbleSort(str);

}
	public void getOdd(int[] omg){
	System.out.println("Нечетные числа:");
	for (int i = 0; i < omg.length; i++){
		if (omg[i] %2 != 0){
		System.out.print(omg[i] + " ");
}
} System.out.println("");
}
public void getEven(int[] omg){
	System.out.println("Четные числа:");
	for (int i = 0; i < omg.length; i++){
		if (Math.abs(omg[i]) %2 == 0){
		System.out.print(omg[i] + " ");
}
} System.out.println("");
}
public void getSmallBig(int[] omg){
		int min = 0;
		int max = 0;
	for (int i = 0; i < omg.length; i++){
		if (omg[i] < min){
		min = omg[i];
}		if (omg[i] > max){
		max = omg[i];
} 
}		System.out.println("Меньшее число: " + min);
		System.out.println("Большее число: " + max);
		System.out.println("");
}
public void getSpec(int[] omg){
	System.out.println("Числа, которые делятся на 3 или на 9:");
	for (int i = 0; i < omg.length; i++){
		if ((Math.abs(omg[i]) %3 == 0) || (Math.abs(omg[i]) == 0)){
		System.out.print(omg[i] + " ");
}
} System.out.println("");
}
public void getSpecFive(int[] omg){
	System.out.println("Числа, которые делятся на 5 и на 7:");
	for (int i = 0; i < omg.length; i++){
		if ((Math.abs(omg[i]) %5 == 0) && (Math.abs(omg[i]) %7 == 0)){
		System.out.print(omg[i] + " ");
}
} System.out.println("");
}
public void getBubbleSort(int[] omg){
	System.out.println("5. Элементы, расположенные методом пузырька по убыванию модулей:");
	int min = 0;
	for (int i = 0; i < omg.length; i++){
		for (i = 0; i < omg.length - 1; i++){
			if (Math.abs(omg[i]) < Math.abs(omg[i+1])){
				min = omg[i];
				omg[i] = omg[i+1];
				omg[i+1] = min;
}
}
} System.out.println(java.util.Arrays.toString(omg));
}

}