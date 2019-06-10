package lessonTen.dao;

import lessonTen.dto.MarkDTO;
import lessonTen.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarkDAOImpl implements lessonTen.dao.MarkDAO {
    private ConnectionDB conn = new ConnectionDB();
    MarkDTO mark;
    List<MarkDTO> markList;

    @Override
    public List<MarkDTO> getAll() {
        try (Statement st = conn.connectDB().createStatement()) {
            markList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from mark;");
            while (res.next()) {
                mark = new MarkDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
                markList.add(mark);
            }
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return markList;
    }

    @Override
    public MarkDTO getMarkById(long id) {
        try (Statement st = conn.connectDB().createStatement()) {
            ResultSet res = st.executeQuery("select * from mark where id = " + id + ";");
            while (res.next()) {
                mark = new MarkDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
            }
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mark;
    }

    @Override
    public void setMarkById(Integer id, MarkDTO markVar) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("update mark set mark = " + markVar.getMark() + ", id_subject = " + markVar.getIdSubject() + ", id_student = " + markVar.getIdStudent() + " where id = " + id + " ;");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMark(MarkDTO markVar) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("insert into mark (mark, id_subject, id_student) values (" + markVar.getMark() + ", " + markVar.getIdSubject() + ", " + markVar.getIdStudent() + ");");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("delete from mark where id = " + id + ";");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}