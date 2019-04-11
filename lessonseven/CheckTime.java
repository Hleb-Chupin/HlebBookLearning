package lessonseven;

import java.util.*;


public class CheckTime {

    public static void run(){
        ArrayList arr = new ArrayList();
        LinkedList link = new LinkedList();
        HashSet hash = new HashSet();
        TreeSet trs = new TreeSet();

        TimerUtil.getTimeToAddElement(arr);
        TimerUtil.getTimeToAddElement(link);
        TimerUtil.getTimeToAddElement(hash);
        TimerUtil.getTimeToAddElement(trs);

        TimerUtil.getTimeToFindElement(arr);
        TimerUtil.getTimeToFindElement(link);
        TimerUtil.getTimeToFindElement(hash);
        TimerUtil.getTimeToFindElement(trs);

        TimerUtil.getTimeToClearElement(arr);
        TimerUtil.getTimeToClearElement(link);
        TimerUtil.getTimeToClearElement(hash);
        TimerUtil.getTimeToClearElement(trs);
    }
}