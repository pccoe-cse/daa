import java.util.Scanner;

public class floyd {

    public static void wars(int[][] graph, int nodes)
    {
        for(int k=0;k<nodes;k++)
        {
            for(int i=0;i<nodes;i++)
            {
                for(int j=0;j<nodes;j++)
                {
                    if(graph[i][j] > graph[i][k] +  graph[k][j])
                    {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

    }
    public static void print_sol(int[][] sol, int nodes)
    {
        for(int i=0;i<nodes;i++)
        {
            for(int j=0;j<nodes;j++)
            {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int nodes;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre the no of nodes: ");
        nodes = sc.nextInt();

        int[][] graph = new int[nodes][nodes];
        System.out.println("Entre the matrix");
        for(int i=0 ;i<nodes;i++)
        {
            for(int j=0;j<nodes;j++)
            {
                int edge = sc.nextInt();
                graph[i][j] = edge;
            }
        }

        wars(graph, nodes);
        print_sol(graph, nodes);


    }
}
