package chapterone;

public class Arguments {

    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[args.length - 1 - i]);
        }
    }
}