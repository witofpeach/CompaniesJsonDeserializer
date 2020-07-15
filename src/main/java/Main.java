import objects.Company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String path = "src/main/resources/companies.json";

        String jsonSource = Files.readString(Paths.get(path));

        Company[] companies = JsonSerializer.companiesSerialize(jsonSource);

        System.out.println("Введите одну из команд: print, print expired, foundation date, currency");

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("stop"))
                break;
            InputHandler.handle(input, companies, bufferedReader);
        }

    }
}
