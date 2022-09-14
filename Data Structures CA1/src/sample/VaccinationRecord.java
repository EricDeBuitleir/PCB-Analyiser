package sample;

import java.time.LocalDate;

public class VaccinationRecord {

    private LocalDate Date;
    private String Time;
    private String Type;
    private String Batch;
    private String PPSN;
    private String RecordName;
    private String DOB;


    public VaccinationRecord(LocalDate date, String time, String type, String batch, String PPSN, String recordName, String DOB) {
        Date = date;
        Time = time;
        Type = type;
        Batch = batch;
        this.PPSN = PPSN;
        RecordName = recordName;
        this.DOB = DOB;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public String getPPSN() {
        return PPSN;
    }

    public void setPPSN(String PPSN) {
        this.PPSN = PPSN;
    }

    public String getRecordName() {
        return RecordName;
    }

    public void setRecordName(String recordName) {
        RecordName = recordName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "VaccinationRecord{" +
                "Date=" + Date +
                ", Time='" + Time + '\'' +
                ", Type='" + Type + '\'' +
                ", Batch='" + Batch + '\'' +
                ", PPSN='" + PPSN + '\'' +
                ", Name='" + RecordName + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }
}
