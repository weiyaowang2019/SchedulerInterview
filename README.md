# SchedulerInterview
This for Scheduler Interview

# Assignment:

Design a scheduler that receives a task and places it in the correct priority among all the existing scheduled tasks. 

A task’s position in the list is determined first by the urgency parameter (an integer from 0 - 5 where 0 is the most urgent). When two tasks have the same urgency, we look at it’s category. Categories are: RED (highest priority), BLUE and GREEN. When we have two tasks have the same urgency and category, we then look at time submitted, putting the one with the earlier timestamp first. 


# Code Changes:

1) In the Category class, the linked integer value has been altered since I use the linked integer value for sorting:

   RED(1),
   
    /*Note:  Based on Requirement document that the Category order is :
        Categories are: RED (highest priority), BLUE and GREEN.
        Switch GEEN and BLUE value from GREEN (2) to GREEN(3) and BLUE(3) to BLUE(2)
        for integer based sorting
    */
    
    BLUE(2),
    
    GREEN(3);

2) Added few "Get" methods in order to get the attribute of urgency, category and timestamp
3) Implemented a Scheduler class as static service as per assignment
4) Modified main "App" class to resolve the compile errors
5) Add exception packge with three specific exception classes
6) Implemented SchedulerTest class for unit testing with six test cases.

# Test Results:

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.sandbox.scheduler.service.SchedulerTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.883 sec

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

# App Run Results:

 [TASK] UUID: 8222a86e-755f-4bcd-a397-3f93fcfa19ea URGENCY: 0 CATEGORY: 1 TIMESTAMP: 2019-04-03T18:13:27.524

 [TASK] UUID: f8bf25d2-53ac-4844-a2d3-3587f4d4b14d URGENCY: 0 CATEGORY: 1 TIMESTAMP: 2019-04-03T18:13:28.182

 [TASK] UUID: 3c37f3fa-5dd7-4191-bdcb-4da7d6320220 URGENCY: 0 CATEGORY: 2 TIMESTAMP: 2019-04-03T18:13:28.182

 [TASK] UUID: 7f25e809-cc64-4f05-a4e7-bf357f41c738 URGENCY: 3 CATEGORY: 3 TIMESTAMP: 2019-04-03T18:13:28.182

 [TASK] UUID: 945df781-3a7e-4495-8d86-b7e906f6d3c1 URGENCY: 4 CATEGORY: 3 TIMESTAMP: 2019-04-03T18:13:28.182

 [TASK] UUID: d0d5561b-bceb-462c-97df-2f3c988f9762 URGENCY: 5 CATEGORY: 1 TIMESTAMP: 2019-04-03T18:13:28.182




