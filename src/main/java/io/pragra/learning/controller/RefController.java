package io.pragra.learning.controller;

import io.pragra.learning.domain.RefData;
import io.pragra.learning.repo.RefDataRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RefController {

    private RefDataRepo refDataRepo;

    public RefController(RefDataRepo refDataRepo) {
        this.refDataRepo = refDataRepo;
    }

    @GetMapping("/api/ref")
    public List<RefData> getRefData(){
        return refDataRepo.findAll();

    }
}
