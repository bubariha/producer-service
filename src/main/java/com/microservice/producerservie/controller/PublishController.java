package com.microservice.producerservie.controller;

import com.microservice.producerservie.model.PublishRequest;
import com.microservice.producerservie.model.PublishResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class PublishController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishController.class);

    @Autowired
    private KafkaTemplate<String, PublishRequest> kafkaTemplate;
    private static String kafkaTopic = "test-topic";

    @ApiOperation(value = "publish", nickname = "doPublish")
    @ApiResponses(
            @ApiResponse(code = 201, message = "Task successfully created",
                    responseHeaders = {
                            @ResponseHeader(name = "Authorization", description = "Authorization token"),
                            @ResponseHeader(name = "Transaction-Id", description = "Trasaction Id"),
                            @ResponseHeader(name = "Activity-Id", description = "Activity Id")
                    }))
    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PublishResponse> publish(@Valid @RequestBody PublishRequest message) {
        LOGGER.info( "Harry publish request: {} ", message);
        ListenableFuture<SendResult<String, PublishRequest>> future =
                this.kafkaTemplate.send(kafkaTopic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, PublishRequest>>() {

            @Override
            public void onSuccess(SendResult<String, PublishRequest> result) {
                LOGGER.info("successfully sent message = {}, with offset = {}", message,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.info("Failed to send message = {}, error = {}", message, ex.getMessage());
            }
        });
        return new ResponseEntity<>(new PublishResponse("success", "Published successfully"), HttpStatus.OK);
    }


}
