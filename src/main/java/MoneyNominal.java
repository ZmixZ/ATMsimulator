public class MoneyNominal {

    private int moneyNominal;
    private String noZeroPoint;

    public int getMoneyNominal() {
        return moneyNominal;
    }

    public MoneyNominal withMoneyNominal(int moneyNominal) {
        this.moneyNominal = moneyNominal;
        return this;
    }
    public MoneyNominal withNoZeroPoint(String noZeroPoint) {
        this.noZeroPoint = noZeroPoint;
        return this;
    }

    }
