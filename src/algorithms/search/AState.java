package algorithms.search;

import java.util.Objects;

public class AState {
    private AState parent;
    private  Object state;
    double cost;

    public  AState(AState parent, double cost){
        this.parent = parent;
        this.cost = cost;
    }

    public  AState(Object s, double cost){
        this.state = s;
        this.cost = cost;
    }
    public AState getParent() {
        return parent;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setParent(AState parent) {
        this.parent = parent;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public boolean equals(Object o){
        boolean equal;
        if(o!= null && o.getClass() == this.getClass())
        {
            AState as = (AState) o;
            equal = (as.state.equals(this.state));
        }
        else if(o == this){
            equal = true;
        }
        else{
            equal = false;
        }
        return equal;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return "AState{" +
                "state=" + state +
                '}';
    }
}
