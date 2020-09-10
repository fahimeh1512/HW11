package com.example.hw11.model;

// States for tasks
public enum State {
    Todo, Doing, Done;
    private static State mValue;

    public static void setValue(State value) {
        mValue = value;
    }
    public static State getValue() {
        return mValue;
    }
}
