package functions;

import utility.ClosedInterval;

import java.util.List;

/**
 * Created by Denise Goldan on 10/6/2016.
 */
public interface Function {

    String getFunctionName();
    List<ClosedInterval> getVariablesDomain();
    double getCalculationResult(List<Double> variables);
}


