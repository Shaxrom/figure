package infin_bank.interview.figure.service;

import infin_bank.interview.figure.dto.request.FigureRequestDTO;

import java.util.Map;

public interface CalculatedService {
    Map<String, Double> calculate(FigureRequestDTO figureRequestDTO);
}
