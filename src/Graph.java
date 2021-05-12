import java.util.*;

public class Graph<T>
{
    private Map<T, List<Map<T, Integer>>> map = new HashMap<>() ;       //main data structure ~ a HashMap of T keys with lists(of HashMaps of T keys and Integer Values) Values
    public int ShortestPath = 10000 ;                                                                      //lists of hashmaps are a collections of Vertexes and their int weight values
    public String ShortestPathData = "" ;

    public void addVertex(T s)                          //a source/destination hub key is added to the HashMap, with a new LinkedList of HashMaps as it's value
    {
        map.put(s, new LinkedList< Map<T, Integer>>()) ;
    }
    public void addEdge(T source, T destination, int weight, boolean bidirectional)     //a connection between vertexes (edges) (weighted) (non-directional)
    {
        if (!map.containsKey(source))               //add all keys (vertexes) (destination hubs) that haven't been added
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);
        Map<T, Integer> pass = new HashMap<>() ;        //new hashmap value (destinations from this hub, and their int distance)
        pass.put(destination, weight) ;
        map.get(source).add(pass) ; //add the HashMap to Map key value's LinkedList of HashMaps with the new 'edge' (weighted)
        if (bidirectional)  //set up the same in reverse, because this is non-directional
        {
            Map<T, Integer> passInverse = new HashMap<>() ;
            pass.put(source, weight) ;
            map.get(destination).add(passInverse) ;
        }
    }

    public void getVertexCount()    //total hubs (vertexes
    {
        System.out.println("The graph has " + map.keySet().size() + " vertex") ;
    }

    public void getEdgesCount(boolean bidirection)      //returns the number of connections (edges) between vertexes
    {                                                   //bi-directional reflects if you want both ways counted
        int count = 0 ;
        for (T v : map.keySet())        //returns the number of HashMaps in all the LinkedLists of the outer Hashmap
        {
            count += map.get(v).size() ;
        }
        if (bidirection)
            count = count / 2 ;
        System.out.println("The graph has " + count + " edges.") ;
    }



    public void calculatePaths()    //prints each viable path from every starting location, and the shortest path
    {
        for (T v : map.keySet())                                //loop through each key (vertex) as a starting path point
        {
            LinkedHashMap<T, Integer> path = new LinkedHashMap<>() ;    //LinkedHashMap ~ maintains insertion order, allows collection of pairs of T(vertexes) and Ints(the distance of the path taken

            calculatePathsHelper(v, path) ; //call the helper with each vertex each with it's own path
        }
    }

    private void calculatePathsHelper(T v, LinkedHashMap<T, Integer> path)  //recursive helper function, traverse unique paths touching every vector only once, print viable paths,
    {                                                                                                               //and collect data for the ShortestPath Member Variables
        if (path.size() >= 10)          //successfull path (reached 10 unique vertexes only once, print results
        {
            System.out.print(" ~ " + path.toString());  //prints path
            int totalWeight = 0 ;
            for (T t : path.keySet())       //calculate the total distance traveled
                totalWeight += path.get(t) ;

            System.out.println(" ~ Total distance traveled ~ " + totalWeight);
            if (totalWeight < this.ShortestPath)    //if results are significant, record them
            {
                this.ShortestPath = totalWeight ;
                this.ShortestPathData = path.toString() ;
            }
            return ;
        }

        for (Map<T, Integer> g : map.get(v))                                  //for each hashmap that belong to this vertexes Linked List
        {
            for(T t : g.keySet())                                                   //and for each pair of destinations and distance (only 1)
            {
                LinkedHashMap<T, Integer> pathPasser  = new LinkedHashMap<>(path) ;     //new unique path(Linked Hash Map) copy old path to new
                if (!pathPasser.containsKey(t))      //if the element doesn't already exist in the path array
                {
                    pathPasser.put(t, g.get(t)) ;           //add key/value (destination and the distance there) to pathPasser
                    calculatePathsHelper(t, pathPasser) ;   //recursive call with each viable destination
                }

            }
        }
    }

}
