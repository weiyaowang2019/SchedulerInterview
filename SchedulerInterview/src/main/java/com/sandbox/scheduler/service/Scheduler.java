/*
 * Copyright  2019 Wei Yao Interview 
 * All Rights Reserved.
 * Unauthorized Use or Disclosure Prohibited.
 *
 * File: SchedulerTest.java
 * Last Check By Wei Yao On April-2019
 * Current Revision 1.0
 */
package com.sandbox.scheduler.service;

import com.sandbox.scheduler.exception.CategoryOutofRangeException;
import com.sandbox.scheduler.exception.NullTaskException;
import com.sandbox.scheduler.exception.UrgencyOutofRangeException;
import com.sandbox.scheduler.model.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implement Scheduler as a static service Take tasks, sort and print out
 *
 * @author Wei Yao
 */
public class Scheduler {

    private static List<Task> taskList = new ArrayList<>();

    /**
     * Add a task into an internal array list
     *
     * @param t
     *
     */
    public static void scheduleTask(Task t) throws Exception {

        if (t != null) {
            if (t.urgency < 0 || t.urgency > 5) {
                throw new UrgencyOutofRangeException("Urgent can only be 0 to 5 !");
            } else if (t.getCategory() < 1 || t.getCategory() > 3) {
                throw new CategoryOutofRangeException("Category can only be RED, GREEN and BLUE");
            } else {
                taskList.add(t);
            }
        } else {
            throw new NullTaskException("Task Object cannot be null !");
        }

    }

    /**
     * Sort task list by urgency, category and time
     *
     * @return 
     */
    protected static List<Task> sortTaskList() {
        return taskList.stream()
                .sorted(Comparator.comparing(Task::getUrgency)
                        .thenComparing(Task::getCategory)
                        .thenComparing(Task::getTimestamp))
                .collect(Collectors.toList());
    }

    /**
     * Cleanup the Task List
     *
     */
    public static void cleanTaskList() {
        taskList.clear();

    }

    /**
     * print sorted scheduled tasks
     */
    public static void printSchedule() {
        List<Task> tasks = sortTaskList();
        tasks.forEach(System.out::println);
    }

}
