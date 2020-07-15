import objects.Company;
import objects.CurrencyType;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

public class InputHandler {

    public static void handle(String input, Company[] companies, BufferedReader bufferedReader) throws IOException {

        switch (input) {
            case "print":
                Company.printInfo(companies);
                break;
            case "print expired":
                Company.printExpired(companies);
                break;
            case "foundation date":
                System.out.println("Введите дату ('ДД.ММ.ГГГГ', 'ДД.ММ,ГГ', 'ДД/ММ/ГГГГ' и 'ДД/ММ/ГГ')");
                String stringDate = bufferedReader.readLine();
                try  {
                    Date foundationDate = new SimpleDateFormat("dd.MM.yyyy").parse(stringDate);
                    Company.printFoundation(companies, foundationDate);
                    break;
                } catch (ParseException e) {
                }
                try  {
                    Date foundationDate = new SimpleDateFormat("dd.MM.yy").parse(stringDate);
                    Company.printFoundation(companies, foundationDate);
                    break;
                } catch (ParseException e) {
                }
                try  {
                    Date foundationDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
                    Company.printFoundation(companies, foundationDate);
                    break;
                } catch (ParseException e) {
                }
                try  {
                    Date foundationDate = new SimpleDateFormat("dd/MM/yy").parse(stringDate);
                    Company.printFoundation(companies, foundationDate);
                    break;
                } catch (ParseException e) {
                }
                System.out.println("Не правильный формат ввода даты основания!");
                break;
            case "currency":
                System.out.println("Введите валюту (EU, USD, RUB)");
                CurrencyType currencyType = CurrencyType.RUB;
                try {
                    currencyType = CurrencyType.valueOf(bufferedReader.readLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Не правильный формат ввода валюты!");
                    break;
                }
                Company.printByCurrency(companies, currencyType);
                break;
            default:
                System.out.println("Введите одну из команд: print, print expired, foundation date, currency");
        }
    }
}
