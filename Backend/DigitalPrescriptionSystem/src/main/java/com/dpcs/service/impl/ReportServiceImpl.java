package com.dpcs.service.impl;

import org.springframework.stereotype.Service;

import com.dpcs.dto.ReportResponse;
import com.dpcs.repository.AppointmentRepository;
import com.dpcs.repository.DoctorRepository;
import com.dpcs.repository.DispenseRepository;
import com.dpcs.repository.MedicineRepository;
import com.dpcs.repository.PatientRepository;
import com.dpcs.repository.PrescriptionRepository;
import com.dpcs.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final DispenseRepository dispenseRepository;

    public ReportServiceImpl(
            AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository,
            MedicineRepository medicineRepository,
            PrescriptionRepository prescriptionRepository,
            DispenseRepository dispenseRepository) {

        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.medicineRepository = medicineRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.dispenseRepository = dispenseRepository;
    }

    @Override
    public ReportResponse getReport() {

        return new ReportResponse(

                appointmentRepository.count(),
                appointmentRepository.countByStatusIgnoreCase("COMPLETED"),
                appointmentRepository.countByStatusIgnoreCase("PENDING"),
                appointmentRepository.countByStatusIgnoreCase("CANCELLED"),

                doctorRepository.count(),
                patientRepository.count(),

                medicineRepository.count(),
                prescriptionRepository.count(),
                dispenseRepository.count()

        );
    }
}