package Dezeus.Core;

import java.io.IOError;
import java.nio.file.Path;

public class Theorem {
    
    private Proposition proposition;
    private Proof proof;

    public Theorem(Proposition proposition, Proof proof) {
        this.proposition = proposition;
        this.proof = proof;
    }

    public Theorem(Path path) {
        // TODO: Import theorem
    }

    public void saveToFile() throws IOError {
        // TODO: Save to file
    }

    // Getters

    public Proposition getProposition() {
        return proposition;
    }

    public Proof getProof() {
        return proof;
    }
}
