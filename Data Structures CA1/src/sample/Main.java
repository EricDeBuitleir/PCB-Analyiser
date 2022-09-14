package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class Main extends Application {


    public static myLinkedList<VaccinationCentre> ll = new myLinkedList<>();
    public static myLinkedList<Patient> pl = new myLinkedList<>();





    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader root = new FXMLLoader(Main.class.getResource("Add Vaccination Centre.fxml"));
        primaryStage.setTitle("Add Vaccination Centre");
        primaryStage.setScene(new Scene(root.load(), 300, 275));
        primaryStage.show();


    }

    // Need get patient list method, call it in intialize
    // Go through the entire list and get the toString of the list view


    public static myLinkedList<Patient> getPl() {
        return pl;
    }

    public static void main(String[] args) {

        launch(args);
    }

    public static Patient getPatientByPPS(String pps){
        for(int i = 0 ; i < pl.size() ; i++){
            if(pl.get(i).getPPSN().equalsIgnoreCase(pps))
            return pl.get(i);
        }
            return null;
        }

    }
