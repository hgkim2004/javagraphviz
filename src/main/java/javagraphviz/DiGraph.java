package javagraphviz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class DiGraph {

    String comment;
    List<Node> node_list = new ArrayList<Node>();
    List<Edge> edge_list = new ArrayList<Edge>();

    public DiGraph()
    {}
    
    public DiGraph(String comment)
    {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");

        for (Node node : node_list) {
            sb.append(String.format("\t%s [label=\"%s\"]\n", node.name, node.label));
        }
        
        for (Edge edge : edge_list) {
            sb.append(String.format("\t%s -> %s\n", edge.tail_name, edge.head_name));
        }       
        sb.append("}");
        return sb.toString();
    }

    public void node(String name, String label)
    {
        Node n = new Node(name, label);
        node_list.add(n);
    }

    public void edge(String tail_name, String head_name)
    {
        Edge e = new Edge(tail_name, head_name);
        edge_list.add(e);
    }
    
    public void render(String title)
    {
        render(title, false);
    }
    
    public void render(String title, Boolean view)
    {
        String tmpFilename = "tempfile";
//      try {
//          PrintWriter writer = new PrintWriter(tmpFilename);
//          writer.print(this.toString());
//          writer.close();
//      } catch (FileNotFoundException e) {
//          e.printStackTrace();
//      }
//      String line = String.format("dot -Tpng %s -o%s.png",
//              tmpFilename, title);
        
        File temp = null;;
        try {
            temp = File.createTempFile(tmpFilename, ".dot");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        String line = String.format("dot -Tpng %s -o%s.png",
                temp.getAbsolutePath(), title);
        
        CommandLine cmdLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        int exitValue = -1;
        try {
            exitValue = executor.execute(cmdLine);
        } catch (ExecuteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    
    
}
