package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class CoordinationMeeting implements Serializable {

    private String meetingId, projectId, topic, location, team, status;
    private LocalDate meetingDate;

    public CoordinationMeeting(String meetingId, String projectId, String topic, String location, String team, String status, LocalDate meetingDate) {
        this.meetingId = meetingId;
        this.projectId = projectId;
        this.topic = topic;
        this.location = location;
        this.team = team;
        this.status = status;
        this.meetingDate = meetingDate;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTopic() {
        return topic;
    }

    public String getLocation() {
        return location;
    }

    public String getTeam() {
        return team;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }
}
