package algorithms.search;

import java.util.Comparator;

public class AStatePriorityCompare implements Comparator<AState> {
    public int compare(AState s1, AState s2){
        return (int) (s1.getCost() - s2.getCost());
    }
}
