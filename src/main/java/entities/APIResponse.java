package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {

    private List<VideoGame> results;

    public APIResponse() {
    }

    public List<VideoGame> getResults() {
        return results;
    }

    public void setResults(List<VideoGame> results) {
        this.results = results;
    }
}
