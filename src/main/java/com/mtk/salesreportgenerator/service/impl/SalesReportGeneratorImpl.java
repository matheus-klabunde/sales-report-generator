package com.mtk.salesreportgenerator.service.impl;

import com.mtk.salesreportgenerator.command.PdfCommand;
import com.mtk.salesreportgenerator.dto.ReportGeneratorRequest;
import com.mtk.salesreportgenerator.factory.PdfCommandFactory;
import com.mtk.salesreportgenerator.service.SalesReportGenerator;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesReportGeneratorImpl implements SalesReportGenerator
{
	private final PdfCommandFactory commandFactory;

	@Autowired
	public SalesReportGeneratorImpl(PdfCommandFactory commandFactory)
	{
		this.commandFactory = commandFactory;
	}

	@Override
	public void generate(ReportGeneratorRequest request)
	{
		String filename = LocalDateTime.now().toString().replace(":", "-") + ".pdf";
		PdfCommand command = commandFactory.getCommand(request.type());
		command.execute(filename, request.content());
	}
}
