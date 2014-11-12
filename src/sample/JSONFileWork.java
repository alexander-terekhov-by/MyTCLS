package sample;

import com.google.gson.Gson;
import sample.model.Crossing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Александр on 12.11.2014.
 */
public class JSONFileWork
{
    private String filePath = "source.txt";
    Gson g = new Gson();

    public List<Crossing> readFile() {
        List <Crossing> result = new ArrayList<Crossing>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                Crossing specialist = g.fromJson(scanner.nextLine(), Crossing.class);
                result.add(specialist);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public void writeFile(Crossing toWriting) {
        System.out.println("Writing in file");
        System.out.println("Writing in file");
        System.out.println("Writing in file");
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(g.toJson(toWriting, Crossing.class) + "\r\n" );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

