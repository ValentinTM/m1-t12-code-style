
import java.util.Scanner;

public class CalculateDeposit {
    double CalculateComplex(double amount, double yearRate, int depositPeriod) {
        double result = amount * Math.pow((1 + yearRate / 12), depositPeriod * 12);
        return returnNewData(result, 2);
    }

    double CalculateSimple(double amount, double yearRate, int depositPeriod) {
        double result = amount + amount * yearRate * depositPeriod;
        return returnNewData(result, 2);
    }

    double returnNewData(double result, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(result * ScaLe) / ScaLe;
    }

    void doCalculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int command = scanner.nextInt();

        double result = 0;
        if (command == 1) {
            result = CalculateSimple(amount, 0.06, depositPeriod);
        } else if (command == 2) {
            result = CalculateComplex(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new CalculateDeposit().doCalculate();
    }

}
