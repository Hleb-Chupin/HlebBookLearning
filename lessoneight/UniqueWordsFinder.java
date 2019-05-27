package lessoneight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UniqueWordsFinder {

    private static HashSet uniqueWordsCount = new HashSet();
    ;

    public void UniqueWordsCounter(String path, String nameFilter) {
        File folder = new File(path);
        String[] buferTwo = folder.list(new FolderFileNameFilter(nameFilter));
        for (String s : buferTwo) {
            UniqueWordsFinder(folder + "/" + s);
        }
        System.out.println(uniqueWordsCount.size());
    }

    private void UniqueWordsFinder(String path) {
        try (BufferedReader inFiles = new BufferedReader(new FileReader(path))) {
            while (inFiles.ready()) {
                StringTokenizer words = new StringTokenizer(inFiles.readLine(), ",. ");
                while (words.hasMoreTokens()) {
                    uniqueWordsCount.add(words.nextToken());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
