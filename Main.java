import java.util.Scanner;

public class ClubAssignmentBB {

    static int N; // Number of students and clubs
    static int[][] costMatrix; // Cost matrix
    static int minCost; // Minimum cost
    static int[] bestAssignment; // Best assignment array

    public static void main(String[] args) {
        // Input from the user
        takeInput();

        // Initialize variables
        initialize();

        // Start Branch and Bound from the first student
        branchAndBound(new boolean[N], 0, 0, new int[N]);

        // Output the results
        displayResults();
    }

    /**
     * Takes input for the number of students/clubs and the cost matrix from the user.
     */
    public static void takeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students/clubs:");
        N = sc.nextInt();

        costMatrix = new int[N][N];
        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costMatrix[i][j] = sc.nextInt();
            }
        }
    }

    /**
     * Initializes variables for Branch and Bound.
     */
    public static void initialize() {
        minCost = Integer.MAX_VALUE;
        bestAssignment = new int[N];
    }

    /**
     * Recursive Branch and Bound function.
     *
     * @param visited    Tracks clubs already assigned.
     * @param student    Current student being assigned.
     * @param currentCost Current total cost.
     * @param assignment Current assignment array.
     */
    public static void branchAndBound(boolean[] visited, int student, int currentCost, int[] assignment) {
        // Base case: all students are assigned
        if (student == N) {
            if (currentCost < minCost) {
                minCost = currentCost;
                System.arraycopy(assignment, 0, bestAssignment, 0, N);
            }
            return;
        }

        // Explore each club for the current student
        for (int club = 0; club < N; club++) {
            if (!visited[club]) { // If the club is not yet assigned
                int newCost = currentCost + costMatrix[student][club];

                // Prune if the cost exceeds the current minimum cost
                if (newCost < minCost) {
                    visited[club] = true; // Mark club as visited
                    assignment[student] = club; // Assign the student to this club

                    // Recur to assign the next student
                    branchAndBound(visited, student + 1, newCost, assignment);

                    visited[club] = false; // Backtrack
                }
            }
        }
    }

    /**
     * Displays the minimum cost and the assignment.
     */
    public static void displayResults() {
        System.out.println("Minimum Cost: " + minCost);
        System.out.print("Assignment: ");
        for (int i = 0; i < N; i++) {
            System.out.print("Student " + i + " -> Club " + bestAssignment[i] + ", ");
        }
        System.out.println();
    }
}
