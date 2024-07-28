package Decorator;

public class EggPudding extends MilkTeaDecorator {
    public EggPudding(IMilkTea inner) {
        super(inner);
    }

    @Override
    public double Cost() {
        return 3.0 + super.Cost();
    }
}
