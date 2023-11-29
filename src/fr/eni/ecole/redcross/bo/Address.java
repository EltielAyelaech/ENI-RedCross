package fr.eni.ecole.redcross.bo;

public class Address {
    private String addressComplement;
    private int streetNumber;
    private String streetComplement;
    private String streetName;
    private int postalCode;
    private String city;

    public Address(
        String addressComplement,
        int streetNumber,
        String streetComplement,
        String streetName,
        int postalCode,
        String city
    ) {
        this.addressComplement = addressComplement;
        this.streetNumber = streetNumber;
        this.streetComplement = streetComplement;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address(
        int streetNumber,
        String streetComplement,
        String streetName,
        int postalCode,
        String city
    ) {
        this(
            null,
            streetNumber,
            streetComplement,
            streetName,
            postalCode,
            city
        );
    }

    public void display() {
        System.out.printf(
            "%s%d%s %s\n%05d %s\n",
            this.addressComplement != null ? this.addressComplement + "\n" : "",
            this.streetNumber,
            this.streetComplement != null ? this.streetComplement : "",
            this.streetName,
            this.postalCode,
            this.city.toUpperCase()
        );
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetComplement() {
        return streetComplement;
    }

    public void setStreetComplement(String streetComplement) {
        this.streetComplement = streetComplement;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
