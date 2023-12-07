package fr.eni.ecole.redcross.bo;

public enum Specialty {
    ORL,
    CARDIO,
    OPHTALMO,
    ANGIO;

    public String getLabel() {
        switch (this) {
            case ORL:
                return "Orl";
            case CARDIO:
                return "Cardiologie";
            case OPHTALMO:
                return "Ophtalmologie";
            default:
                return "Unimplemented";
        }
    }

    public String getLocation() {
        switch (this) {
            case ORL:
                return "Aile sud";
            case CARDIO:
                return "Aile nord";
            case OPHTALMO:
                return "Aile sud";
            default:
                return "Unimplemented";
        }
    }
}
