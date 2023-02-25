package co.gruppo2.studiomedico.controllers;

import co.gruppo2.studiomedico.DTO.PatientDTO;
import co.gruppo2.studiomedico.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController{
    @Autowired
    private PatientService patientService;


    @PostMapping("/add")
    public ResponseEntity<PatientDTO> savePatient(@Valid @RequestBody  PatientDTO patientDTO){
        PatientDTO savedPatient = patientService.savePatient(patientDTO);
        return new ResponseEntity<>(savedPatient,HttpStatus.CREATED);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PatientDTO> findPatientByEmail(@PathVariable String email){
        PatientDTO patientDTO = patientService.findPatientByEmail(email);
        return ResponseEntity.ok(patientDTO);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<PatientDTO> findPatientById(@PathVariable Long id){
        PatientDTO patientDTO = patientService.findPatientById(id);
        return ResponseEntity.ok(patientDTO);
    }

    @GetMapping("/name-surname")
    public ResponseEntity<List<PatientDTO>> findPatientsByNameSurname(
            @RequestParam String name,@RequestParam String surname){
        List<PatientDTO> patientsDTO = patientService.findPatientsByNameSurname(name,surname);
        return ResponseEntity.ok(patientsDTO);
    }
}
