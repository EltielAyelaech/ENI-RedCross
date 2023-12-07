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
        double cpamReimbursment;
        double mutualReimbursment;

        if (doctor.getReimbursment().getParent() != null) {
            cpamReimbursment = doctor.getReimbursment().getParent().getRates() * doctor.getRates();
            mutualReimbursment = doctor.getReimbursment().getRates() * doctor.getRates();
        } else {
            cpamReimbursment = doctor.getReimbursment().getRates();
            mutualReimbursment = 0;
        }

        String format = String.format(
            "CPAM reimbursment: %.1f - Mutual reimbursment: %.1f - Reminder to be paid: %.1f",
            Payment.clamp(cpamReimbursment, 0, doctor.getRates()),
            Payment.clamp(mutualReimbursment, 0, doctor.getRates() - cpamReimbursment),
            Payment.clamp(doctor.getRates() - cpamReimbursment - mutualReimbursment, 0, doctor.getRates() - cpamReimbursment - mutualReimbursment)
        );

        System.out.println(format);
    }

    public static String reminderToBePaidToString(Doctor doctor) {
        double cpamReimbursment;
        double mutualReimbursment;

        if (doctor.getReimbursment().getParent() != null) {
            cpamReimbursment = doctor.getReimbursment().getParent().getRates() * doctor.getRates();
            mutualReimbursment = doctor.getReimbursment().getRates() * doctor.getRates();
        } else {
            cpamReimbursment = doctor.getReimbursment().getRates();
            mutualReimbursment = 0;
        }

        String format = String.format(
            "CPAM reimbursment: %.1f - Mutual reimbursment: %.1f - Reminder to be paid: %.1f",
            Payment.clamp(cpamReimbursment, 0, doctor.getRates()),
            Payment.clamp(mutualReimbursment, 0, doctor.getRates() - cpamReimbursment),
            Payment.clamp(doctor.getRates() - cpamReimbursment - mutualReimbursment, 0, doctor.getRates() - cpamReimbursment - mutualReimbursment)
        );

        return format;
    }

    public static double[] getReimbursments(Doctor doctor) {
        double[] reimbursments = new double[4];
        double cpamReimbursment;
        double mutualReimbursment;

        if (doctor.getReimbursment().getParent() != null) {
            cpamReimbursment = doctor.getReimbursment().getParent().getRates() * doctor.getRates();
            mutualReimbursment = doctor.getReimbursment().getRates() * doctor.getRates();
        } else {
            cpamReimbursment = doctor.getReimbursment().getRates();
            mutualReimbursment = 0;
        }

        cpamReimbursment = Payment.clamp(cpamReimbursment, 0, doctor.getRates());
        mutualReimbursment = Payment.clamp(mutualReimbursment, 0, doctor.getRates() - cpamReimbursment);
        double reminder = Payment.clamp(doctor.getRates() - cpamReimbursment - mutualReimbursment, 0, doctor.getRates() - cpamReimbursment - mutualReimbursment);
        
        reimbursments[0] = cpamReimbursment;
        reimbursments[1] = mutualReimbursment;
        reimbursments[2] = reminder;
        reimbursments[3] = doctor.getRates();

        return reimbursments;
    }
}
