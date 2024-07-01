package org.hign.platform.u202212645.personnel.interfaces.rest;

import org.hign.platform.u202212645.personnel.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202212645.personnel.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202212645.personnel.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202212645.personnel.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.u202212645.personnel.interfaces.rest.transform.MentalStateExamResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/mental-state-exams")
@Tag(name = "MentalStateExams", description = "Mental State Exam Management Endpoints")
public class MentalStateExamController {

    private final MentalStateExamCommandService mentalStateExamCommandService;

    public MentalStateExamController(MentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }

    @PostMapping
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        try {
            var createMentalStateExamCommand = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource);
            var mentalStateExam = mentalStateExamCommandService.handle(createMentalStateExamCommand);
            if (mentalStateExam.isEmpty()) return ResponseEntity.badRequest().build();
            var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(mentalStateExam.get());
            return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}