package com.springboot.hospitaldetails.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.hospitaldetails.entity.Doctor;
import com.springboot.hospitaldetails.entity.Patient;
import com.springboot.hospitaldetails.repository.DoctorRepository;
import com.springboot.hospitaldetails.repository.PatientRepository;
import com.springboot.hospitaldetails.service.HospitalService;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Doctor showDoctorInformation(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public Patient showPatientInformation(Integer id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public boolean saveDoctorInformation(Doctor doctor) {
        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public boolean savePatientInformation(Patient patient) {

        Doctor doctor = doctorRepository.findByName(patient.getDoctor_name());
        doctor.addPatients(patient);
        patientRepository.save(patient);
        doctor.setPatient_count();
        return true;
    }

    @Override
    public List<Patient> getPatientListOfDoctor(String name, Doctor doctor) {
        return doctor.getPatients();
    }

    @Override
    public List<Doctor> getDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }
}
