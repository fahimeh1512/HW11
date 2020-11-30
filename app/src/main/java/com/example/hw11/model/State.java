package com.example.hw11.model;

// States for tasks
public enum State {
    Todo, Doing, Done;
    private State mValue;

    public void setValue(State value) {
        mValue = value;
    }
    public State getValue() {
        return mValue;
    }
}
