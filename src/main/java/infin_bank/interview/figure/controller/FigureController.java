package infin_bank.interview.figure.controller;

import infin_bank.interview.figure.dto.responce.FigureResponseDTO;
import infin_bank.interview.figure.service.CalculatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/figure")
public class FigureController {

    @Autowired
    private CalculatedService calculatedService;

    @GetMapping
    @ResponseBody
    public FigureResponseDTO getFigureParameter(
            @RequestParam(name = "figureType") String figureType,
            @RequestParam(name = "a") Double a,
            @RequestParam(name = "b", required = false, defaultValue = "0") Double b,
            @RequestParam(name = "c", required = false, defaultValue = "0") Double c){
        return new FigureResponseDTO(calculatedService.calculate(figureType,a,b,c));
    }
}
