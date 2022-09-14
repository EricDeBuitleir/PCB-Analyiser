package sample;



public class Booth {
    private String Identifier;
    private String floorLevel;
    private String Accessibility;
    public myLinkedList<Appointments> appointment = new myLinkedList<>();



    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        //if(Utilities.validIdentifier(identifier))
        this.Identifier = identifier;
    }

    public String getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(String floorLevel) {
        this.floorLevel = floorLevel;
    }

    public String getAccessibility() {
        return Accessibility;
    }

    public void setAccessibility(String accessibility) {
        Accessibility = accessibility;
    }

    public Booth(String Identifier, String floorLevel, String Accessibility) {
       setIdentifier(Identifier);
       setAccessibility(Accessibility);
       setFloorLevel(floorLevel);



    }

    @Override
    public String toString() {
        return "Booth{" +
                "Identifier='" + Identifier + '\'' +
                ", floorLevel='" + floorLevel + '\'' +
                ", Accessibility='" + Accessibility + '\'' +
                '}';
    }


    public void addAppointment(Appointments newAppointment){
        appointment.addElement(newAppointment);

    }
}
