package com.mtk.salesreportgenerator.controller;

import com.mtk.salesreportgenerator.dto.ReportGeneratorRequest;
import com.mtk.salesreportgenerator.service.SalesReportGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@RestController
@RequestMapping("sales")
public class SalesReportController
{
	private final SalesReportGenerator salesReportGenerator;

	@Autowired
	public SalesReportController(SalesReportGenerator salesReportGenerator)
	{
		this.salesReportGenerator = salesReportGenerator;
	}

	@PostMapping("/report/generate")
	public ResponseEntity<String> generateReport(@RequestBody ReportGeneratorRequest request)
	{
		salesReportGenerator.generate(request);
		return ResponseEntity.ok("PDF generated successfully with type: " + request.type());
	}
}
