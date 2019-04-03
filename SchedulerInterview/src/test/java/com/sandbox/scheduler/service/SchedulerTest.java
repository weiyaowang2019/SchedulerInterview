/*
 * Copyright  2019 Wei Yao Interview 
 * All Rights Reserved.
 * Unauthorized Use or Disclosure Prohibited.
 *
 * File: SchedulerTest.java
 * Last Check By Wei Yao On 03-April-2019
 * Current Revision 1.0
 */
package com.sandbox.scheduler.service;

import com.sandbox.scheduler.exception.CategoryOutofRangeException;
import com.sandbox.scheduler.exception.NullTaskException;
import com.sandbox.scheduler.exception.UrgencyOutofRangeException;
import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 * The Test Cases are for testing the business services of
 * List<Task> sortTaskList() and scheduleTask(Task t)
 *
 * @author Wei Yao
 */
public class SchedulerTest {

    private static final Task task_0_RED = new Task(0, String.valueOf(Category.RED.getValue()));
    private static final Task task_1_GREEN = new Task(1, String.valueOf(Category.GREEN.getValue()));
    private static final Task task_2_BLUE = new Task(2, String.valueOf(Category.BLUE.getValue()));

    private static final Task task_0_GREEN = new Task(0, String.valueOf(Category.GREEN.getValue()));
    private static final Task task_0_BLUE = new Task(0, String.valueOf(Category.BLUE.getValue()));
    
    private static final Task task_MINUS_RED = new Task(-999, String.valueOf(Category.RED.getValue()));
    private static final Task task_MINUS_GREEN = new Task(-1, String.valueOf(Category.GREEN.getValue()));

    private static final Task task_3_BLACK = new Task(3, "BLACK");
    private static final Task task_5_WHITE = new Task(5, "WHITE");

    //For testcase1: sortByOrder_Urgency_Category_Timestamp
    private Task[] unSortedTasks_WithDifferentUrgency_Category_Timestamp;
    private Task[] sortedTasks_WithDifferentUrgency_Category_Timestamp;

    //For testcase2: sortWithSame_Urgency_Different_Category
    private Task[] unSortedTasks_WithSameUrgency_DifferentCategory;
    private Task[] sortedTasks_WithSameUrgency_DifferentCategory;

    //For testcase3: sortWithSame_UrgencyAndCategory_DifferentTimestamp
    private Task[] unSortedTasks_WithSameUrgencyAndCategory_DifferentTimestamp;
    private Task[] sortedTasks_WithSameUrgencyAndCategory_DifferentTimestamp;

    //For testcase4: Task Array with Null task
    private Task[] tasksArrayWithNulls;
    
    //For testcase5: Task Array with out of range Urgency
    private Task[] tasksArray_WithMinusUrgency;
    
    //For testcase6: Task Array with out of range Category
    private Task[] tasksArray_WithOutofRangeCategory;
    

    @Before
    public void setUp() {
        //For testcase1: sortByOrder_Urgency_Category_Timestamp
        unSortedTasks_WithDifferentUrgency_Category_Timestamp = new Task[]{task_2_BLUE, task_1_GREEN, task_0_RED};
        sortedTasks_WithDifferentUrgency_Category_Timestamp = new Task[]{task_0_RED, task_1_GREEN, task_2_BLUE};

        //For testcase2: sortWithSame_Urgency_Different_Category
        unSortedTasks_WithSameUrgency_DifferentCategory = new Task[]{task_0_BLUE, task_0_RED, task_0_GREEN};
        sortedTasks_WithSameUrgency_DifferentCategory = new Task[]{task_0_RED, task_0_BLUE, task_0_GREEN};

        //For testcase4: Task Array with Null task
        tasksArrayWithNulls = new Task[]{task_0_RED, null, task_2_BLUE};
        
        //For testcase5: Task Array with out of range Urgency
        tasksArray_WithMinusUrgency = new Task[]{task_MINUS_RED, task_MINUS_GREEN};
        
        //For testcase6: Task Array with out of range Category
        tasksArray_WithOutofRangeCategory = new Task[]{task_3_BLACK, task_5_WHITE};

    }

