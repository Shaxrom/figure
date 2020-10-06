package infin_bank.interview.figure.dto.responce;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class FigureResponseDTO {
    private Double area;
    private Double perimeter;


    public FigureResponseDTO(Map<String, Double> calculate) {
        this.area = calculate.get("area");
        this.perimeter = calculate.get("perimeter");
    }
}
