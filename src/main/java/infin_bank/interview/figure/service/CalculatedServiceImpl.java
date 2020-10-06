package infin_bank.interview.figure.service;

import infin_bank.interview.figure.dto.request.FigureRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatedServiceImpl implements CalculatedService {
    private static Rectangle rectangle;
    private static Triangle triangle;
    private static Circle circle;

    public Map<String, Double> calculate(FigureRequestDTO figureRequestDTO){
        Figure figure = createFigure(figureRequestDTO.getFigureType());
        Map<String,Double> resultMap = new HashMap<>();

        double area = figure.area(
                figureRequestDTO.getA(),
                figureRequestDTO.getB(),
                figureRequestDTO.getC());

        resultMap.put("area",area);

        double perimeter = figure.perimeter(
                figureRequestDTO.getA(),
                figureRequestDTO.getB(),
                figureRequestDTO.getC());

        resultMap.put("perimeter",perimeter);

        return resultMap;
    }
    private static Figure createFigure(String figureType){
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
