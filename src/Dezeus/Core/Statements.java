package Dezeus.Core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Statements implements Collection<Statement> {

    private Set<Statement> statements = new HashSet<>();

    public Statements() {
    }
    
    public Statements(Statement a) {
        statements.add(a);
    }
    
    public Statements(Statement a, Statement b) {
        statements.add(a);
        statements.add(b);
    }

    public Statements(Statement a, Statement b, Statement c) {
        statements.add(a);
        statements.add(b);
        statements.add(c);
    }

    // Implmentation

    @Override
    public int size() {
        return statements.size();
    }

    @Override
    public boolean isEmpty() {
        return statements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return statements.contains(o);
    }

    @Override
    public Iterator<Statement> iterator() {
        return statements.iterator();
    }

    @Override
    public Object[] toArray() {
        return statements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return statements.toArray(a);
    }

    @Override
    public boolean add(Statement e) {
        return statements.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return statements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return statements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Statement> c) {
        return statements.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return statements.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return statements.retainAll(c);
    }

    @Override
    public void clear() {
        statements.clear();
    }
}
