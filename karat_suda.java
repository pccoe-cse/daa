import java.util.Scanner;

class Job {
    int id;
    int Profit;
    int deadline;

    public Job(int id, int Profit, int deadline) {
        this.id = id;
        this.Profit = Profit;
        this.deadline = deadline;
    }

    public void display() {
        System.out.println("id: " + this.id + " Profit: " + this.Profit + " Deadline: " + this.deadline);
    }
}

public class karat_suda {

    public static int max(Job[] jobs, int no) {
        int max_deadline = 0;
        for (int i = 0; i < no; i++) {
            if (jobs[i].deadline > max_deadline) {
                max_deadline = jobs[i].deadline;
            }
        }
        return max_deadline;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no;

        System.out.println("Enter number of jobs");
        no = sc.nextInt();

        Job[] jobs = new Job[no];
        int id;
        int Profit;
        int deadline;

        // Taking input
        for (int i = 0; i < no; i++) {
            System.out.println("Enter id, Profit, deadline of " + (i + 1) + " job");
            id = sc.nextInt();
            Profit = sc.nextInt();
            deadline = sc.nextInt();
            jobs[i] = new Job(id, Profit, deadline);
        }

        // Sorting the objects based on their profit (bubble sort)
        for (int i = 0; i < jobs.length - 1; i++) {  // Outer loop runs for n-1 times
            for (int j = 0; j < jobs.length - i - 1; j++) {  // Inner loop runs for n-i-1 times
                if (jobs[j].Profit < jobs[j + 1].Profit) {  // Compare profit of adjacent jobs
                    // Swap jobs if they're in the wrong order
                    Job temp = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = temp;
                }
            }
        }

        // Display sorted jobs
        for (int i = 0; i < no; i++) {
            jobs[i].display();
        }

        // Find the maximum deadline for slots
        int max_deadline = max(jobs, no);
        int[] slots = new int[max_deadline];

        // Initialize all slots to -1 (empty)
        for (int i = 0; i < max_deadline; i++) {
            slots[i] = -1;
        }

        int total_prof = 0;

        // Assign jobs to available slots
        for (int i = 0; i < no; i++) {
            // Try to find a slot for the job
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (slots[j] == -1) {  // Check if the slot is available
                    slots[j] = jobs[i].id;  // Assign the job id to the slot
                    total_prof += jobs[i].Profit;  // Add the job's profit to the total
                    break;  // Break the inner loop once the job is assigned
                }
            }
        }

        // Display the slots
        System.out.println("Job scheduling result:");
        for (int i = 0; i < max_deadline; i++) {
            System.out.print(slots[i] + " ");  // Display job ids in slots
        }
        System.out.println();

        // Display the total profit
        System.out.println("Total Profit: " + total_prof);
    }
}
