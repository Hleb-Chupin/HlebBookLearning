package lesson_ten.Run;

import lesson_ten.Util.ConnectionDB;
import lesson_ten.Util.Mark_DAO;

public class Main {
    public static void main(String[] Args) {
        Mark_DAO mark = new Mark_DAO();
        mark.getAll();
        mark.getMarkById(1);
    }
}