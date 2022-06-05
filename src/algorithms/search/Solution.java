package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution implements Serializable {
    AState end;
    ArrayList<AState> solPath;

    public Solution(AState s){
        this.end = s;
    }

    public Solution(ArrayList<AState> solPath){
        solPath = this.solPath;
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
        this.solPath = endingSol;
        return endingSol;
    }
}
