package Dezeus.Logic;

import java.util.Set;

import Dezeus.Core.Statement;
import Dezeus.Utility.SetUtility;
import Dezeus.Core.Sentential;

public class TruthTable {

    private Statement statement;
    private TruthTableRow[] rows;

    public TruthTable(Statement statement) {
        this.statement = statement;
        Set<Sentential> sententials = statement.getSententials();
        Set<Set<Sentential>> conditions = SetUtility.getSubsets(sententials);
        int rowCount = conditions.size();
        this.rows = new TruthTableRow[rowCount];
        int index = 0;
        for (Set<Sentential> condition : conditions) {
            rows[index] = new TruthTableRow(condition, statement);
            index += 1;
        }
    }

    public int characteristicInt() {
        int total = 0;
        int value = 1;
        for (TruthTableRow row : rows) {
            if (row.isTrue())
                total += value;
            value *= 2;
        }
        return total - 1;
    }

    // Getters

    public Statement getStatement() {
        return statement;
    }

    public TruthTableRow[] getRows() {
        return rows;
    }

    public class TruthTableRow {

        private Set<Sentential> condition;
        private Statement statement;

        protected TruthTableRow(Set<Sentential> condition, Statement statement) {
            this.condition = condition;
            this.statement = statement;
        }

        public boolean isTrue() {
            return statement.isTrue(condition);
        }
    }
}
