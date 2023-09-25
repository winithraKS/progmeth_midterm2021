package disease;

import util.Patient;
import util.SevereLevel;

import java.util.ArrayList;

public class Hospital {
    private ArrayList<Patient> patients;

    public Hospital() {
        patients = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
    public void admit(String firstname,String lastname,String id,String disease,boolean isVacinated){
        Disease d = null;
        switch (disease){
            case "Hypopnea" -> {d = new Hypopnea(); break;}
            case "Covid19" -> {d = new Covid19(); break;}
            case "Delta" -> {d = new Delta(); break;}
            default -> {break;}
        }
        Patient p = new Patient(firstname,lastname,id,d,isVacinated);
        patients.add(p);
    }
    public ArrayList<Patient> getCovidPatients(SevereLevel s){
        ArrayList<Patient> ap = new ArrayList<Patient>();
        for(Patient p : patients){
            if(p.getDisease().toString() == "Covid19" || p.getDisease().toString()=="Delta") {
                if(p.getDisease().getSevereLevel(p.isVaccinated()) == s) ap.add(p);
            }
        }
        return ap;
    }
}
