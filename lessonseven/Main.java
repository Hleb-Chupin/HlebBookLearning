package lessonseven;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        /**
         * Task number one.
         */
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


        List<CarMake> carList = new ArrayList<CarMake>();
        carList.add(new CarMake("Kia", 220, 7, 70));
        carList.add(new CarMake("Isuzu", 230, 4, 34));
        carList.add(new CarMake("Mazda", 280, 9, 67));
        carList.add(new CarMake("Honda", 260, 12, 75));

        Comparator<CarMake> compareMake = new Comparator<CarMake>() {
            public int compare(CarMake make1, CarMake make2) {
                return make1.getMake().compareTo(make2.getMake());
            }
        };
        Comparator<CarMake> compareSkorost = new Comparator<CarMake>() {
            public int compare(CarMake make1, CarMake make2) {
                return Integer.compare(make1.getSkorost(), make2.getSkorost());
            }
        };
        Comparator<CarMake> compareRashod = new Comparator<CarMake>() {
            public int compare(CarMake make1, CarMake make2) {
                return Integer.compare(make1.getRashod(), make2.getRashod());
            }
        };
        Comparator<CarMake> compareBak = new Comparator<CarMake>() {
            public int compare(CarMake make1, CarMake make2) {
                return Integer.compare(make1.getBak(), make2.getBak());
            }
        };

        Collections.sort(carList, compareMake);
        System.out.println("\n" + "Сортировка по марке");
        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
            Object o = iter.next();
            System.out.println(o);
        }
        ;
        Collections.sort(carList, compareSkorost);
        System.out.println("\n" + "Сортировка по скорости");
        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
            Object o = iter.next();
            System.out.println(o);
        }
        ;
        Collections.sort(carList, compareRashod);
        System.out.println("\n" + "Сортировка по расходу");
        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
            Object o = iter.next();
            System.out.println(o);
        }
        ;
        Collections.sort(carList, compareBak);
        System.out.println("\n" + "Сортировка по баку");
        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
            Object o = iter.next();
            System.out.println(o);
        }
        /*
         * Added task number three. Have to use comparable interface.
         */
        Collections.sort(carList);
        System.out.println("\n" + "Сортировка по марке comparable");
        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
            Object o = iter.next();
            System.out.println(o);
        }


        /**
         * Task number four.
         */
        List<List<CarMake>> carMultipleList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 35; i++) {
            List<CarMake> cars = new ArrayList<CarMake>();
            int rand = random.nextInt(100);
            for (int j = 0; j < rand; j++) {
                cars.add(new CarMake());
            }
            carMultipleList.add(i, cars);
        }

        /*
         ** Comparator anonimnyi klass.
         */
//        Comparator<List<CarMake>> compareLength = new Comparator<List<CarMake>>() {
//            public int compare(List lst1, List lst2) {
//                return Integer.compare(lst1.size(), lst2.size());
//            }
//        };
//        Collections.sort(carMultipleList, compareLength);
//        for (int a = 0; a < 35; a++) {
//            System.out.println("Размер списка номер " + a + " : " + carMultipleList.get(a).size());
//
//        }

        CarComparator carComparator = new CarComparator();
        Collections.sort(carMultipleList, carComparator);
        for (int a = 0; a < 35; a++) {
            System.out.println("Размер списка номер jj" + a + " : " + carMultipleList.get(a).size());

        }


        /**
         *
         *
         * Dictionary. Zadanie nomer 5.
         * Ja dumaju, chto sdelano nepravilno. Hotia vsio rabotajet, no mne kazhetsa,
         * chto ne sobliudion princip chto kazdyi klass otvechajet za chto-to odno.
         * Navernoje nado bylo delat dva klassa dlia etogo zadanija.
         *
         * Libo, nado delat etot klass statichnym. Chtoby on rabotal pohozhe na Math.
         *
         */
        Dictionary russkiy = new Dictionary();
        russkiy.setSlovar("Home", "The building where people live.");
        russkiy.setSlovar("Road", "The surface where people drive the car.");
        russkiy.setSlovar("Sun", "The planet of the Galaxy.");
        russkiy.setSlovar("Table", "The furniture people are using in the kitchen.");
        russkiy.setSlovar("TV", "The screen that shows video.");


        System.out.println(russkiy.getSlovar("Home"));
    }
}