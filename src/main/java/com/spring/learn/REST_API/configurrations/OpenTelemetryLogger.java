package com.spring.learn.REST_API.configurrations;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.logs.Logger;
import io.opentelemetry.api.logs.LoggerProvider;
import io.opentelemetry.exporter.otlp.http.logs.OtlpHttpLogRecordExporter;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;

@Configuration
public class OpenTelemetryLogger {

    private static final LoggerProvider loggerProvider = SdkLoggerProvider.builder() // Creates a logger provider to manage OpenTelemetry loggers.
            .addLogRecordProcessor( // Adds a log processor that will process log records before sending them to the backend.
                BatchLogRecordProcessor.builder(
                    OtlpGrpcLogRecordExporter.builder() // Uses a batch processor to efficiently send logs in batches (instead of one by one).
                    // Uses the OTLP exporter to send logs via gRPC.
                        .setEndpoint("") // Specifies the OTLP receiver where logs should be sent.
                        .build()
                ).build()

            )
            // Export logs via HTTP
            .addLogRecordProcessor(
                BatchLogRecordProcessor.builder(
                    OtlpHttpLogRecordExporter.builder()
                        .setEndpoint("http://localhost:4318/v1/logs") // Matches your YAML receiver config
                        .build()
                ).build()
            )
            .build(); // Finalizes and builds the loggerProvider.

private static final Logger logger = loggerProvider.get("otel-logger");



}
