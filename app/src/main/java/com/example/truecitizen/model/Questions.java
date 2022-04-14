package com.example.truecitizen.model;

public class Questions {
    private int quesId;
    private boolean ans;

    public Questions (int quesId, boolean ans) {
        this.quesId = quesId;
        this.ans = ans;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
