/*
 * Copyright  2019 Wei Yao Interview 
 * All Rights Reserved.
 * Unauthorized Use or Disclosure Prohibited.
 *
 * File: SchedulerTest.java
 * Last Check By Wei Yao On April-2019
 * Current Revision 1.0
 */
package com.sandbox.scheduler;

import com.sandbox.scheduler.model.Task;
import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.service.Scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pchurchward on 2017-07-20.
 * Modified by Wei Yao on 2019-04-03
 */
public class App {

    /**
     * Update the Category by getVlaue, since sorting can be done by Category value
     * 
     * @author Wei Yao
     * @param args
     */
    public static void main(String[] args) {
        // The original code uses Category.[RED|BLUE|GREEN] that couses compile error
        // Use linked int value of Category as input and sort based on the integer value of Category
        Task task1 = new Task(0, String.valueOf(Category.RED.getValue()));
        Task task2 = new Task(0, String.valueOf(Category.BLUE.getValue()));
        Task task3 = new Task(3, String.valueOf(Category.GREEN.getValue()));
        Task task4 = new Task(4, String.valueOf(Category.GREEN.getValue()));
        Task task5 = new Task(5, String.valueOf(Category.RED.getValue()));
        Task task6 = new Task(0, String.valueOf(Category.RED.getValue()));

        List<Task> unsorted = Arrays.asList(task1, task2, task3, task4, task5, task6);
         
        unsorted.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scheduler.printSchedule();
    }
}
