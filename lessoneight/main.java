package lessoneight;


import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws Exception {
        /*
        /Task 1
         */
        InputStream in = new FileInputStream("/Users/hlebchupin/Downloads/IMG_3321.mov");
        OutputStream out = new FileOutputStream("/Users/hlebchupin/Downloads/IMG_3321_copy.mov");
        byte[] buffer = new byte[in.available()];
        in.read(buffer,
                0,
                buffer.length);
        out.write(buffer,
                0,
                buffer.length);
        /*
        /Task 2
         */
        BufferedReader text = new BufferedReader(new FileReader("/Users/hlebchupin/Downloads/Text.txt"));
        Set sort = new TreeSet();
        while (text.ready()) {
            sort.add("\n" + text.readLine());
        }
        System.out.println(sort);

        /*
        /Task 3
         */

        File folder = new File("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven");
        String[] bufer = folder.list(new FolderFileNameFilter());
        int o = 1;
        for (String s : bufer) {
            System.out.println("File number " + o + " :");
            System.out.println("File name is: " + s);
            BufferedReader read = new BufferedReader(new FileReader(folder + "/" + s));
            for (int i = 0; i < 3; i++) {
                System.out.println(read.readLine());
            }
            o++;
        }
         /*
        /Task 4
         */
        File folder = new File("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven");
        String[] buferTwo = folder.list(new FolderFileNameFilter());
        UniqueWordsFinder finder = new UniqueWordsFinder();
        int overall = 0;
        for (String s : buferTwo) {
            overall += finder.FindUniqueWords(folder + "/" + s);
        }
        System.out.println(overall);
    }
}

