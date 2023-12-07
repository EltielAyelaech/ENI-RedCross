package fr.eni.ecole.redcross.bo;

public class Payment {
    private static double clamp(double number, double min, double max) {
        if (number <= min) {
            return min;
        }
        if (number >= max) {
            return max;
        }
        return number;
    }

    public void reminderToBePaid(Doctor doctor) {
        double cpamReimbursment = doctor.getReimbursment().getRates() * doctor.getRates();
        double mutualReimbursment = doctor.getReimbursment().getMutualRates() * doctor.getRates();

        String format = String.format(
            "CPAM reimbursment: %.1f - Mutual reimbursment: %.1f - Reminder to be paid: %.1f",
            Payment.clamp(cpamReimbursment, 0, doctor.getRates()),
            Payment.clamp(mutualReimbursment, 0, doctor.getRates() - cpamReimbursment),
            Payment.clamp(doctor.getRates() - cpamReimbursment - mutualReimbursment, 0, doctor.getRates() - cpamReimbursment - mutualReimbursment)
        );

        System.out.println(format);
    }
}