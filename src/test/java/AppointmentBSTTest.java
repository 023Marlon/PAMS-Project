import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentBSTTest {
    @Test
    public void testAddAppointment() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Test Patient", "09:00");
        bst.addAppointment(p1);
        assertNotNull(bst.getRoot());
        assertEquals("09:00", bst.getRoot().data.appointmentTime);
    }

    @Test
    public void testDuplicateAppointmentTime() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Test Patient", "09:00");
        PatientAppointment p2 = new PatientAppointment(2, "Another Patient", "09:00");
        bst.addAppointment(p1);
        bst.addAppointment(p2); // Should not insert
        assertNull(bst.getRoot().right);
        assertNull(bst.getRoot().left);
    }

    @Test
    public void testInOrderInsertionOrder() {
        AppointmentBST bst = new AppointmentBST();
        bst.addAppointment(new PatientAppointment(1, "A", "09:30"));
        bst.addAppointment(new PatientAppointment(2, "B", "08:45"));
        bst.addAppointment(new PatientAppointment(3, "C", "10:15"));

        // Root should be 09:30, left 08:45, right 10:15
        assertEquals("09:30", bst.getRoot().data.appointmentTime);
        assertEquals("08:45", bst.getRoot().left.data.appointmentTime);
        assertEquals("10:15", bst.getRoot().right.data.appointmentTime);
    }
}
