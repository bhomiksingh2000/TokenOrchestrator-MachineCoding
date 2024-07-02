package com.machineCoding.model;

public class Token {
    private long createdAt;
    private long blockedAt;
    private String id;
    private boolean isBlocked;
    private long lastKeepAlive;

    public Token(long createdAt, long blockedAt, String id, boolean isBlocked, long lastKeepAlive) {
        this.createdAt = createdAt;
        this.blockedAt = blockedAt;
        this.id = id;
        this.isBlocked = isBlocked;
        this.lastKeepAlive = lastKeepAlive;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(long blockedAt) {
        this.blockedAt = blockedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public long getLastKeepAlive() {
        return lastKeepAlive;
    }

    public void setLastKeepAlive(long lastKeepAlive) {
        this.lastKeepAlive = lastKeepAlive;
    }
}
