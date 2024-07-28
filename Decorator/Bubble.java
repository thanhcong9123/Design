package Decorator;

public class Bubble extends MilkTeaDecorator {

    public Bubble(IMilkTea inner) {
        super(inner);
    }

    @Override
    public double Cost() {
        return 1.0 + super.Cost();
    }
}
