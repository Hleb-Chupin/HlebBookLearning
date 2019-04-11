package lessonseven;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        /**
         * Task number one.
         */
        CheckTime.run();

//        List<CarMake> carList = new ArrayList<CarMake>();
//        carList.add(new CarMake("Kia", 220, 7, 70));
//        carList.add(new CarMake("Isuzu", 230, 4, 34));
//        carList.add(new CarMake("Mazda", 280, 9, 67));
//        carList.add(new CarMake("Honda", 260, 12, 75));
//
//        Comparator<CarMake> compareMake = new Comparator<CarMake>() {
//            public int compare(CarMake make1, CarMake make2) {
//                return make1.getMake().compareTo(make2.getMake());
//            }
//        };
//        Comparator<CarMake> compareSkorost = new Comparator<CarMake>() {
//            public int compare(CarMake make1, CarMake make2) {
//                return Integer.compare(make1.getSkorost(), make2.getSkorost());
//            }
//        };
//        Comparator<CarMake> compareRashod = new Comparator<CarMake>() {
//            public int compare(CarMake make1, CarMake make2) {
//                return Integer.compare(make1.getRashod(), make2.getRashod());
//            }
//        };
//        Comparator<CarMake> compareBak = new Comparator<CarMake>() {
//            public int compare(CarMake make1, CarMake make2) {
//                return Integer.compare(make1.getBak(), make2.getBak());
//            }
//        };

//        Collections.sort(carList, compareMake);
//        System.out.println("\n" + "Сортировка по марке");
//        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
//            Object o = iter.next();
//            System.out.println(o);
//        }
//        ;
//        Collections.sort(carList, compareSkorost);
//        System.out.println("\n" + "Сортировка по скорости");
//        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
//            Object o = iter.next();
//            System.out.println(o);
//        }
//        ;
//        Collections.sort(carList, compareRashod);
//        System.out.println("\n" + "Сортировка по расходу");
//        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
//            Object o = iter.next();
//            System.out.println(o);
//        }
//        ;
//        Collections.sort(carList, compareBak);
//        System.out.println("\n" + "Сортировка по баку");
//        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
//            Object o = iter.next();
//            System.out.println(o);
//        }
        /*
         * Added task number three. Have to use comparable interface.
//         */
//        Collections.sort(carList);
//        System.out.println("\n" + "Сортировка по марке comparable");
//        for (Iterator<CarMake> iter = carList.iterator(); iter.hasNext(); ) {
//            Object o = iter.next();
//            System.out.println(o);
//        }


        /**
         * Task number four.
         */
//        List<List<CarMake>> carListThirtyFive = new ArrayList<List<CarMake>>(35);
//        for (int i = 0; i < 35; i++) {
//            List<CarMake> carList_i = new ArrayList<CarMake>();
//            carList_i.add(new CarMake("Kia", 220, 7, 70));
//            carList_i.add(new CarMake("Isuzu", 230, 4, 34));
//            carList_i.add(new CarMake("Mazda", 280, 9, 67));
//            carList_i.add(new CarMake("Honda", 260, 12, 75));
//            carListThirtyFive.add(i, carList_i);
//        }

    }
}
