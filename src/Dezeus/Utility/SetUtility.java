package Dezeus.Utility;

import java.util.HashSet;
import java.util.Set;

public class SetUtility {
    
    public static <T> Set<Set<T>> getSubsets(Set<T> original) {
        Set<Set<T>> allSubsets = new HashSet<>();
        allSubsets.add(new HashSet<>()); // Add empty set.
        for (T element : original) {
            Set<Set<T>> tempClone = new HashSet<>(allSubsets);
            for (Set<T> subset : tempClone) {
                Set<T> extended = new HashSet<>(subset);
                extended.add(element);
                allSubsets.add(extended);
            }
        }
        return allSubsets;
    }
}
