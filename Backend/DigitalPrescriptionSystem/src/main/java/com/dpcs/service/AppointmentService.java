package com.dpcs.service;

import java.util.List;
import com.dpcs.dto.AppointmentRequest;
import com.dpcs.entity.Appointment;

public interface AppointmentService {

    Appointment create(AppointmentRequest request);

    List<Appointment> getAll();

    Appointment getById(String id);

    void delete(String id);
}