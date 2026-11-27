package main.ngooperation.mamun_2430986.Model.User;

import javafx.collections.ObservableList;
import main.ngooperation.Employee;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.NonUser.ReviewNote;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;

import java.io.Serializable;
import java.time.LocalDate;

public class ExecutiveDirector extends Employee implements Serializable {

    private static final String KPI_FILE = "PerformanceIndicators.bin";
    private static final String REVIEW_NOTES_FILE = "ReviewNotes.bin";

    public ExecutiveDirector(int userId, String password, String userName, String phone, String role, String mail,
                             int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

    public static ObservableList<PerformanceIndicator> loadAllKPIs() {
        return FileReadWrite.loadData(PerformanceIndicator.class, KPI_FILE);
    }

    public static void saveReviewNote(String targetId, String reviewerRole, String noteText) {
        String noteId = "RN-" + System.currentTimeMillis();
        ReviewNote note = new ReviewNote(noteId, targetId, reviewerRole, noteText, LocalDate.now());
        FileReadWrite.append(note, REVIEW_NOTES_FILE);
    }
}
