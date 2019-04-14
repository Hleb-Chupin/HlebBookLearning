package lessonseven;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private String base;
    private String explanation;
    private Map dict = new HashMap();

    public Dictionary(String base, String explanation) {
        this.base = base;
        this.explanation = explanation;
    }

    public Dictionary() {
    }

    public String getBase() {
        return base;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setSlovar(Dictionary d) {
        dict.put(d.getBase(), d.getExplanation());
    }

    public String getSlovar(String s) {
        return (String) dict.get(s);
    }

}
