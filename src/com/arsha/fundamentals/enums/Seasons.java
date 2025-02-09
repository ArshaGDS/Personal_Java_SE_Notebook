package com.arsha.fundamentals.enums;

public enum Seasons {

    January(31), February(28), March(31), April(30), May(31), June(30), July(31),
    August(30), September(31), October(30), November(31), December(30);

    private int daysAmount;
    Seasons(int inDaysAmount) {
        this.daysAmount = inDaysAmount;
    }

    public int getDaysAmount() {
        return daysAmount;
    }
}
