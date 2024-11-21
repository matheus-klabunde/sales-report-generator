package com.mtk.salesreportgenerator.command;

public interface PdfCommand
{
	void execute(String filename, String content);
}