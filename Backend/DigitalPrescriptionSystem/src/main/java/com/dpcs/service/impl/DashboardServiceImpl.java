package com.dpcs.service.impl;

import org.springframework.stereotype.Service;

import com.dpcs.dto.AdminDashboardResponse;
import com.dpcs.repository.DoctorRepository;
import com.dpcs.repository.DispenseRepository;
import com.dpcs.repository.MedicineRepository;
import com.dpcs.repository.PatientRepository;
import com.dpcs.repository.PrescriptionRepository;
import com.dpcs.repository.UserRepository;
import com.dpcs.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final DispenseRepository dispenseRepository;

    public DashboardServiceImpl(
            UserRepository userRepository,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository,
            MedicineRepository medicineRepository,
            PrescriptionRepository prescriptionRepository,
            DispenseRepository dispenseRepository) {

        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.medicineRepository = medicineRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.dispenseRepository = dispenseRepository;
    }

    @Override
    public AdminDashboardResponse getAdminDashboard() {

        return new AdminDashboardResponse(

                userRepository.count(),
                doctorRepository.count(),
                patientRepository.count(),
                medicineRepository.count(),
                prescriptionRepository.count(),
                dispenseRepository.count()

        );
    }
}