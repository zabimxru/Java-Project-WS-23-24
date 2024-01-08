package com.gruppe8.frauas.backend.data;

public class DroneListData {

    private int count;
    private String next;
    private String previous;
    private DroneData[] results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public DroneData[] getResults() {
        return results;
    }

    public void setResults(DroneData[] results) {
        this.results = results;
    }
}
