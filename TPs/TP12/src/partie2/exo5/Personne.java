package partie2.exo5;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Personne {

    private String name;
    private int age;
    private String country;

    Personne(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Personne [name=" + name + ", age=" + age + ", country=" + country + "]";
    }

    public static void main(String[] args) {

        try {

            CSVReader reader = new CSVReader(new FileReader("data.csv"), ',');

            String[] nextLine;
            List<Personne> personnes = new LinkedList<>();

            while ((nextLine = reader.readNext()) != null) {
                personnes.add(new Personne(nextLine[1], Integer.parseInt(nextLine[2]), nextLine[3]));
            }

            for (Personne p : personnes) {
                System.out.println(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
