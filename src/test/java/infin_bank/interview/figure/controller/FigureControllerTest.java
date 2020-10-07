package infin_bank.interview.figure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import infin_bank.interview.figure.core.SpringMockWebEnvTestConfigController;
import infin_bank.interview.figure.dto.responce.FigureResponseDTO;
import infin_bank.interview.figure.service.CalculatedService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringMockWebEnvTestConfigController
class FigureControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CalculatedService calculatedService;

    private FigureResponseDTO figureResponseDTO;
    private Map<String,Double> resultMap = new HashMap<>();
    private final String figureType = "triangle";
    private final Double a = 3.0;
    private final Double b = 4.0;
    private final Double c = 5.0;


    @BeforeEach
    void setUp(){
        figureResponseDTO = new FigureResponseDTO();
        figureResponseDTO.setArea(6.0);
        figureResponseDTO.setPerimeter(12.0);

        when(calculatedService.calculate(figureType,a,b,c)).thenReturn(new HashMap<>(Map.of("area",6.0,"perimeter",12.0)));
    }

    @Test
    void testGetFigureParameter() throws Exception{
        this.mockMvc.perform(get("/api/figure")
                .param("figureType",figureType)
                .param("a",a.toString())
                .param("b",b.toString())
                .param("c",c.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(FigureController.class))
                .andExpect(handler().method(FigureController.class.getMethod("getFigureParameter", String.class, Double.class, Double.class, Double.class)))
                .andExpect(jsonPath("$.area").value(figureResponseDTO.getArea()))
                .andExpect(jsonPath("$.perimeter").value(figureResponseDTO.getPerimeter()));
        verify(calculatedService).calculate(any(String.class), any(Double.class), any(Double.class), any(Double.class));
    }

}