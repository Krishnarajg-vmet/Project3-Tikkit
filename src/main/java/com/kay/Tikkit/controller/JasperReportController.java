package com.kay.Tikkit.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kay.Tikkit.service.JasperReportService;

@RestController
@RequestMapping("/api/reports")
public class JasperReportController {

    @Autowired
    private JasperReportService jasperReportService;

    @PreAuthorize("hasAuthority('VIEW_USER_WISE_TICKETS_REPORT')")
    @GetMapping("/user-wise-tickets/detailed-report")
    public ResponseEntity<byte[]> getDetailedReport(
            @RequestParam String userId,
            @RequestParam String fromDate,
            @RequestParam String toDate) throws Exception {

        Date from = Date.valueOf(fromDate);
        Date to = Date.valueOf(toDate);

        Integer userIdInt = null;
        if(userId != null && !"null".equalsIgnoreCase(userId)) {
        	userIdInt = Integer.valueOf(userId);
        }
        byte[] pdf = jasperReportService.exportUserWiseDetailedReport(userIdInt, from, to);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=User_Wise_Detailed.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdf);
    }
    
    @PreAuthorize("hasAuthority('VIEW_CONSOLIDATED_TICKET_REPORT')")
    @GetMapping("/user-wise-tickets/consolidated-report")
    public ResponseEntity<byte[]> getConsolidatedReport(
            @RequestParam String userId,
            @RequestParam String fromDate,
            @RequestParam String toDate) throws Exception {

        Date from = Date.valueOf(fromDate);
        Date to = Date.valueOf(toDate);
        Integer userIdInt = null;
        if(userId != null && !"null".equalsIgnoreCase(userId)) {
        	userIdInt = Integer.valueOf(userId);
        }

        byte[] pdf = jasperReportService.exportUserWiseConsolidatedReport(userIdInt, from, to);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=User_Wise_Consolidated.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdf);
    }
}

