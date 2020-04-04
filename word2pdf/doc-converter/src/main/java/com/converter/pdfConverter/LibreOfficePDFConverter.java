package com.converter.pdfConverter;

public class LibreOfficePDFConverter extends AbstractOpenOfficePDFConverter {

    private String OFFICE_HOME = "D:\\Program Files (x86)\\LibreOffice 5";

    protected String getOfficeHome() {
        return OFFICE_HOME;
    }
}