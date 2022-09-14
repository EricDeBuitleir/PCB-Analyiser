package sample;


import javafx.scene.control.ComboBox;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointments {
    private LocalDate Date;
    private String Time;
    private String Type;
    private String Batch;
    private String Vaccinator;
    private String PPSN;



    public Appointments(LocalDate date, String time, String type, String batch, String vaccinator, String ppsn) {
        Date = date;
        Time = time;
        Type = type;
        Batch = batch;
        Vaccinator = vaccinator;
        this.PPSN = ppsn;

    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
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

    public String getVaccinator() {
        return Vaccinator;
    }

    public void setVaccinator(String vaccinator) {
        Vaccinator = vaccinator;
    }

    public String getPPSN() {
        return PPSN;
    }

    public void setPPSN(String PPSN) {
        this.PPSN = PPSN;
    }


    @Override
    public String toString() {
        return "Appointments{" +
                "Date=" + Date +
                ", Time='" + Time + '\'' +
                ", Type='" + Type + '\'' +
                ", Batch='" + Batch + '\'' +
                ", Vaccinator='" + Vaccinator + '\'' +
                ", PPSN='" + PPSN + '\'' +
                '}';
    }
}
