import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public List<Integer> readFile() {
        List<Integer> graphData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String node = bufferedReader.readLine();
            graphData.add(Integer.parseInt(node));

            String edges = "";
            while((edges = bufferedReader.readLine()) != null) {
                String [] spliter = edges.split(" ");
                for (String s : spliter) {
                    graphData.add(Integer.parseInt(s));
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graphData;
    }
}
