package com.example.expandrecyclerview_qrcode;

public class Lesson {
    private String ttTitle;

    private String ttInfo;

    private int ttNotification = 0;

    private String ttTimeStart;

    private String ttTimeEnd;

   private boolean expanded;

    public Lesson(String ttTitle, String ttInfo, int ttNotification, String ttTimeStart, String ttTimeEnd, boolean expanded) {
        this.ttTitle = ttTitle;
        this.ttInfo = ttInfo;
        this.ttNotification = ttNotification;
        this.ttTimeStart = ttTimeStart;
        this.ttTimeEnd = ttTimeEnd;
        this.expanded = expanded;
    }

    public String getTtTitle() {
        return ttTitle;
    }

    public void setTtTitle(String ttTitle) {
        this.ttTitle = ttTitle;
    }

    public String getTtInfo() {
        return ttInfo;
    }

    public void setTtInfo(String ttInfo) {
        this.ttInfo = ttInfo;
    }

    public int getTtNotification() {
        return ttNotification;
    }

    public void setTtNotification(int ttNotification) {
        this.ttNotification = ttNotification;
    }

    public String getTtTimeStart() {
        return ttTimeStart;
    }

    public void setTtTimeStart(String ttTimeStart) {
        this.ttTimeStart = ttTimeStart;
    }

    public String getTtTimeEnd() {
        return ttTimeEnd;
    }

    public void setTtTimeEnd(String ttTimeEnd) {
        this.ttTimeEnd = ttTimeEnd;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
