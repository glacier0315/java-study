package com.converter.pdfConverter;

public class OpenOfficePDFConverter extends AbstractOpenOfficePDFConverter {

    private String OFFICE_HOME = "D:\\Program Files (x86)\\OpenOffice 4";

    protected String getOfficeHome(){
        return OFFICE_HOME;
    }
}
