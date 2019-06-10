package lessonTen.dto;

public class MarkDTO {
    private int id;
    private String mark;
    private int idSubject;
    private int idStudent;

    public MarkDTO(int id, String mark, int idSubject, int idStudent) {
        this.id = id;
        this.mark = mark;
        this.idSubject = idSubject;
        this.idStudent = idStudent;
    }

    public MarkDTO(String mark, int idSubject, int idStudent) {
        this.mark = mark;
        this.idSubject = idSubject;
        this.idStudent = idStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
}
