package Decorator;

public class MainRun {
    public static void main(String[] args) {
        var firstMilkTea = new EggPudding(
                                new FruitPudding(
                                        new BlackSugar(
                                            new Bubble(
                                                new MilkTea()))));
        System.out.println("EggPuddingAndFruitPuddingBlackSugarBubbleMilkTea:\t"
                + firstMilkTea.Cost());

        var secondMilkTea = new EggPudding(
                new BlackSugar(
                        new WhiteBubble(
                                new MilkTea())));
        System.out.println("EggPuddingBlackSugarWhiteBubbleMilkTea:\t"
                + secondMilkTea.Cost());
    }
}
