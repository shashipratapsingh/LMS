package com.LMS.controller;

import com.LMS.Service.PrincipalService;
import com.LMS.model.Principal;
import com.LMS.repository.PrincipalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Principal")
public class PrincipalController {
    @GetMapping("/healthcheck")
    public String getDashboard()
    {
        return "Principal Dashboard page";
    }

    private final PrincipalService principalService;

    public PrincipalController (PrincipalService principalService){
        this.principalService = principalService;
    }

    @PostMapping("/")
    public ResponseEntity<Principal> createPrincipal(@RequestBody Principal principal){
        return ResponseEntity.ok(principalService.createPrincipal(principal));
    }

    @GetMapping("{id}")
    public ResponseEntity<Principal> getPrincipalById(@PathVariable Long id){
        return ResponseEntity.ok(principalService.getPrincipalById(id));
    }

    @GetMapping("/")
    public List<Principal> getAllPrincipals()
    {
        return ResponseEntity.ok(principalService.getAllPrincipals()).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Principal> updatePrincipal(
            @PathVariable Long id,
            @RequestBody Principal principalDetails) {
        return ResponseEntity.ok(principalService.updatePrincipal(id, principalDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrincipal(@PathVariable Long id) {
        principalService.deletePrincipal(id);
        return ResponseEntity.noContent().build();
    }




}
