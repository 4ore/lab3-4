import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public  class Graph {
    Scanner scan = new Scanner(System.in);
    public static HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
    public ArrayList<GN> id = new ArrayList<GN>();    
    public void vvod(String Noda) {       
            graph.put(Noda, new ArrayList<String>()); 
            id.add(new GN<String>(Noda));        
    }    
    public boolean poverkaNod(String Noda) {
        return graph.containsKey(Noda);
    }    
    public boolean konec(String Noda1, String Noda2) {
        if (!poverkaNod(Noda1)) return false;
        List<String> edges = graph.get(Noda1);
        return Collections.binarySearch(edges, Noda2) != -1;
    }
    public void vvod(String Noda1, String Noda2) {
        if(!konec(Noda1,Noda2)){
        if (!poverkaNod(Noda1)) {vvod(Noda1);
        id.add(new GN<String>(Noda1));}
        if (!poverkaNod(Noda2)) {vvod(Noda2);
        id.add(new GN<String>(Noda2));}
        List<String> kray1 = graph.get(Noda1);
        List<String> kray2 = graph.get(Noda2);
        kray1.add(Noda2);
        kray2.add(Noda1);
        Collections.sort(kray1);
        Collections.sort(kray2);
    }}  
    public void vuvod(){
        for (Map.Entry entry : graph.entrySet()) {
            System.out.println("vershina: " + entry.getKey() + " zvyazana z "
                    + entry.getValue());
        }

    }
    public void poisk() {
        int k = scan.nextInt();
        System.out.println("vershina z id "+k+": "+id.get(k-1).getob());
    }

}