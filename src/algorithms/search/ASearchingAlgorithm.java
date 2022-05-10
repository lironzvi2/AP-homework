package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    int nodesEvaluated;
    String mazeName;

    @Override
    public abstract Solution solve(ISearchable maze);

    @Override
    public abstract String getName();

    @Override
    public int getNumberOfNodesEvaluated(){
        return nodesEvaluated;
    }
}
