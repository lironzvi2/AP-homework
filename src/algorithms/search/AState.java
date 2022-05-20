package algorithms.search;

public class AState {
    private AState parent;
    private  Object state;
    int cost;

    public  AState(AState parent, int cost){
        this.parent = parent;
        this.cost = cost;
    }

    public  AState(Object s, int cost){
        this.state = s;
        this.cost = cost;
    }
    public AState getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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

}
