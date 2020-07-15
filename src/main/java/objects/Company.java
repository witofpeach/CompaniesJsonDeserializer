package objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.CheckedOutputStream;

public class Company {
    String name;
    String address;
    String phoneNumber;
    String INN;
    String OGRN;
    Date foundationDate;
    Security[] securities;
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private class Security {
        String id;
        CurrencyType currencyType;
        Date expireDate;
        String ownerName;

        @Override
        public String toString() {
            return "Ценная бумага: \n" +
                    "id: " + id +
                    "\nВалюта: " + currencyType +
                    "\nДата истечения срока: " + dateFormat.format(expireDate) +
                    "\nИмя владельца: " + ownerName + "\n";
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Securities: \n");

        for (Security security : securities) {
            stringBuilder.append(security.toString());
        }

        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", INN='" + INN + '\'' +
                ", OGRN='" + OGRN + '\'' +
                ", foundationDate=" + foundationDate +
                ", security=" + stringBuilder.toString() +
                '}';
    }

    public static void printInfo(Company[] companies) {
        for (Company company : companies) {
            System.out.println("Название организации: " + company.name + " -- Дата основания: " + dateFormat.format(company.foundationDate));
        }
    }

    public static void printExpired(Company[] companies) {
        int expiredTotal = 0;
        boolean check = false;

        for (Company company : companies) {
            for (Security security : company.securities) {
                if (security.expireDate.before(Date.from(Instant.now()))) {
                    expiredTotal++;
                    System.out.println(security.toString());
                    check = true;
                }
            }
        }

        if (!check)
            System.out.println("По заданным параметрам организаций не найдено!");

        System.out.println("Всего просроченных ценных бумаг: " + expiredTotal);
    }

    public static void printFoundation(Company[] companies, Date foundationDate) {
        boolean check = false;

        for (Company company : companies) {
            if (company.foundationDate.after(foundationDate)) {
                System.out.println("Название организации: " + company.name + " -- Дата основания: " + dateFormat.format(company.foundationDate));
                check = true;
            }
        }

        if (!check)
            System.out.println("По заданным параметрам организаций не найдено!");
    }

    public static void printByCurrency(Company[] companies, CurrencyType currencyType) {
        boolean check = false;

        for (Company company : companies) {
            for (Security security : company.securities) {
                if (security.currencyType == currencyType) {
                    System.out.println(security.toString());
                    check = true;
                }
            }
        }

        if (!check)
            System.out.println("По заданным параметрам ценных бумаг не найдено!");
    }
}
