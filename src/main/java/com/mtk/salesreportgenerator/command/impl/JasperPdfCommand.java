package com.mtk.salesreportgenerator.command.impl;

import com.mtk.salesreportgenerator.adapter.PdfAdapter;
import com.mtk.salesreportgenerator.command.PdfCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JasperPdfCommand implements PdfCommand
{
	private final PdfAdapter pdfAdapter;

	@Autowired
	public JasperPdfCommand(@Qualifier("jasperPdfAdapter") PdfAdapter pdfAdapter)
	{
		this.pdfAdapter = pdfAdapter;
	}

	@Override
	public void execute(String filename, String content)
	{
		pdfAdapter.generate(filename, content);
	}
}
