package lessoneight;

import java.io.File;

public class FolderFileNameFilter implements java.io.FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        boolean result;
        if (name.endsWith(".java")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
