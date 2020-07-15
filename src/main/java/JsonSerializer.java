import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import objects.Company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonSerializer {
    static Gson gson = new GsonBuilder()
            .setDateFormat("dd.MM.yyyy")
            .create();
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Company[] companiesSerialize(String source) {
        Company[] company = gson.fromJson(source, Company[].class);

        return company;
    }
}
