package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.*;
import java.time.LocalDate;


public class Controller {
    /** ================================================== */



    /*                    Vaccination Centre                */

    @FXML
    private TextField name;
    @FXML
    private String boxName;
    @FXML
    private TextField address;
    @FXML
    private TextField eircode;
    @FXML
    private TextField parking;
    @FXML
    private javafx.scene.control.ListView<VaccinationCentre> viewList;

    @FXML
    private Tab booth;
    @FXML
    private ChoiceBox boxChoice;
    @FXML
    private Tab appointment;



    /** ================================================== */

    /*                    Booth                */

@FXML
    private javafx.scene.control.ListView<Booth> boothListView;
    @FXML
    private TextField identifier;
    @FXML
    private TextField floor;
    @FXML
    private TextField accessibility;
    /** ================================================== */

    /*       Patient      */

    @FXML
    private javafx.scene.control.ListView<Patient> patientListView;
    @FXML
    private TextField pps;
    @FXML
    private TextField patientName;
    @FXML
    private TextField DOB;
    @FXML
    private TextField patientAddress;
    @FXML
    private TextField email;
    @FXML
    private TextField patientAccessibility;
    @FXML
    private ChoiceBox boothBox;

    /** ================================================== */

    /*       Appointment     */
@FXML
private javafx.scene.control.ListView<Appointments> appointmentViewList;
@FXML
private DatePicker appointmentDate;
@FXML
private ComboBox<String> appointmentTime;
@FXML
private ComboBox<String> appointmentType;
@FXML
private TextField appointmentBatch;
@FXML
private TextField Vaccinator;
@FXML
private ChoiceBox recordBox;
@FXML
private ComboBox<Patient> ppsnBox;


    /** ================================================== */

    /*    Vaccination Record    */

            @FXML
            private javafx.scene.control.ListView<VaccinationRecord> recordViewList;

    @FXML
    private ListView<String> searchViewList;
    @FXML
    private LocalDate recordDate;
    @FXML
    private String recordTime;
    @FXML
    private String recordType;
            @FXML
            private TextField recordBatch;
            @FXML
            private TextField recordPPSN;

            @FXML
            private ComboBox<String> recordTypeBox;









    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Object myLinkedList;

    public sample.myLinkedList<Patient> initialize() {
        booth.setDisable(true); // Setting the both tab to disabled
        appointment.setDisable(true); // Setting the appointment tab to disabled

        appointmentTime.getItems().addAll("9:00", "9:15", "9:30", "9:45", "10:00", "10:15"); // adding a time slot to a drop down box so you can choose them when making an appointment
        appointmentType.getItems().addAll("Pfizer", "AstraZeneca", "Moderna", "Janssen"); // adding these vaccination types to a drop down box so you can choose them when making an appointment
        loadPatientBox();



     for(int i = 0 ; i < Main.getPl().size() ; i++) {
         for (int j = 0; j < Main.getPl().get(i).vaccinationRecord.size() ; i++) {
             recordViewList.getItems().add(Main.getPl().get(i).vaccinationRecord.get(j)); // populates the record view list with the patients info when program is run

         }
     }
        return null;
    }
    public void loadPatientBox(){
        sample.myLinkedList.myLinkedListNode currentNode = Main.pl.head; // Makes the current node the head
        for (int i = 0; i < Main.pl.size(); i++) { // running over the size of my patient list
            Patient current = (Patient) currentNode.getContents(); // Casting in Patient and getting the contents of the head
            ppsnBox.getItems().add(current); // adding the contents to the ppsnBox (Patient drop down box in the appointment tab)

            currentNode = currentNode.next;


        }
    }




    public void close() {
        System.exit(0);
    }


    /** ======================================================================================================== */
    /**                                  VACCINATION CENTRE CONTROLLER                                           */
    /** ======================================================================================================== */

    public void addCentre() {

        VaccinationCentre VC = new VaccinationCentre(name.getText(), address.getText(), eircode.getText(), parking.getText());
        System.out.println("Vaccination Centre:" +"\n" +VC.getName() +"\n"+ VC.getAddress() +"\n"+ VC.getEircode() +"\n"+ VC.getParking() +"\n"+ "-----------------------------------------");


        Main.ll.addElement(VC); // Adding a centre to the center linked list
        showVaccinationCentre(); // adding the centre to both the centre viewlist and the choice box located in booth to be able to select to add a both to
        booth.setDisable(false); // setting the booth table to 'enabled'
        System.out.println();

    }

