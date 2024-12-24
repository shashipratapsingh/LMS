package com.LMS.Service;

import com.LMS.GlobleExceptions.ResourceNotFoundException;
import com.LMS.model.Principal;
import com.LMS.repository.PrincipalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrincipalService {
    private final PrincipalRepository principalRepository;
    public PrincipalService(PrincipalRepository principalRepository) {
        this.principalRepository = principalRepository;
    }

    public Principal createPrincipal(Principal principal)
    {
        return this.principalRepository.save(principal);
    }

    public Principal getPrincipalById(Long id)
    {
        return principalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not found "+id));
    }
    public List<Principal> getAllPrincipals(){
        return principalRepository.findAll();
    }
    public Principal updatePrincipal(Long id, Principal principalDetails) {
        Principal principal = getPrincipalById(id);
        principal.setName(principalDetails.getName());
        principal.setPhoneNo(principalDetails.getPhoneNo());
        principal.setEmail(principalDetails.getEmail());
        principal.setAddress(principalDetails.getAddress());
        principal.setGender(principalDetails.getGender());
        principal.setDob(principalDetails.getDob());
        principal.setDoj(principalDetails.getDoj());
        principal.setQualifications(principalDetails.getQualifications());
        principal.setSpecialization(principalDetails.getSpecialization());
        principal.setSalary(principalDetails.getSalary());
        principal.setDepartment(principalDetails.getDepartment());
        principal.setDesignation(principalDetails.getDesignation());
        principal.setIsActive(principalDetails.getIsActive());
        return principalRepository.save(principal);
    }
    public void deletePrincipal(Long id) {
        Principal principal = getPrincipalById(id);
        principalRepository.delete(principal);
    }


}
