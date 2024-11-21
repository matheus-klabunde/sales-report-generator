package com.mtk.salesreportgenerator.command.impl;

import com.mtk.salesreportgenerator.adapter.PdfAdapter;
import com.mtk.salesreportgenerator.command.PdfCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OpenPdfCommand implements PdfCommand
{
	private final PdfAdapter pdfAdapter;

	@Autowired
	public OpenPdfCommand(@Qualifier("openPdfAdapter") PdfAdapter pdfAdapter)
	{
		this.pdfAdapter = pdfAdapter;
	}

	@Override
	public void execute(String filename, String content)
	{
		pdfAdapter.generate(filename, content);
	}
}