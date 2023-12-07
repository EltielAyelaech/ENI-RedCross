package fr.eni.ecole.redcross.bo;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicalFileHandler {
    private static ArrayList<MedicalFile> medicalFiles = new ArrayList<MedicalFile>();
    private static HashMap<Long, double[]> hashMap = new HashMap<Long, double[]>();;

    public static void add(MedicalFile file) {
        MedicalFileHandler.medicalFiles.add(file);
    }

    public static void displayList() {
        for (MedicalFile file : MedicalFileHandler.medicalFiles) {
            System.out.println(file);
        }
    }

    public static void updateRates() {
        // does jack s*** because ...? idk ? ask the PDF
    }

    public static void addMap() {
        for (MedicalFile file : MedicalFileHandler.medicalFiles) {
            long ssn = file.getPatient().getSocialSecurityNumber();
            double[] reimbursments = hashMap.get(ssn);
            double[] currentReimbursments = Payment.getReimbursments(file.getDoctor());

            if (reimbursments == null) {
                hashMap.put(ssn, currentReimbursments);
            } else {
                currentReimbursments[0] += reimbursments[0];
                currentReimbursments[1] += reimbursments[1];
                currentReimbursments[2] += reimbursments[2];
                currentReimbursments[3] += reimbursments[3];
                hashMap.put(ssn, currentReimbursments);
            }
        }
    }

    public static void displayMap() {
        hashMap.forEach(
            (Long ssn, double[] reimbursments) -> System.out.printf(
                "social security number: %d | CPAM total: %.3f - Mutual total: %.3f - Reminder total: %.3f - Rates total: %.3f\n",
                ssn,
                reimbursments[0],
                reimbursments[1],
                reimbursments[2],
                reimbursments[3]
            )
        );
    }
}
