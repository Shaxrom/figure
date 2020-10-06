package infin_bank.interview.figure.controller;

import infin_bank.interview.figure.dto.request.FigureRequestDTO;
import infin_bank.interview.figure.dto.responce.FigureResponseDTO;
import infin_bank.interview.figure.service.CalculatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/figure/")
public class FigureController {

    @Autowired
    private CalculatedService calculatedService;

    @GetMapping
    @ResponseBody
    public FigureResponseDTO getFigureParameter(FigureRequestDTO figureRequestDTO){
        return new FigureResponseDTO(calculatedService.calculate(figureRequestDTO));
    }
}
