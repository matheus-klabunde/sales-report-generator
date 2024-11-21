package com.mtk.salesreportgenerator.dto;

import com.mtk.salesreportgenerator.enums.PdfGeneratorType;

public record ReportGeneratorRequest(String content, PdfGeneratorType type)
{
}
