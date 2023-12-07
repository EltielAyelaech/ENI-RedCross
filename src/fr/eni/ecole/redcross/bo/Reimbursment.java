package fr.eni.ecole.redcross.bo;

public enum Reimbursment {
    TFC("tfc", 1f),
    TFCM1("tfc m1", TFC, 1f * TFC.getRates()),
    TFCM2("tfc m2", TFC, 1f * TFC.getRates()),
    TVC("tvc", 0.5f),
    TVCM1("tvc m1", TVC, 0.5f * TVC.getRates()),
    TVCM2("tvc m2", TVC, 0.75f * TVC.getRates()),
    NC("nc", 0f),
    NCM1("nc m1", NC, 0),
    NCM2("nc m2", NC, 0.5f);

    private String label;
    private double rates;
    private Reimbursment parent = null;

    private Reimbursment(String label, double rates) {
        this(label, null, rates);
    }

    private Reimbursment(String label, Reimbursment parent, double rates) {
        this.setLabel(label);
        this.setParent(parent);
        this.setRates(rates);
    }

    private void setLabel(String label) { this.label = label; }
    private void setRates(double rates) { this.rates = rates; }
    private void setParent(Reimbursment parent) { this.parent = parent; }

    public String getLabel() { return this.label; }
    public double getRates() { return this.rates; }
    public Reimbursment getParent() { return this.parent; }
}
