public class ClubAssignmentBB {

    static int N; // Number of students and clubs
    static int[][] costMatrix; // Cost matrix
    static int minCost; // Minimum cost
    static int[] bestAssignment; // Best assignment array

    public static void main(String[] args) {
        costMatrix = new int[][] {
                {9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 9, 4}
        };

        N = costMatrix.length;
        minCost = Integer.MAX_VALUE;
        bestAssignment = new int[N];

        // Start Branch and Bound from the first student
        branchAndBound(new boolean[N], 0, 0, new int[N]);

        // Print results
        System.out.println("Minimum Cost: " + minCost);
        System.out.print("Assignment: ");
        for (int i = 0; i < N; i++) {
            System.out.print("Student " + i + " -> Club " + bestAssignment[i] + ", ");
        }
    }

    /**
     * Recursive Branch and Bound function
     *
     * @param visited    Tracks clubs already assigned
     * @param student    Current student being assigned
     * @param currentCost Current total cost
     * @param assignment Current assignment array
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
}
