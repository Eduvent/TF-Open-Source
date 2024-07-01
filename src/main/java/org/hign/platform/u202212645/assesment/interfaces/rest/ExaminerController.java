package org.hign.platform.u202212645.assesment.interfaces.rest;

import org.hign.platform.u202212645.assesment.domain.services.ExaminerCommandService;
import org.hign.platform.u202212645.assesment.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202212645.assesment.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.u202212645.assesment.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.u202212645.assesment.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/examiners")
@Tag(name = "Examiners", description = "Examiner Management Endpoints")
public class ExaminerController {

    private final ExaminerCommandService examinerCommandService;

    public ExaminerController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        var createExaminerCommand = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(createExaminerCommand);
        if (examiner.isEmpty()) return ResponseEntity.badRequest().build();
        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner.get());
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }
}