package com.mtk.salesreportgenerator.factory;

import com.mtk.salesreportgenerator.command.PdfCommand;
import com.mtk.salesreportgenerator.command.impl.JasperPdfCommand;
import com.mtk.salesreportgenerator.command.impl.OpenPdfCommand;
import com.mtk.salesreportgenerator.enums.PdfGeneratorType;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PdfCommandFactory
{

	private final Map<PdfGeneratorType, PdfCommand> commandMap = new EnumMap<>(PdfGeneratorType.class);

	@Autowired
	public PdfCommandFactory(List<PdfCommand> commands)
	{
		for (PdfCommand command : commands)
		{
			if (command instanceof OpenPdfCommand)
			{
				commandMap.put(PdfGeneratorType.OPEN_PDF, command);
			}
			else if (command instanceof JasperPdfCommand)
			{
				commandMap.put(PdfGeneratorType.JASPER, command);
			}
		}
	}

	public PdfCommand getCommand(PdfGeneratorType type)
	{
		if (!commandMap.containsKey(type))
		{
			throw new IllegalArgumentException("Invalid PDF type: " + type);
		}
		return commandMap.get(type);
	}
}