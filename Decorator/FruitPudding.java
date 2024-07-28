package Decorator;

public class FruitPudding extends MilkTeaDecorator {
    public FruitPudding(IMilkTea inner) {
        super(inner);
    }

    @Override
    public double Cost() {
        return 3.0 + super.Cost();
    }
}
