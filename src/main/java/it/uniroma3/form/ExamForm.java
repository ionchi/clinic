package it.uniroma3.form;

public class ExamForm {
    private String patient, doctor, type, examDate;

    public String getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getType() {
        return type;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
}
