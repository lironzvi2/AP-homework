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
        while(end.getParent() != null) {
            solList.push(end.getParent());
            end = end.getParent();
        }
        ArrayList<AState> endingSol = new ArrayList<>();
        while(!solList.isEmpty()){
            endingSol.add(solList.pop());
        }
        return endingSol;
    }
}
