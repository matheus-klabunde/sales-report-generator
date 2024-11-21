package com.mtk.salesreportgenerator.adapter.impl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.mtk.salesreportgenerator.adapter.PdfAdapter;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component("openPdfAdapter")
public class OpenPdfAdapter implements PdfAdapter
{
	@Override
	public void generate(String filename, String content)
	{

		Document document = new Document();
		try
		{
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			document.add(new Paragraph(content));
		}
		catch (DocumentException | IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			document.close();
		}
	}
}