    public void showVaccinationCentre(){
        viewList.getItems().clear();
        boxChoice.getItems().clear();
        sample.myLinkedList.myLinkedListNode currentNode = Main.ll.head;
        for(int i = 0 ; i < Main.ll.size() ; i++){
            VaccinationCentre current = (VaccinationCentre) currentNode.getContents();
            viewList.getItems().add(current);
            boxChoice.getItems().add(current);
            currentNode = currentNode.next;

        }
    }



    public void deleteCentre(javafx.scene.input.MouseEvent vc){
        int selectedList = viewList.getSelectionModel().getSelectedIndex();

      viewList.getItems().remove(selectedList);
     Main.ll.delete(selectedList);
System.out.println(Main.ll.toString());
booth.setDisable(true);


    }





    /** ======================================================================================================== */
    /**                                  BOOTH CONTROLLER                                                        */
    /** ======================================================================================================== */

    public void addBooth() {
            Booth b = new Booth(identifier.getText(), floor.getText(), accessibility.getText());
            System.out.println("Booth:" +"\n" +b.getIdentifier() +"\n"+ b.getFloorLevel() +"\n"+ b.getAccessibility() +"\n"+ "-------------------------------");
            VaccinationCentre vcselected = (VaccinationCentre) boxChoice.getSelectionModel().getSelectedItem();
            vcselected.addBooth(b);
            showBooth(vcselected);
            appointment.setDisable(false);



    }

    public void showBooth(VaccinationCentre vc) {
        boothListView.getItems().clear();

        sample.myLinkedList.myLinkedListNode currentNode = vc.booth.head;
        for (int i = 0; i < vc.booth.size(); i++) {
            Booth current = (Booth) currentNode.getContents();
            boothListView.getItems().add(current);
            currentNode = currentNode.next;
            boothBox.getItems().add(current);
        }
    }

    public void deleteBooth(){
        int selectedList = boothListView.getSelectionModel().getSelectedIndex();

        boothListView.getItems().remove(selectedList);
        Main.ll.delete(selectedList);



    }




    /** ======================================================================================================== */
    /**                                  Patient CONTROLLER                                                      */
    /** ======================================================================================================== */

    public void addPatient(){
        Patient p = new Patient(pps.getText(), patientName.getText(), DOB.getText(), patientAddress.getText(), email.getText(), patientAccessibility.getText());
        System.out.println("Patient:" +"\n" + p.getPPSN() +"\n"+ p.getName() +"\n"+ p.getDOB() +"\n"+ p.getAddress() +"\n"+ p.getEmail() +"\n"+ p.getAccessibilityInfo() +"\n" +"\n" + "----------------------------");


        Main.pl.addElement(p);

        showPatient();
        loadPatientBox();

    }

    public void showPatient(){
        patientListView.getItems().clear();
        sample.myLinkedList.myLinkedListNode currentNode = Main.pl.head;
        for(int i = 0 ; i < Main.pl.size() ; i++){
            Patient current = (Patient) currentNode.getContents();
            patientListView.getItems().add(current);

            currentNode = currentNode.next;

        }
    }
    public void deletePatient(){
        int selectedList = patientListView.getSelectionModel().getSelectedIndex();

        Main.pl.delete(selectedList);
        patientListView.getItems().remove(selectedList);

    }



    /** ======================================================================================================== */
    /**                              Appointment CONTROLLER                                                      */
    /** ======================================================================================================== */




    public void addAppointment(){

        String pps = ppsnBox.getSelectionModel().getSelectedItem().getPPSN();



        Appointments a = new Appointments(appointmentDate.getValue(), appointmentTime.getSelectionModel().getSelectedItem().toString(), appointmentType.getSelectionModel().getSelectedItem(), appointmentBatch.getText(), Vaccinator.getText(), pps);
        System.out.println("Appointment:" +"\n" +a.getDate() + "\n" + a.getTime() + "\n" + a.getType() + "\n"+ a.getBatch() + "\n" + a.getVaccinator() + "\n" + "---------------------------------------------------" + "\n");
        Booth bselected = (Booth) boothBox.getSelectionModel().getSelectedItem();



        appointmentViewList.getItems().add(a);
            bselected.addAppointment(a);
            showAppointment();



        }




