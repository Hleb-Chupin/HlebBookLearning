package lessoneight;

import java.io.File;

public class FolderFileNameFilter implements java.io.FilenameFilter {

    String endName;

    public FolderFileNameFilter(String endName){
        this.endName = endName;
    }

    @Override
    public boolean accept(File dir, String name) {
        boolean result;
        if (name.endsWith(endName)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
