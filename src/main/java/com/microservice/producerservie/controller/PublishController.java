package com.microservice.producerservie.controller;

import com.microservice.producerservie.model.PublishRequest;
import com.microservice.producerservie.model.PublishResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class PublishController {


    @ApiOperation(value = "publish", nickname = "doPublish")
    @ApiResponses(
            @ApiResponse(code = 201, message = "Task successfully created",
                    responseHeaders = {
                            @ResponseHeader(name = "Authorization", description = "Authorization token"),
                            @ResponseHeader(name = "Transaction-Id", description = "Trasaction Id"),
                            @ResponseHeader(name = "Activity-Id", description = "Activity Id")
                    }))
    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PublishResponse> publish(@Valid @RequestBody PublishRequest requestToPublish) {

        return new ResponseEntity<>(new PublishResponse("success", "Published successfully"), HttpStatus.OK);
    }
}
