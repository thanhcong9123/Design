package Decorator;

public class BlackSugar extends MilkTeaDecorator {
    public BlackSugar(IMilkTea inner) {
        super(inner);
    }

    @Override
    public double Cost() {
        return 2.0 + super.Cost();
    }
}
