package sample;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Booth validBooth;
    private Booth invalidBooth;

    @BeforeEach
    public void setUP() {
        validBooth = new Booth("A1", "1", "Wheelchair accessible");
        invalidBooth = new Booth("John", "No where", "10");




    }

    @org.junit.jupiter.api.Test
    void initialize() {

    }

    @org.junit.jupiter.api.Test
    void addBooth() {
        assertEquals("A1", validBooth.getIdentifier());
        assertEquals("1", validBooth.getFloorLevel());
        assertEquals("Wheelchair accessible", validBooth.getAccessibility());



        assertEquals("John", invalidBooth.getIdentifier());
        assertEquals("No where", invalidBooth.getFloorLevel());
        assertEquals("10", invalidBooth.getAccessibility());
    }

    @org.junit.jupiter.api.Test
    void showBooth() {

    }

    @org.junit.jupiter.api.Test
    void deleteBooth() {



    }

    @org.junit.jupiter.api.Test
    void addPatient() {
    }

    @org.junit.jupiter.api.Test
    void deletePatient() {
    }

    @org.junit.jupiter.api.Test
    void addAppointment() {
    }

    @org.junit.jupiter.api.Test
    void reset() {
    }
}