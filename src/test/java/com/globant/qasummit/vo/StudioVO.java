package com.globant.qasummit.vo;

/**
 * Value Object pattern
 */
public class StudioVO {
    private String name;
    private String path;
    private int numberOfPractices;

    public StudioVO(String name, String path, int numberOfPractices) {
        this.name = name;
        this.path = path;
        this.numberOfPractices = numberOfPractices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNumberOfPractices() {
        return numberOfPractices;
    }

    public void setNumberOfPractices(int numberOfPractices) {
        this.numberOfPractices = numberOfPractices;
    }

    @Override
    public String toString() {
        return "StudioVO{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", numberOfPractices=" + numberOfPractices +
                '}';
    }
}
