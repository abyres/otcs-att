package net.abyres.tm.otcsatt;

import java.util.List;
import net.abyres.tm.otcs.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @RequestMapping("/employee")
    public List<Attendance> findAllByEmployeeId(@RequestParam(value="id") String employeeId) {
        return modelService.findAllByEmployeeId(employeeId);
    }

    @RequestMapping("/append")
    public boolean append(
            @RequestParam(value="employeeId") String employeeId,
            @RequestParam(value="locationId") String locationId,
            @RequestParam(value="time") String time
    ) {
        return modelService.append(employeeId, locationId, time);
    }
}
