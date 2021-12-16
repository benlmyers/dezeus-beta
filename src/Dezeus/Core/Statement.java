package Dezeus.Core;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import Dezeus.Logic.And;
import Dezeus.Logic.Bicond;
import Dezeus.Logic.Cond;
import Dezeus.Logic.Not;
import Dezeus.Logic.Or;
import Dezeus.Logic.TruthTable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sentential.class, name = "Sentential"),
        @JsonSubTypes.Type(value = And.class, name = "And"),
        @JsonSubTypes.Type(value = Bicond.class, name = "Bicond"),
        @JsonSubTypes.Type(value = Cond.class, name = "Cond"),
        @JsonSubTypes.Type(value = Not.class, name = "Not"),
        @JsonSubTypes.Type(value = Or.class, name = "Or"),
})
public abstract class Statement {

    public final Justification show(Deduction deduction) throws Invalidation {
        Deduction newDeduction = deduction.copy();
        newDeduction.depth += 1;
        Debug.log(empty(newDeduction.depth) + "SHOW " + this);
        return _show(newDeduction);
    }

    protected abstract Justification _show(Deduction deduction) throws Invalidation;

    @JsonIgnore
    public abstract Statements getComponents();

    @JsonIgnore
    public Set<Sentential> getSententials() {
        Statements components = getComponents();
        Set<Sentential> sententials = new HashSet<>();
        for (Statement component : components) {
            if (component instanceof Sentential sentential) {
                sententials.add(sentential);
            }
        }
        return sententials;
    }

    public int logicalSize() {
        return getComponents().logicalSize();
    }

    public int characteristicInt() {
        TruthTable truthTable = new TruthTable(this);
        return truthTable.characteristicInt();
    }

    public abstract boolean isTrue(Set<Sentential> provisions);

    public abstract String getStatementType();

    // Utility

    public And and(Statement b) {
        return new And(this, b);
    }

    public Or or(Statement b) {
        return new Or(this, b);
    }

    public Not not() {
        return new Not(this);
    }

    public Cond provided(Statement ant) {
        return new Cond(ant, this);
    }

    public Cond implies(Statement cons) {
        return new Cond(this, cons);
    }

    public Bicond iff(Statement b) {
        return new Bicond(this, b);
    }

    // Private Utility

    private static String empty(int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += " ";
        }
        return str;
    }
}