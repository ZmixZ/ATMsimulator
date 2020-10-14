import java.io.*;
import java.util.*;

public class ATM{

    public static void main(String [] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<MoneyNominal> userMoney = new ArrayList<>();
        ArrayList<MoneyNominal> moneyInATM = new ArrayList<>();

        OperationSystem.generateATMContent(moneyInATM);

        OperationSystem.generateWalletContent(userMoney);

        LogicOfWork.mainLogic(rd, userMoney, moneyInATM);
    }

}
