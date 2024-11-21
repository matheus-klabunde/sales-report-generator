package com.mtk.salesreportgenerator.service;

import com.mtk.salesreportgenerator.dto.ReportGeneratorRequest;

public interface SalesReportGenerator
{
	void generate(ReportGeneratorRequest request);
}
