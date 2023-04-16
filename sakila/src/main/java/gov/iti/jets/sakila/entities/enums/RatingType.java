package gov.iti.jets.sakila.entities.enums;

public enum RatingType {

    G("G"),
    R("R"),
    PG("PG"),
    PG_13("PG-13"),
    NC_17("NC-17");
    private final String ratingType;
    RatingType(String ratingType) {
        this.ratingType = ratingType;
    }
    public String getRatingType() {
        return ratingType;
    }
}
