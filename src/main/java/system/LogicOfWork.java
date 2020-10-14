package system;

import model.MoneyNominal;

import java.io.*;
import java.util.ArrayList;

public class LogicOfWork {

    public static void mainLogic(BufferedReader rd, ArrayList<MoneyNominal> userMoney, ArrayList<MoneyNominal> moneyInATM) throws IOException {
        while (true) {
            new OperationSystem();
            OperationSystem.atmInformation("Hello, user! Select the option." +
                    " \n1. Withdraw money \n2. Deposit money \n3. View balance \n4. If you need look in your wallet");
            int choice = Integer.parseInt(rd.readLine());
            int score = 0;
            int score1 = 0;
            if (choice == 1) {
                OperationSystem.atmInformation("Enter the amount: \n1. 1000 \n2. 2000 " +
                        "\n3. 5000 \n4. 10000 \n5. 15000 \n6. 20000 \nPress 0 to end");
                choice = Integer.parseInt(rd.readLine());
                if (choice == 1) {
                    for (int i = 0; i < moneyInATM.size(); i++) {
                        if (moneyInATM.get(i).getMoneyNominal() == 1000) {
                            userMoney.add(moneyInATM.get(i));
                            moneyInATM.remove(i);
                            break;
                        } else if (moneyInATM.size() == 1) {
                            OperationSystem.atmInformation("No money");
                        }
                    }
                } else if (choice == 2) {
                    for (int i = 0; i < moneyInATM.size(); i++) {
                        if (moneyInATM.get(i).getMoneyNominal() == 2000) {
                            userMoney.add(moneyInATM.get(i));
                            moneyInATM.remove(i);
                            break;
                        } else if (moneyInATM.size() == 1) {
                            OperationSystem.atmInformation("No money");
                        }
                    }
                } else if (choice == 3) {
                    score = OperationSystem.checkMoneyBalance(moneyInATM, score, 5000);
                    if (score < 5000) {
                        OperationSystem.atmInformation("No money");
                    }

                    if (score == 5000) {
                        OperationSystem.withdrawMoney(userMoney, moneyInATM, score1, 5000);
                    }


                    score = 0;
                    score1 = 0;

                } else if (choice == 4) {
                    score = OperationSystem.checkMoneyBalance(moneyInATM, score, 10000);
                    if (score < 10000) {
                        OperationSystem.atmInformation("No money");
                    }

                    if (score == 10000) {
                        OperationSystem.withdrawMoney(userMoney, moneyInATM, score1, 10000);
                    }
                    score = 0;
                    score1 = 0;
                } else if (choice == 5) {
                    score = OperationSystem.checkMoneyBalance(moneyInATM, score, 15000);
                    if (score < 15000) {
                        OperationSystem.atmInformation("No money");
                    }

                    if (score == 15000) {
                        OperationSystem.withdrawMoney(userMoney, moneyInATM, score1, 15000);
                    }
                    score = 0;
                    score1 = 0;
                } else if (choice == 6) {
                    score = OperationSystem.checkMoney(moneyInATM, score);
                    if (score < 20000) {
                        OperationSystem.atmInformation("No money");
                    }

                    if (score == 20000) {
                        OperationSystem.withdrawMoney(userMoney, moneyInATM, score1, 20000);
                    }
                    score = 0;
                    score1 = 0;
                }
            } else if (choice == 2) {
                OperationSystem.depositMoney(rd, userMoney, moneyInATM, score);
            } else if (choice == 3) {
                OperationSystem.checkATMScore(moneyInATM);

            } else if (choice == 4) {
                OperationSystem.checkUserWallet(userMoney);
            }
        }
    }
}