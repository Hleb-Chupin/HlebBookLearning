package lessoneight;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        /Task 1
         */
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream("/Users/hlebchupin/Downloads/IMG_3321.mov");
            byte[] buffer = new byte[in.available()];
            in.read(buffer,
                    0,
                    buffer.length);
            out = new FileOutputStream("/Users/hlebchupin/Downloads/IMG_3321_copy.mov");
            out.write(buffer,
                    0,
                    buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
        /Task 2
         */
        BufferedReader text = null;
        try {
            text = new BufferedReader(new FileReader("/Users/hlebchupin/Downloads/Text.txt"));
            TreeSet<String> sort = new TreeSet<String>();
            while (text.ready()) {
                sort.add(text.readLine().toString());
            }
            for (String s : sort) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                text.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
        /Task 3
         */

        File folder = null;
        BufferedReader read = null;
        try {
            folder = new File("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven");
            String[] bufer = folder.list(new FolderFileNameFilter(".java"));
            int o = 1;
            for (String s : bufer) {
                System.out.println("File number " + o + " :");
                System.out.println("File name is: " + s);
                read = new BufferedReader(new FileReader(folder + "/" + s));
                for (int i = 0; i < 3; i++) {
                    System.out.println(read.readLine());
                }
                o++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         /*
        /Task 4
         */
        folder = new File("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven");
        String[] buferTwo = folder.list(new FolderFileNameFilter(".java"));
        UniqueWordsFinder finder = new UniqueWordsFinder();
        int overall = 0;
        for (String s : buferTwo) {
            overall += finder.FindUniqueWords(folder + "/" + s);
        }
        System.out.println(overall);
    }
}

