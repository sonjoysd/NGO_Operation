package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ReviewNote implements Serializable {
    private static final long serialVersionUID = 1L;

    private String noteId, targetId, reviewerRole, noteText;
    private LocalDate date;

    public ReviewNote(String noteId, String targetId, String reviewerRole, String noteText, LocalDate date) {
        this.noteId = noteId;
        this.targetId = targetId;
        this.reviewerRole = reviewerRole;
        this.noteText = noteText;
        this.date = date;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getReviewerRole() {
        return reviewerRole;
    }

    public String getNoteText() {
        return noteText;
    }

    public LocalDate getDate() {
        return date;
    }
}
