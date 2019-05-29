package lessoneight;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        /Task 1
         */
        copyFile("/Users/hlebchupin/Downloads/IMG_3321.mov", "/Users/hlebchupin/Downloads/IMG_3321_copy.mov");
        /*
        /Task 2
         */
        sortFileNames("/Users/hlebchupin/Downloads/Text.txt");
        /*
        /Task 3
         */
        sortLinesInFile("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven", 3, ".java");


    /*
   /Task 4
    */
        UniqueWordsFinder finder = new UniqueWordsFinder();
        finder.countUniqueWords("/Users/hlebchupin/Documents/Java/chupin/booklearning/src/lessonseven", ".java");
    }

    public static void copyFile(String fileNamePath, String newFileNamePath) {
        byte[] buffer = null;
        try (InputStream in = new FileInputStream(fileNamePath)) {
            buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream out = new FileOutputStream(newFileNamePath)) {
            out.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortFileNames(String folderPath) {
        try (BufferedReader text = new BufferedReader(new FileReader(folderPath))) {
            Set<String> sort = new TreeSet<>();
            while (text.ready()) {
                sort.add(text.readLine());
            }
            for (String s : sort) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortLinesInFile(String folderPath, int numOfLines, String fileName) {
        File folder = new File(folderPath);
        String[] buffer = folder.list(new FolderFileNameFilter(fileName));
        int o = 1;
        for (String s : buffer) {
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


