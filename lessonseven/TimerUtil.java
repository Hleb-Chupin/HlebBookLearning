package lessonseven;

import java.util.*;


public class TimerUtil {

    static void getTimeToAddElement(Collection o) {
        long timeFirst = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            o.add(i);
        }
        System.out.println("Время добавления элемента: " + o.getClass().getSimpleName() + ": " + (Math.abs(timeFirst -= System.currentTimeMillis())));
    }

    static void getTimeToFindElement(Collection o) {
        long timeSecond = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            o.contains(i);
        }
        System.out.println("Время поиска элемента: " + o.getClass().getSimpleName() + ": " + (Math.abs(timeSecond -= System.currentTimeMillis())));
    }

    static void getTimeToClearElement(Collection o) {
        long timeThird = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            o.remove(i);
        }
        System.out.println("Время удаления элемента: " + o.getClass().getSimpleName() + ": " + (Math.abs(timeThird -= System.currentTimeMillis())));
    }

}