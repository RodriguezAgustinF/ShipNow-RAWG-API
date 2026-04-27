package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Platform {

    private Device platform;

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private Requirement requirements_en;

    public Platform() {
        requirements_en = new Requirement();
    }


    public Device getPlatform() {
        return platform;
    }

    public void setPlatform(Device platform) {
        this.platform = platform;
    }

    public Requirement getRequirements_en() {
        return requirements_en;
    }

    public void setRequirements_en(Requirement requirements_en) {
        this.requirements_en = requirements_en;
    }
}
