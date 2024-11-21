package com.mtk.salesreportgenerator.adapter.impl;

import com.mtk.salesreportgenerator.adapter.PdfAdapter;
import com.mtk.salesreportgenerator.dto.JasperData;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

@Component("jasperPdfAdapter")
public class JasperPdfAdapter implements PdfAdapter
{
	@Override
	public void generate(String filename, String content)
	{
		try
		{
			InputStream templateStream = getClass().getResourceAsStream(
				"/templates/jasper_template.jrxml");
			if (templateStream == null)
			{
				throw new RuntimeException("Template not found: /templates/jasper_template.jrxml");
			}

			JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
			List<JasperData> dataList = List.of(new JasperData(content));
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(),
				dataSource);

			try (FileOutputStream outputStream = new FileOutputStream(filename))
			{
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
