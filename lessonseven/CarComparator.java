package lessonseven;

import java.util.*;

public class CarComparator implements Comparator<List<CarMake>> {

    public int compare(List<CarMake> lst1, List<CarMake> lst2) {
        return lst1.size() - lst2.size();
    }

}

