package lessonseven;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dict = new HashMap<String, String>();

    public Dictionary() {
    }

    public void setSlovar(String word, String explanation) {
        dict.put(word, explanation);
    }

    public String getSlovar(String s) {
        return dict.get(s);
    }

}
