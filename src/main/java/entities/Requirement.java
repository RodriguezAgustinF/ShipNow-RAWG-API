package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Requirement {

    private String minimum = "N/A";

    public Requirement() {
    }

    public String getMinimum() {
        return minimum;
    }

    @JsonSetter(nulls = Nulls.SKIP)
    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }


}
