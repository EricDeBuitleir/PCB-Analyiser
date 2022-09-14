package sample;

public class Patient {
    private String PPSN;
    private String Name;
    private String DOB;
    private String Address;
    private String Email;
    private String AccessibilityInfo;
    public myLinkedList<VaccinationRecord> vaccinationRecord = new myLinkedList<>();





    public String getPPSN() {
        return PPSN;
    }

    public void setPPSN(String PPSN) {
        //if(Utilities.validPPS(PPSN)){
        this.PPSN = PPSN;
    //}
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {

        return Email;
    }

    public void setEmail(String email) {
      //  if(Utilities.validEmail(email))
        Email = email;
    }

    public String getAccessibilityInfo() {
        return AccessibilityInfo;
    }

    public void setAccessibilityInfo(String accessibilityInfo) {
        AccessibilityInfo = accessibilityInfo;
    }
    public Patient(String PPSN, String Name, String DOB, String Address, String email, String accessibilityInfo){

        setPPSN(PPSN);
        setName(Name);
        setDOB(DOB);
        setAddress(Address);
        setEmail(email);
        setAccessibilityInfo(accessibilityInfo);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "PPSN='" + PPSN + '\'' +
                ", Name='" + Name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                ", AccessibilityInfo='" + AccessibilityInfo + '\'' +
                '}';
    }

    public void addRecord(VaccinationRecord vacRecord ){
        vaccinationRecord.addElement(vacRecord);

    }
}
