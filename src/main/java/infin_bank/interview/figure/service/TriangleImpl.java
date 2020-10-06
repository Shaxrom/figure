package infin_bank.interview.figure.service;

import org.springframework.stereotype.Service;

@Service
public class TriangleImpl implements Triangle {
    @Override
    public double perimeter(double a, double b, double c) {
        return a+b+c;
    }

    @Override
    public double area(double a, double b, double c) {
        double p = perimeter(a, b, c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
