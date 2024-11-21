import java.util.Scanner;
public class djikstra {
    public static void calculateShortestPath(int[][] graph,int nodes,int src)
    {
        int dist[]= new int[nodes];
        boolean visited[] = new boolean[nodes];

        for(int i =0 ;i<nodes ; i++)
        {
            dist[i]=Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;

        System.out.println("OK");
        for(int i = 0;i<nodes -1;i++)
        {

            int u = minDistance(dist,visited,nodes);

            visited[u] = true;

            for(int j=0;j<nodes ;j++)
            {
                if(!visited[j] && graph[u][j]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j])
                {
                    dist[j] = dist[u] + graph[u][j];
                }

            }
        }
        System.out.println("Vertex             Distance From Source");

        for(int i =0;i< nodes;i++)
        {
            System.out.println(i+"              "+dist[i]);
        }

    }

    public static void printsolution(int[][] graph,int nodes)
    {

        for(int i = 0;i<nodes ;i++)
        {
            for(int j =0;j<nodes ;j++)
            {
                System.out.print(graph[i][j]);

            }
            System.out.println();
        }
    }


    public static int minDistance(int[] dist,boolean[] visited,int nodes)
    {
        int min = Integer.MAX_VALUE,min_index = -1;
        for(int i =0;i<nodes;i++)
        {
            if(!visited[i] && min >= dist[i])
            {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }


    public static void main(String[] args) {
        int nodes;
        System.out.println("Enter number of Nodes : ");
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        System.out.println("Entre the source: ");
        int src = sc.nextInt();

        int graph[][]= new int[nodes][nodes];
        System.out.println("Entre the graph matrix of "+ nodes);
        for(int i = 0;i<nodes ;i++)
        {
            for(int j =0;j<nodes ;j++)
            {
                //System.out.print("Enter cost between " + i +"and" +j);
                graph[i][j]=sc.nextInt();
            }
        }

        calculateShortestPath(graph,nodes,src);
    }
}

































//import java.util.Scanner;
//public class djikstra {
//public static void calshortestpath(int [][] graph,int nodes ,int src )
//{
//    int dist[] = new int[nodes];
//    boolean visited[] = new boolean[nodes];
//    for(int i = 0 ;i<nodes;i++)
//    {
//        dist[i]=Integer.MAX_VALUE;
//        visited[i]=false;
//    }
//    dist[src]=0;
//    for (int i = 0 ;i<nodes;i++)
//    {
//        int u = mindistance(dist,visited,nodes);
//        visited[u]=true ;
//        for (int j =0;j<nodes;j++)
//        {
//            if(!visited[j] && (graph[u][j] != 0) && dist[u] ! =Integer.MAX_VALUE && dist[u]+graph[u][j]>dist[j])
//            {
//                dist[j]=dist[u]+graph[u][j];
//            }
//
//        }
//    } System.out.println("vertex            dist from source");
//    for(int i = 0;i<nodes;i++)
//    {
//        System.out.println(i+"          "+dist[i]);
//    }
//}
//
//    public static void main(String[] args) {
//    int nodes;
//    System.out.println("Enter nodes ");
//    Scanner sc = new Scanner(System.in);
//    nodes=sc.nextInt();
//
//    System.out.println("enter the source");
//    int src = sc.nextInt();
//
//    int graph[][]= new int[nodes][nodes];
//    System.out.println("enter graph matrix " + nodes   );
//
//    for(int i = 0 ;i<nodes ; i++){
//        for(int j = 0 ; j < nodes ; j++){
//            graph[i][j] = sc.nextInt();
//        }
//    }
//    calshortestpath(graph,nodes,src);
//
//
//    }
//}