package Decorator;

public class WhiteBubble extends MilkTeaDecorator {
    public WhiteBubble(IMilkTea inner) {
        super(inner);
    }

    @Override
    public double Cost() {
        return 1.5 + super.Cost();
    }
}
