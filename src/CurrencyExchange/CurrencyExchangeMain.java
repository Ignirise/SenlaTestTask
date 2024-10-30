package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchangeMain {
    private static final double usd_to_eur = 0.92;
    private static final double usd_to_jpy = 153.22;
    private static final double usd_to_cny = 7.12;
    private static final double usd_to_rub = 97.03;
    private static final double usd_to_byn = 3.28;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите валюту для ввода (USD, EUR, JPY, CNY, RUB, BYN): ");
        String currency = scanner.nextLine().toUpperCase();

        System.out.println("Введите сумму в выбранной валюте: ");
        double amount = scanner.nextDouble();

        switch (currency) {
            case "USD":
                convertFromUSD(amount);
                break;
            case "EUR" :
                convertFromUSD(amount / usd_to_eur);
                break;
            case "JPY":
                convertFromUSD(amount / usd_to_jpy);
                break;
            case "CNY":
                convertFromUSD(amount / usd_to_cny);
                break;
            case "RUB":
                convertFromUSD(amount / usd_to_rub);
                break;
            case "BYN":
                convertFromUSD(amount / usd_to_byn);
                break;
            default:
                System.out.println("Неверная валюта.");
        }

        scanner.close();
    }

    private static void convertFromUSD(double usdAmount) {
        System.out.printf("Эквивалент в USD: %.2f%n", usdAmount);
        System.out.printf("Эквивалент в EUR: %.2f%n", usdAmount * usd_to_eur);
        System.out.printf("Эквивалент в JPY: %.2f%n", usdAmount * usd_to_jpy);
        System.out.printf("Эквивалент в CNY: %.2f%n", usdAmount * usd_to_cny);
        System.out.printf("Эквивалент в RUB: %.2f%n", usdAmount * usd_to_rub);
        System.out.printf("Эквивалент в BYN: %.2f%n", usdAmount * usd_to_byn);
    }
}
