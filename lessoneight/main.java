package lessoneight;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        /Task 1
         */
        Main.copyVideoFile("/Users/hlebchupin/Downloads/IMG_3321.mov", "/Users/hlebchupin/Downloads/IMG_3321_copy.mov");
        /*
        /Task 2
         */
        Main.sortFileNames("/Users/hlebchupin/Downloads/Text.txt");
        /*
        /Task 3
         */
        Main.sortLinesInFile("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven", 3);


    /*
   /Task 4
    */
        UniqueWordsFinder finder = new UniqueWordsFinder();
        finder.countUniqueWords("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven", ".java");
    }

    public static void copyVideoFile(String folderName, String newFolderName) {
        byte[] buffer = null;
        try (InputStream in = new FileInputStream(folderName)) {
            buffer = new byte[in.available()];
            in.read(buffer,
                    0,
                    buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream out = new FileOutputStream(newFolderName)) {
            out.write(buffer,
                    0,
                    buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortFileNames(String folderName) {
        try (BufferedReader text = new BufferedReader(new FileReader(folderName))) {
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
    }

    public static void sortLinesInFile(String folderName, int numOfLines) {
        File folder = null;
        folder = new File(folderName);

        String[] bufer = folder.list(new FolderFileNameFilter(".java"));
        int o = 1;
        for (
                String s : bufer) {
            System.out.println("File number " + o + " :");
            System.out.println("File name is: " + s);
            try (BufferedReader read = new BufferedReader(new FileReader(folder + "/" + s))) {
                for (int i = 0; i < numOfLines; i++) {
                    System.out.println(read.readLine());
                }
                o++;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


