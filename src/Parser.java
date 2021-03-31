import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public List<List<Integer>> readFile() {
        List<List<Integer>> graphData = new ArrayList<>();
        List<Integer> innerGraphData;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String node = bufferedReader.readLine().trim();

            innerGraphData = new ArrayList<>();
            innerGraphData.add(Integer.parseInt(node));
            graphData.add(innerGraphData);

            String edges;
            while((edges = bufferedReader.readLine()) != null) {
                String [] spliter = edges.split(" ");
                innerGraphData = new ArrayList<>();
                for (String s : spliter) {
                    innerGraphData.add(Integer.parseInt(s));
                }
                graphData.add(innerGraphData);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graphData;
    }
}
