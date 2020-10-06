package infin_bank.interview.figure.service;

import org.springframework.stereotype.Service;

@Service
public class RectangleImpl implements Rectangle {
    @Override
    public double perimeter(double a, double b, double c) {
        return 2*(a+b);
    }

    @Override
    public double area(double a, double b, double c) {
        return a*b;
    }
}
