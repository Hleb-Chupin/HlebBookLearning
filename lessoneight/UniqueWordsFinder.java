package lessoneight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UniqueWordsFinder {

    public int FindUniqueWords(String path) {
        HashSet filter = null;
        try {
            BufferedReader inFiles = new BufferedReader(new FileReader(path));
            ArrayList<String> sentences = new ArrayList<String>();
            while (inFiles.ready()) {
                sentences.add(inFiles.readLine());
            }
            inFiles.close();
            filter = new HashSet();
            for (int i = 0; i < sentences.size(); i++) {
                StringTokenizer words = new StringTokenizer(sentences.get(i), ",. ");
                while (words.hasMoreTokens()) {
                    filter.add(words.nextToken());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return filter.size();
        }
    }
}
