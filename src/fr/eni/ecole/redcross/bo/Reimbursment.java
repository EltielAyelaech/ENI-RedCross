package fr.eni.ecole.redcross.bo;

public enum Reimbursment {
    TFC,
    TVC,
    NC;

    public double getRates() {
        switch (this) {
            case TFC:
                return 1;
            case TVC:
                return 0.5;
            default:
                return 0;
        }
    }

    public String getLabel() {
        switch (this) {
            case TFC:
                return "Tarif fixe conventionné";
            case TVC:
                return "Tarif variable conventionné";
            default:
                return "Non conventionné";
        }
    }
}