    @Test
    public void sortByOrder_Urgency_Category_Timestamp() throws Exception {
        //first clean up the task list then test with new case
        Scheduler.cleanTaskList();
        List<Task> unSortedList = Arrays.asList(unSortedTasks_WithDifferentUrgency_Category_Timestamp);
        unSortedList.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                Logger.getLogger(SchedulerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        List<Task> resultSortedList = Scheduler.sortTaskList();
        List<Task> expectedSortedList = Arrays.asList(sortedTasks_WithDifferentUrgency_Category_Timestamp);
        Assert.assertEquals(resultSortedList, expectedSortedList);

    }

    @Test
    public void sortWithSame_Urgency_Different_Category() throws Exception {
        //first clean up the task list then test with new case
        Scheduler.cleanTaskList();
        List<Task> unSortedList = Arrays.asList(unSortedTasks_WithSameUrgency_DifferentCategory);
        unSortedList.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                Logger.getLogger(SchedulerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        List<Task> resultSortedList = Scheduler.sortTaskList();
        List<Task> expectedSortedList = Arrays.asList(sortedTasks_WithSameUrgency_DifferentCategory);
        Assert.assertEquals(resultSortedList, expectedSortedList);

    }

    @Test
    public void sortWithSame_UrgencyAndCategory_DifferentTimestamp() throws Exception {
        //first clean up the task list then test with new case
        Scheduler.cleanTaskList();

        //For testcase3: sortWithSame_UrgencyAndCategory_DifferentTimestamp
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime tomorrow = today.plusDays(1);

        Task taskToday = new Task(0, String.valueOf(Category.RED.getValue()));
        taskToday.setTimestamp(today);

        Task taskYesterday = new Task(0, String.valueOf(Category.RED.getValue()));
        taskYesterday.setTimestamp(yesterday);

        Task taskTomorrow = new Task(0, String.valueOf(Category.RED.getValue()));
        taskTomorrow.setTimestamp(tomorrow);

        unSortedTasks_WithSameUrgencyAndCategory_DifferentTimestamp = new Task[]{taskToday, taskYesterday, taskTomorrow};
        sortedTasks_WithSameUrgencyAndCategory_DifferentTimestamp = new Task[]{taskYesterday, taskToday, taskTomorrow};

        List<Task> unSortedList = Arrays.asList(unSortedTasks_WithSameUrgencyAndCategory_DifferentTimestamp);
        unSortedList.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                Logger.getLogger(SchedulerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        List<Task> resultSortedList = Scheduler.sortTaskList();

        List<Task> expectedSortedList = Arrays.asList(sortedTasks_WithSameUrgencyAndCategory_DifferentTimestamp);
        Assert.assertEquals(resultSortedList, expectedSortedList);

    }

    @Test(expected = NullTaskException.class)
    public void tasksArrayWithNulls() throws Exception {
        //first clean up the task list then test with new case
        Scheduler.cleanTaskList();
        List<Task> unSortedList = Arrays.asList(tasksArrayWithNulls);
        unSortedList.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                throw new NullTaskException("Task Object cannot be null !");
            }
        });

    }

    @Test(expected = UrgencyOutofRangeException.class)
    public void tasksArray_WithMinusUrgency() throws Exception {
        //first clean up the task list then test with new case
        Scheduler.cleanTaskList();
        List<Task> unSortedList = Arrays.asList(tasksArray_WithMinusUrgency);
        unSortedList.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                throw new UrgencyOutofRangeException("Urgent can only be 0 to 5 !");
            }
        });
    }
    
    @Test(expected = CategoryOutofRangeException.class)
    public void tasksArray_WithOutofRangeCategory() throws Exception {
        //first clean up the task list then test with new case
        Scheduler.cleanTaskList();
        List<Task> unSortedList = Arrays.asList(tasksArray_WithOutofRangeCategory);
        unSortedList.forEach(t -> {
            try {
                Scheduler.scheduleTask(t);
            } catch (Exception ex) {
                throw new CategoryOutofRangeException("Category can only be RED, GREEN and BLUE !");
            }
        });
    }

}
