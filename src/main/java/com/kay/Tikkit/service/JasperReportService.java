package com.kay.Tikkit.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class JasperReportService {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public byte[] exportUserWiseDetailedReport(Integer userId, Date from, Date to) throws Exception {

        InputStream reportStream =
                getClass().getResourceAsStream("/reports/user_wise_tickets_report.jrxml");

        if (reportStream == null) {
            throw new RuntimeException("JRXML file not found!");
        }

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        Map<String, Object> params = new HashMap<>();
        params.put("UserId", userId);
        params.put("FromDate", from);
        params.put("ToDate", to);

        // Create manual JDBC connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        }
    }
    
    public byte[] exportUserWiseConsolidatedReport(Integer userId, Date from, Date to) throws Exception {

        InputStream reportStream =
                getClass().getResourceAsStream("/reports/user_wise_consolidated.jrxml");

        if (reportStream == null) {
            throw new RuntimeException("JRXML file not found!");
        }

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        Map<String, Object> params = new HashMap<>();
        params.put("UserId", userId);
        params.put("FromDate", from);
        params.put("ToDate", to);

        // Create manual JDBC connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        }
    }
}
