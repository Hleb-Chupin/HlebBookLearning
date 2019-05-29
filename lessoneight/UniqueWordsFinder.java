package lessoneight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class UniqueWordsFinder {

    public void countUniqueWords(String folderPath, String nameFilter) {
        Set<String> overallCount = new HashSet<>();
        File folder = new File(folderPath);
        String[] bufferTwo = folder.list(new FolderFileNameFilter(nameFilter));
        for (String s : bufferTwo) {
            for (String str : sumUniqueWordsCount(folder + "/" + s)) {
                overallCount.add(str);
            }
        }
        System.out.println(overallCount.size());
    }

    private Set<String> sumUniqueWordsCount(String path) {
        Set<String> uniqueWordsCount = new HashSet<>();
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
        return uniqueWordsCount;
    }
}
