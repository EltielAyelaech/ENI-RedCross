package fr.eni.ecole.redcross.bo;

public enum Reimbursment {
    TFC,
    TVC,
    NC,
    TFCM1,
    TFCM2,
    TVCM1,
    TVCM2,
    NCM1,
    NCM2;

    public double getRates() {
        switch (this) {
            case TFC:
            case TFCM1:
            case TFCM2:
                return 1;
            case TVC:
            case TVCM1:
            case TVCM2:
                return 0.5;
            case NC:
            case NCM1:
            case NCM2:
                return 0;
            default:
                return -1;
        }
    }

    public double getMutualRates() {
        switch (this) {
            case TFCM1:
                return 1 * TFC.getRates();
            case TFCM2:
                return 1 * TFC.getRates();
            case TVCM1:
                return 0.5 * TVC.getRates();
            case TVCM2:
                return 0.75 * TVC.getRates();
            case NCM1:
                return 0 * NC.getRates();
            case NCM2:
                return 0.5;
            default:
                return -1;
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
