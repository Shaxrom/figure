package infin_bank.interview.figure.service;

import org.springframework.stereotype.Service;

@Service
public class CircleImpl implements Circle {
    @Override
    public double perimeter(double a, double b, double c) {
        return (2*Math.PI*a);
    }

    @Override
    public double area(double a, double b, double c) {
        return  (Math.PI*a*a);
    }
}
