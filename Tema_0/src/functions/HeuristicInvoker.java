package functions;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class HeuristicInvoker {

    private int numberOfTries;

    private MinimumFinder minimumFinder;

    public void applyHeuristic(Function function, int desiredNumberOfVariables, int desiredNumberOfTries){
        setNumberOfTries(desiredNumberOfTries);
        minimumFinder = new MinimumFinder();
        for (int i = 0; i < numberOfTries; i++) {
            minimumFinder.searchBestSolution(function, desiredNumberOfVariables);
        }
    }

    private void setNumberOfTries(int desiredNumberOfTries){
        if (desiredNumberOfTries <= 0){
            throw new AssertionError("The number of tries must be greater than 0.");
        }
        numberOfTries = desiredNumberOfTries;
    }

    public MinimumFinder getMinimumFinder() {
        return minimumFinder;
    }


}
