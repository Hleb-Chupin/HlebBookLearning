package lessonTen.dto;

public class SubjectDTO {
    private int id;
    private String nameSubject;

    public SubjectDTO(int id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }

    public SubjectDTO(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String name) {
        this.nameSubject = name;
    }
}
