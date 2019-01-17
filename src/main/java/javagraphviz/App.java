package javagraphviz;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DiGraph dot = new DiGraph();
        
        dot.node("1", "CSTMesher2D");
        dot.node("2", "CSTSolver");
        dot.node("3", "CSTSolver");
        
        dot.edge("1", "2");
        dot.edge("1", "3");
        
//      System.out.println(dot.toString());
        
        dot.render("split_workflow");
    }
}
