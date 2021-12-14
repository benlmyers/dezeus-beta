package Dezeus.Core;

import java.io.File;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class Theorem {

    private Proposition proposition;
    private Justification proof;

    public Theorem(Proposition proposition, Justification proof) {
        this.proposition = proposition;
        this.proof = proof;
    }

    public Theorem() throws Exception {
        JsonMapper mapper = new JsonMapper();
        mapper.readValue(correspondingFile(), this.getClass());
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
}
