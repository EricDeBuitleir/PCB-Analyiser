package sample;


public class VaccinationCentre {
    private String Name;
    private String Address;
    private String Eircode;
    private String Parking;
    public myLinkedList<Booth> booth = new myLinkedList<>();



    public VaccinationCentre(String Name, String Address, String Eircode, String Parking) {
        setName(Name);
        setAddress(Address);
        setEircode(Eircode);
        setParking(Parking);
    }

        public String getName () {
            return Name;
        }

        public void setName (String name){
            if (Utilities.max30Chars(name))
                this.Name = name;
        }

        public String getAddress () {
            return Address;
        }

        public void setAddress (String address){
            Address = address;
        }


        public String getEircode () {
            return Eircode;
        }

        public void setEircode (String eircode){

                Eircode = eircode;
        }

        public String getParking () {
            return Parking;
        }

        public void setParking (String parking){
            Parking = parking;
        }




    @Override
    public String toString() {
        return "VaccinationCentre{" +
                "Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Eircode='" + Eircode + '\'' +
                ", Parking='" + Parking + '\'' +
                //", list=" + list +
                //", head=" + head +
                '}';
    }

    public void addBooth(Booth newBooth){
        booth.addElement(newBooth);

    }

    public void deleteABooth(int index){
        booth.delete(index);
    }
}








