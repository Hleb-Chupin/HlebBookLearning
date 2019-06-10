package lessonTen.dto;

public class StudentDTO {
    private int id;
    private String name;
    private String secondName;
    private int enrolmentYear;

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

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setEnrolmentYear(Integer enrolmentYear) {
        this.enrolmentYear = enrolmentYear;
    }
}
