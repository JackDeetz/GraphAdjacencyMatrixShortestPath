
public class main {
    //static HashSet<String> combinations = new HashSet<>() ;
    public static void main(String[] args)
    {
        int array[][] = new int[11][11] ;

        for (int i = 1 ; i <= 10 ; i++)
        {
            for (int j = 1 ; j <= 10 ; j++)
            {
                array[i][j] = 0 ;
            }
        }

        Graph<Integer> g = new Graph<Integer>() ;
        array[0][0] = 0 ;

        g.addEdge(1,2, 8, true );
        g.addEdge(1,3, 13,true );
        g.addEdge(1,6, 14, true );
        g.addEdge(1,8, 8, true );
        g.addEdge(2,2, 2, true );
        g.addEdge(2,1, 8, true );
        g.addEdge(2,3, 9, true );
        g.addEdge(2,4, 12, true );
        g.addEdge(2,10, 11, true );
        g.addEdge(3,1, 13, true );
        g.addEdge(3,2, 9, true );
        g.addEdge(3,5, 13, true );
        g.addEdge(3,6, 15, true );
        g.addEdge(4,2, 12, true );
        g.addEdge(4,5, 19, true );
        g.addEdge(5,3, 13, true );
        g.addEdge(5,4, 19, true );
        g.addEdge(5,5, 6, true );
        g.addEdge(5,6, 15, true );
        g.addEdge(6,1, 14, true );
        g.addEdge(6,3, 15, true );
        g.addEdge(6,5, 15,true );
        g.addEdge(6,7, 22,true );
        g.addEdge(6,8, 18, true );
        g.addEdge(7,6, 22, true );
        g.addEdge(7,9, 21, true );
        g.addEdge(8,1, 8, true );
        g.addEdge(8,10, 8, true );
        g.addEdge(8,6, 18, true );
        g.addEdge(8,9, 10, true );
        g.addEdge(9,7, 21, true );
        g.addEdge(9,8, 10, true );
        g.addEdge(9,10, 12, true );
        g.addEdge(10,2, 11,true );
        g.addEdge(10,8, 8, true );
        g.addEdge(10,9, 12, true );

        g.getEdgesCount(true);
        g.getVertexCount();

        g.calculatePaths();

        System.out.println("The Shortest path:");
        System.out.println(g.ShortestPathData);
        System.out.println(g.ShortestPath + " total distance");





//        array[1][2] = 8 ;
//        array[1][3] = 13 ;
//        array[1][6] = 14 ;
//        array[1][8] = 8 ;
//        array[2][2] = 8 ;
//        array[2][2] = 8 ;
//        array[2][3] = 9 ;
//        array[2][4] = 12 ;
//        array[2][10] = 11 ;
//        array[3][1] = 13 ;
//        array[3][2] = 9 ;
//        array[3][5] = 13 ;
//        array[3][6] = 15 ;
//        array[4][2] = 12 ;
//        array[4][5] = 19 ;
//        array[5][3] = 13 ;
//        array[5][4] = 19 ;
//        array[5][5] = 6 ;
//        array[5][6] = 15 ;
//        array[6][1] = 14 ;
//        array[6][3] = 15 ;
//        array[6][5] = 15 ;
//        array[6][7] = 22 ;
//        array[6][8] = 18 ;
//        array[7][6] = 22 ;
//        array[7][9] = 21 ;
//        array[8][1] = 8 ;
//        array[8][6] = 18 ;
//        array[8][9] = 10 ;
//        array[9][7] = 21 ;
//        array[9][8] = 10 ;
//        array[9][10] = 12 ;
//        array[10][2] = 11 ;
//        array[10][8] = 8 ;
//        array[10][9] = 12 ;

//        ShortestPath t = new ShortestPath();
//        t.dijkstra(array, 0);


//        int arr[] = new int[11]  ;
//        for (int i = 0 ; i < arr.length ; i++)
//        {
//            arr[i] = -1 ;
//        }

//        traverse(array, 0, 0, arr) ;

    }

//    public static void traverse(int[][] array)
//    {
//        String path = "" ;
//        for (int i = 0 ; i < 11 ; i++)
//        {
//            for (int j = 0 ; j < 11 ; j++)
//            traverseHelper(array, i, j, path) ;
//        }
//    }
//
//    private static void traverseHelper(int[][] array, int i, int j, String path)
//    {
//        if (array[i][j] == -1)
//            return ;
//        path += "" + i + "-" + j + " ~ " + array[i][j] ;
//
//        for (int k = 0 ; k < 11 ; k++)
//        {
//                if (array[i][k] != -1)
//                {
//                    for (int g = 0 ; g < path.length() ; g++)
//                    {
//                        if (path.charAt(g) ==)
//                    }
//
//                    traverseHelper(array, i, j, path) ;
//                }
//        }
//
//
//
//    }
//    public static void traverse(int array[][], int i, int j, int arr[])
//    {
//        if (arr[9] != -1) //full path
//        {
//            int total = 0 ;
//            for (int k = 0 ; k < 10 ; k++)
//            {
//                total += arr[k] ;
//            }
//            String output = "" + total + " ~ " ;
//            for (int k = 0 ; k < 10 ; k++)
//            {
//                output += arr[k] + " " ;
//            }
//
//            combinations.add(output) ;
//            return ;
//        }
//
//        if (array[i][j] < 0)    //bad path
//        {
//            return ;
//        }
//        int index = -1 ;    //find index to add to arr
//        for (int p = 0 ; p < 10 ; p++)
//        {
//            if (arr[p] < 0 || arr[p]) {
//                index = p;
//                break ;
//            }
//        }
//        arr[index] = array[i][j] ;  //add vetted element to arr
//        for (int k = 1 ; k <= 10 ;k++)  //continue all possible branches
//        {
//            for (int p = 1 ; p <= 10 ; p++)
//            {
//
//                traverse(array, k, p, arr) ;
//            }
//        }
//
//    }
}
