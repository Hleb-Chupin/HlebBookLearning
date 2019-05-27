package lessoneight;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        /Task 1
         */
        byte[] buffer = null;
        try (InputStream in = new FileInputStream("/Users/hlebchupin/Downloads/IMG_3321.mov")) {
            buffer = new byte[in.available()];
            in.read(buffer,
                    0,
                    buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream out = new FileOutputStream("/Users/hlebchupin/Downloads/IMG_3321_copy.mov")) {
            out.write(buffer,
                    0,
                    buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        /Task 2
         */
        try (BufferedReader text = new BufferedReader(new FileReader("/Users/hlebchupin/Downloads/Text.txt"))) {
            TreeSet<String> sort = new TreeSet<String>();
            while (text.ready()) {
                sort.add(text.readLine().toString());
            }
            for (String s : sort) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        /Task 3
         */

        File folder = null;
        folder = new

                File("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven");

        String[] bufer = folder.list(new FolderFileNameFilter(".java"));
        int o = 1;
        for (
                String s : bufer) {
            System.out.println("File number " + o + " :");
            System.out.println("File name is: " + s);
            try (BufferedReader read = new BufferedReader(new FileReader(folder + "/" + s))) {
                for (int i = 0; i < 3; i++) {
                    System.out.println(read.readLine());
                }
                o++;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /*
   /Task 4
    */
        UniqueWordsFinder finder = new UniqueWordsFinder();
        finder.UniqueWordsCounter("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven", ".java");
    }
}


