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

    public static Job[] inputJobs(int no) {
        Scanner sc = new Scanner(System.in);
        Job[] jobs = new Job[no];
        for (int i = 0; i < no; i++) {
            System.out.println("Enter id, Profit, deadline of job " + (i + 1) + ": ");
            int id = sc.nextInt();
            int Profit = sc.nextInt();
            int deadline = sc.nextInt();
            jobs[i] = new Job(id, Profit, deadline);
        }
        return jobs;
    }

    public static void sortJobsByProfit(Job[] jobs) {
        for (int i = 0; i < jobs.length - 1; i++) {
            for (int j = 0; j < jobs.length - i - 1; j++) {
                if (jobs[j].Profit < jobs[j + 1].Profit) {
                    Job temp = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = temp;
                }
            }
        }
    }

    public static int findMaxDeadline(Job[] jobs) {
        int max_deadline = 0;
        for (Job job : jobs) {
            if (job.deadline > max_deadline) {
                max_deadline = job.deadline;
            }
        }
        return max_deadline;
    }

    public static int[] scheduleJobs(Job[] jobs, int max_deadline) {
        int[] slots = new int[max_deadline];
        for (int i = 0; i < max_deadline; i++) {
            slots[i] = -1; // Initialize slots to -1
        }

        for (Job job : jobs) {
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = job.id; // Assign job id to slot
                    break;
                }
            }
        }
        return slots;
    }

    public static int calculateTotalProfit(Job[] jobs, int[] slots) {
        int totalProfit = 0;
        for (int slot : slots) {
            if (slot != -1) {
                for (Job job : jobs) {
                    if (job.id == slot) {
                        totalProfit += job.Profit;
                        break;
                    }
                }
            }
        }
        return totalProfit;
    }

    public static void displayResults(int[] slots, int totalProfit) {
        System.out.println("Job scheduling result:");
        for (int slot : slots) {
            System.out.print(slot + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs:");
        int no = sc.nextInt();

        Job[] jobs = inputJobs(no); // Input jobs
        sortJobsByProfit(jobs);    // Sort jobs by profit

        // Display sorted jobs
        System.out.println("Sorted jobs by profit:");
        for (Job job : jobs) {
            job.display();
        }

        int max_deadline = findMaxDeadline(jobs); // Find maximum deadline
        int[] slots = scheduleJobs(jobs, max_deadline); // Schedule jobs
        int totalProfit = calculateTotalProfit(jobs, slots); // Calculate total profit

        displayResults(slots, totalProfit); // Display results
    }
}
