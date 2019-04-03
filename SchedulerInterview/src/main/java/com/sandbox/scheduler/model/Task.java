package com.sandbox.scheduler.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pchurchward on 2017-07-20.
 *
 * Modified by Wei Yao on 2019-04-03
 *
 * Add getUrgency(), getCategory(), getTimestamp() For using java 8 reference
 * method
 */
public class Task {

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * New method added by Wei Yao for sorting Get Urgency value
     *
     * @return
     */
    public int getUrgency() {
        return urgency;
    }

    /**
     * New method added by Wei Yao for sorting Get Category value
     *
     * @return
     */
    public int getCategory() {
        int ret = -1;
        if (category != null && !category.isEmpty()) {
            if (category.equals(String.valueOf(Category.RED.getValue()))
                    || category.equals(String.valueOf(Category.GREEN.getValue()))
                    || category.equals(String.valueOf(Category.BLUE.getValue()))) {
                ret = Integer.parseInt(category);
            }
        }
        return ret;
    }

    /**
     * New method added by Wei Yao for sorting Get Timestamp
     *
     * @return
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     *
     */
    public int urgency = -1;

    /**
     *
     */
    public String category;

    /**
     *
     */
    public LocalDateTime timestamp = LocalDateTime.now();

    /**
     *
     */
    public UUID uuid = UUID.randomUUID();

    /**
     *
     * @param urgency
     * @param category
     */
    public Task(int urgency, String category) {
        this.urgency = urgency;
        this.category = category;
    }

    public String toString() {

        return "[TASK] UUID: " + uuid.toString() + " URGENCY: " + urgency + " CATEGORY: " + category + " TIMESTAMP: " + timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task task = (Task) o;

        if (urgency != task.urgency) {
            return false;
        }
        if (!category.equals(task.category)) {
            return false;
        }
        if (timestamp != null ? !timestamp.equals(task.timestamp) : task.timestamp != null) {
            return false;
        }
        return uuid != null ? uuid.equals(task.uuid) : task.uuid == null;
    }

    @Override
    public int hashCode() {
        int result = urgency;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
}
