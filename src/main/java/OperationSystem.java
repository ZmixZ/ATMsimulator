import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class OperationSystem {
    public static void atmInformation(String s) {
        System.out.println(s);
    }

    public static int checkMoneyBalance(ArrayList<MoneyNominal> moneyInATM, int score, int i2) {
        for (MoneyNominal moneyNominal : moneyInATM) {
            if (moneyNominal.getMoneyNominal() == 5000) {
                score += moneyNominal.getMoneyNominal();
                if (score == i2) {
                    break;
                }
            } else if (!moneyInATM.contains(5000)) {
                score += moneyNominal.getMoneyNominal();
                if (score == i2) {
                    break;
                }
            }
        }
        return score;
    }

    public static int checkMoney(ArrayList<MoneyNominal> moneyInATM, int score) {
        score = checkMoneyBalance(moneyInATM, score, 20000);
        return score;
    }

    public static void withdrawMoney(ArrayList<MoneyNominal> userMoney, ArrayList<MoneyNominal> moneyInATM, int score1, int i2) {
        for (int i = moneyInATM.size(); i > 0; i--) {
            if (moneyInATM.get(i - 1).getMoneyNominal() == 5000) {
                userMoney.add(moneyInATM.get(i - 1));
                score1 += moneyInATM.get(i - 1).getMoneyNominal();
                moneyInATM.remove(i - 1);
                if (score1 == i2) {
                    break;
                }
            } else if (!moneyInATM.contains(5000)) {
                userMoney.add(moneyInATM.get(i - 1));
                score1 += moneyInATM.get(i - 1).getMoneyNominal();
                moneyInATM.remove(i - 1);
                if (score1 == i2) {
                    break;
                }
            }
        }
    }

    public static void generateATMContent(ArrayList<MoneyNominal> moneyInATM) {
        moneyInATM.add(new MoneyNominal().withNoZeroPoint("No money in case"));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(1000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(1000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(5000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(1000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(2000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(5000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(5000));
        moneyInATM.add(new MoneyNominal().withMoneyNominal(2000));

    }

    public static void generateWalletContent(ArrayList<MoneyNominal> userMoney) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/local.properties")));
        for(int i = 1; i < properties.size() + 1; i++){
            userMoney.add(new MoneyNominal().withMoneyNominal(Integer.parseInt(properties.getProperty("cash.number" + i))));
        }
    }

    public static void depositMoney(BufferedReader rd, ArrayList<MoneyNominal> userMoney, ArrayList<MoneyNominal> moneyInATM, int score) throws IOException {
        int moneyValue;
        atmInformation("Press 0 to end");
        moneyValue = Integer.parseInt(rd.readLine());
        while(moneyValue > 1 && moneyValue <= userMoney.size()){
            moneyInATM.add(userMoney.get(moneyValue));
            score += userMoney.get(moneyValue).getMoneyNominal();
            atmInformation("Deposit: " + score);
            userMoney.remove(moneyValue);
            moneyValue = Integer.parseInt(rd.readLine());
        }
    }

    public static void checkATMScore(ArrayList<MoneyNominal> moneyInATM) {
        int sum = 0;
        for(MoneyNominal q : moneyInATM){
            int nom = q.getMoneyNominal();
            sum += nom;
        }
        atmInformation("Balance: " + sum);
    }

    public static void checkUserWallet(ArrayList<MoneyNominal> userMoney) {
        int score2 = 0;
        for(int i = 0; i < userMoney.size(); i ++){
            System.out.println(i + " " + userMoney.get(i).getMoneyNominal());
            score2 += userMoney.get(i).getMoneyNominal();
        }
        atmInformation("Summary " + score2);
    }
}
