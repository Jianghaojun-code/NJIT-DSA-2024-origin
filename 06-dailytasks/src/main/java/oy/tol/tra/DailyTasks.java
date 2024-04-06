package oy.tol.tra;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A class showing your daily schedule using a timer.
 */
public class DailyTasks {

   private QueueInterface<String> dailyTaskQueue = null;
   private Timer timer = null;
   private static final int TASK_DELAY_IN_SECONDS = 1 * 1000;

   private DailyTasks() throws QueueAllocationException {
       dailyTaskQueue = QueueFactory.createStringQueue();
   }

   public static void main(String[] args) {
       try {
           DailyTasks tasks = new DailyTasks();
           tasks.run();
       } catch (QueueAllocationException e) {
           System.out.println("Failed to create daily tasks queue: " + e.getMessage());
       }
   }

   private void run() {
       try {
           readTasks();
           timer = new Timer(); 
           timer.scheduleAtFixedRate(new TimerTask() {
               @Override
               public void run() {
                   if (!dailyTaskQueue.isEmpty()) { 
                       try {
                           String task = dailyTaskQueue.dequeue(); 
                           System.out.println("Task for today: " + task);
                       } catch (QueueIsEmptyException e) {
                           System.out.println("Error dequeueing task: " + e.getMessage());
                       }
                   } else {
                       timer.cancel(); 
                   }
               }
           }, TASK_DELAY_IN_SECONDS, TASK_DELAY_IN_SECONDS);
       } catch (IOException e) {
           System.out.println("Something went wrong while reading tasks: " + e.getMessage());
       }
   }

   private void readTasks() throws IOException {
       String tasks = new String(getClass().getClassLoader().getResourceAsStream("DailyTasks.txt").readAllBytes());
       String[] allTasks = tasks.split("\\r?\\n");
       for (String task : allTasks) {
           try {
               dailyTaskQueue.enqueue(task); 
           } catch (QueueAllocationException | NullPointerException e) {
               System.out.println("Error enqueueing task: " + e.getMessage());
           }
       }
       System.out.println("Number of tasks in the queue: " + dailyTaskQueue.size()); 
   }
}