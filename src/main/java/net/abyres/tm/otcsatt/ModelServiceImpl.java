package net.abyres.tm.otcsatt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.abyres.tm.otcs.model.Attendance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ModelServiceImpl implements ModelService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Attendance> findAllByEmployeeId(String employeeId) {
        List<Attendance> copyList = new ArrayList<>();
        entityManager.createQuery("from Attendance", Attendance.class).getResultList().stream()
                .forEach(b -> {
                    copyList.add(cloneAttendance(b));
                });

        return copyList;
    }

    public Attendance cloneAttendance(Attendance p) {
        Attendance attendance = new Attendance();
        attendance.setBpartnerId(p.getBpartnerId());
        attendance.setCreated(p.getCreated());
        attendance.setCreatedBy(p.getCreatedBy());
        attendance.setActive(p.isActive());
        attendance.setUpdated(p.getUpdated());
        attendance.setUpdatedBy(p.getUpdatedBy());
        attendance.setLocationId(p.getLocationId());
        return attendance;
    }

    @Transactional
    @Override
    public boolean append(String employeeId, String locationId, String time) {
        Attendance attendance = new Attendance();
        attendance.setAttendanceId("000-000-01010101");
        attendance.setBpartnerId(employeeId);
        attendance.setLocationId("1f438a80-b0df-4342-9c37-3367473aefc0");
        attendance.setUpdated(LocalDateTime.parse(time));
        attendance.setUpdatedBy("8a25b1fa-36cc-42fe-8195-dab9fd4f3784");

        try {
            entityManager.merge(attendance);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
