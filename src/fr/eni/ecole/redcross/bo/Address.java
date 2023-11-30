package fr.eni.ecole.redcross.bo;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

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
    ) throws UserException, ProgrammerException {
        this.setAddressComplement(addressComplement);
        this.setStreetNumber(streetNumber);
        this.setStreetComplement(streetComplement);
        this.setStreetName(streetName);
        this.setPostalCode(postalCode);
        this.setCity(city);
    }

    public Address(
        int streetNumber,
        String streetComplement,
        String streetName,
        int postalCode,
        String city
    ) throws UserException, ProgrammerException {
        this(
            null,
            streetNumber,
            streetComplement,
            streetName,
            postalCode,
            city
        );
    }

    @Override
    public String toString() {
        if (this.addressComplement != null) {
            return String.format(
                String.join("\n",
                    "%s",
                    "%d%s %s",
                    "%05d %s"
                ),
                this.addressComplement,
                this.streetNumber,
                this.streetComplement != null ? this.streetComplement : "",
                this.streetName,
                this.postalCode,
                this.city
            );
        }
        return String.format(
            String.join("\n",
                "%d%s %s",
                "%05d %s"
            ),
            this.streetNumber,
            this.streetComplement != null ? this.streetComplement : "",
            this.streetName,
            this.postalCode,
            this.city
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

    public void setStreetNumber(int streetNumber) throws UserException {
        if (streetNumber < 0) throw new UserException("the street number must be strictly positive");

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

    public void setStreetName(String streetName) throws UserException {
        if (streetName == null || streetName.equals("")) throw new UserException("the street name is mandatory");

        this.streetName = streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) throws UserException {
        if (postalCode < 1000 || postalCode > 99999) throw new UserException("the postal code must be comprised between 1000 and 99999");

        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws UserException {
        if (city == null || city.equals("")) throw new UserException("the city is mandatory");

        this.city = city;
    }
}
