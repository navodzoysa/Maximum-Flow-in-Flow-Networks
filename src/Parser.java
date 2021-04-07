/* *****************************************************************************
 *  Name:    Navod Zoysa
 *  UoW ID:  w1761781
 *  IIT ID:  2015154
 *
 *  Description:  Parses the input files into an arraylist of integers.
 *
 *  Written:       08/04/2021
 **************************************************************************** */

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
            System.out.println("Flow network from " + fileName.substring(14) + " parsed and loaded succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graphData;
    }
}
