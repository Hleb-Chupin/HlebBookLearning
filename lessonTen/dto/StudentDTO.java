package lessonTen.dto;

public class StudentDTO {
    private int id;
    private String name;
    private String secondName;
    private int enrolmentYear;
    private int mark;
    private String subjectName;

    public StudentDTO(int id, String name, String secondName, int enrolmentYear) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.enrolmentYear = enrolmentYear;
    }

    public StudentDTO(String name, String secondName, int enrolmentYear) {
        this.name = name;
        this.secondName = secondName;
        this.enrolmentYear = enrolmentYear;
    }

    public StudentDTO(String name, String secondName, int mark, String subjectName) {
        this.name = name;
        this.secondName = secondName;
        this.mark = mark;
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getEnrolmentYear() {
        return enrolmentYear;
    }

    public void setEnrolmentYear(int enrolmentYear) {
        this.enrolmentYear = enrolmentYear;
    }
}
