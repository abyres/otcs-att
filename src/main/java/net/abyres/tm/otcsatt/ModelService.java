package net.abyres.tm.otcsatt;

import java.util.List;
import net.abyres.tm.otcs.model.Attendance;

interface ModelService {

    boolean append(String employeeId, String locationId, String time);

    List<Attendance> findAllByEmployeeId(String employeeId);
}
