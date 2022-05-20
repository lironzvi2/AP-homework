package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution{
    AState end;

    public Solution(AState s){
        this.end = s;
    }

    public ArrayList<AState> getSolutionPath(){
        Stack<AState> solList = new Stack<>();
        AState end = this.end;
        solList.add(end);
        int howManyParents = 0;
        while(end.getParent() != null) {
            solList.add(end.getParent());
            end = end.getParent();
            howManyParents++;
        }
        ArrayList<AState> endingSol = new ArrayList<>();
        for(int i =howManyParents; i >= 0 ; i--){
            endingSol.add(solList.get(i));
        }
        return endingSol;
    }
}