    public void completeAppointment(){
        VaccinationRecord vr = new VaccinationRecord(appointmentDate.getValue(), appointmentTime.getSelectionModel().getSelectedItem().toString(), appointmentType.getSelectionModel().getSelectedItem(), appointmentBatch.getText(), pps.getText(), patientName.getText(),  DOB.getText());
        System.out.println("Vaccination Record:" +"\n" +vr.getDate() + "\n" + vr.getTime() + "\n" + vr.getType() + "\n" +  vr.getBatch() + "\n" + vr.getPPSN()+ "\n" + vr.getRecordName() + "\n" + vr.getDOB() + "\n" + "---------------------------------------------------" + "\n");
        int aselected = appointmentViewList.getSelectionModel().getSelectedIndex(); // getting the selected appointment from the sleected booth index
        Booth bselected = (Booth) boothBox.getSelectionModel().getSelectedItem();


       bselected.appointment.delete(aselected); // deleting the appointment from the selected booth
        appointmentViewList.getItems().remove(aselected); // removing the appointment form the view list

           Main.getPatientByPPS(pps.getText()).vaccinationRecord.addElement(vr); // creating a vaccination centre from the appointment that has just been removed

           recordViewList.getItems().add(vr); // adding that appointment to a vaccination record view list
           System.out.println(vr + "\n" + "==================================================================" );




        }







    public void showAppointment(){
        appointmentViewList.getItems().clear(); // clear the list

        for(int i = 0 ; i < Main.ll.size() ; i++) { // Use a for loop to run over the vaccination centres
            VaccinationCentre centre = Main.ll.get(i);
            for (int j = 0 ; j < centre.booth.size(); j++){ // Use a for loop to run over the booths within that centre
                Booth booth = centre.booth.get(j);
                for(int k = 0 ; k < booth.appointment.size(); k++){ // Use a for loop to run over the appointments within a specific booth that's in a specific centre
                    appointmentViewList.getItems().add(booth.appointment.get(k));
                }


                }
            }
        }

    public void deleteAppointment(){
        int selectedList = appointmentViewList.getSelectionModel().getSelectedIndex(); // make a selectedList object
        Booth bselected = (Booth) boothBox.getSelectionModel().getSelectedItem(); // Cast in booth to to get the a booth from the booth list

        appointmentViewList.getItems().remove(selectedList); // remove the selected appoint from the appointment list
        bselected.appointment.delete(selectedList); // deleting the selected appointment from the specified booth


    }

    /** ======================================================================================================== */
    /**                                        Search                                                            */
    /** ======================================================================================================== */

    public void searchByBatchAndPPSN(){

        for(int i = 0 ; i < Main.getPl().size() ; i++) { // running over Patients with a for loop
            Patient selectedPatient = Main.pl.get(i); // Selecting a Patient for every Patient
            if(selectedPatient.vaccinationRecord != null){ // Checking if the selected Patient's record isn't null (Has a record)
                for(int j = 0 ; j < selectedPatient.vaccinationRecord.size() ; j++){ // Running over all selected patients records
                    VaccinationRecord selected = selectedPatient.vaccinationRecord.get(j); // Getting the vaccination record for that patient
                if(recordBatch.getText().equals(selected.getBatch()) || recordPPSN.getText().equals(selected.getPPSN())) {// Checking if the vaccination record match the batch of what was typed in the box
                    searchViewList.getItems().add(selected.toString()); // If so return this

                    System.out.println(selectedPatient.toString());



                }
                }
                }
            }
        }








    /** ======================================================================================================== */
    /**                                        Save / Load                                                       */
    /** ======================================================================================================== */


    public void save() throws Exception {
        XStream xStream = new XStream(new StaxDriver());
        xStream.allowTypes(new Class[]{myLinkedList.class});
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("VaccinationCentres.xml"));
        out.writeObject(Main.ll);
//        out.writeObject(Main.pl);

        out.close();
    }

    public void load() throws Exception {
        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[]{myLinkedList.class});
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("VaccinationCentres.xml"));

        Object obj=is.readObject();
        Main.ll = (myLinkedList<VaccinationCentre>) obj;
//        Main.pl = (myLinkedList<Patient>) is.readObject();

        is.close();


        // Saving to the XML

    }

    // SAVING IS WORKING BUT LOAD DOESN'T AND I DON'T KNOW WHY!

    /** ======================================================================================================== */
    /**                                        Reset                                                             */
    /** ======================================================================================================== */


    public void reset(ActionEvent event) {
        Main.ll.resetAll(); // using my reset all method to clear the vaccination list
        Main.pl.resetAll(); // using my reset all method to clear the patient list




        // Getting the items of every list view and clearing them
        // Setting the booth and appointment tab back to disabled when everything is reset
        viewList.getItems().clear();
        patientListView.getItems().clear();
        recordViewList.getItems().clear();
        appointmentViewList.getItems().clear();
        boothListView.getItems().clear();
        booth.setDisable(true);
        appointment.setDisable(true);
    }


}
