package infin_bank.interview.figure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatedServiceImpl implements CalculatedService {
    @Autowired
    private Rectangle rectangle;
    @Autowired
    private Triangle triangle;
    @Autowired
    private Circle circle;

    public Map<String, Double> calculate(String figureType, Double a, Double b, Double c){
        Figure figure = createFigure(figureType);
        Map<String,Double> resultMap = new HashMap<>();

        double perimeter = figure.perimeter(a,b,c);
        resultMap.put("perimeter",perimeter);

        double area = figure.area(a,b,c);
        resultMap.put("area",area);

        return resultMap;
    }
    private Figure createFigure(String figureType){
        if (figureType.equalsIgnoreCase("rectangle")){
            return rectangle ;
        }
        else if (figureType.equalsIgnoreCase("square")){
            return rectangle;
        }
        else if (figureType.equalsIgnoreCase("triangle")){
            return triangle;
        }
        else if (figureType.equalsIgnoreCase("circle")){
            return circle;
        }
        else
        {
            throw new RuntimeException(figureType+"figureType in unknown");
        }
    }
}
