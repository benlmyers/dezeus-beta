package Dezeus.Core;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class Theorem {

    private Proposition proposition;
    private Justification proof;

    private String name;

    @JsonCreator
    public Theorem(
            @JsonProperty("name") String name,
            @JsonProperty("proposition") Proposition proposition,
            @JsonProperty("proof") Justification proof) {
        this.name = name;
        this.proposition = proposition;
        this.proof = proof;
    }

    public Theorem(Proposition proposition, Justification proof) {
        this(null, proposition, proof);
    }

    public static Theorem load(File file) throws Exception {
        JsonMapper mapper = new JsonMapper();
        Theorem theorem = mapper.readValue(file, Theorem.class);
        return theorem;
    }

    public void saveToFile() throws Exception {
        JsonMapper mapper = new JsonMapper();
        if (!correspondingFile().exists())
            correspondingFile().createNewFile();
        mapper.writerWithDefaultPrettyPrinter().writeValue(correspondingFile(), this);
    }

    private File correspondingFile() {
        return new File("resources/theorems/test.json");
    }

    // Getters

    public Proposition getProposition() {
        return proposition;
    }

    public Justification getProof() {
        return proof;
    }

    public String getName() {
        return name;
    }
}
