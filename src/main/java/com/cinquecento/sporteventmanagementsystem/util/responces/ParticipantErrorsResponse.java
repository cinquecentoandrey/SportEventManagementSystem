package com.cinquecento.sporteventmanagementsystem.util.responces;

import java.time.LocalDateTime;

public class ParticipantErrorsResponse {

    private String name;
    private LocalDateTime timeStamp;

    public ParticipantErrorsResponse(String name, LocalDateTime timeStamp) {
        this.name = name;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
