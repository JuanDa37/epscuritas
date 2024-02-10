package com.proyectonu1.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.proyectonu1.app.entidades.eps;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("lista-eps")
public class ListaEpsPDF /*extends AbstractPdfView*/{
	/*@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<eps> listadoEps = (List<eps>) model.get("eps");
		
		//Fuentes, tamaños y colores para cada sección
		Font fuenteTitulo = FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Color.WHITE);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Color.BLACK);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 40, 5);
		document.open();
		PdfPCell celda = null;
		
		//Tabla para el titulo del Pdf
		PdfPTable tablaTitulo = new PdfPTable(1);				
				
		celda = new PdfPCell(new Phrase("Ubicaciones EPS - Listado", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(55, 205, 205));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		//Tabla para mostrar el listado de usuarios
		PdfPTable tablaUsuarios = new PdfPTable(5);
		tablaUsuarios.setWidths(new float[] {1.5f, 2f, 1.5f, 2f, 2f});
		
		celda = new PdfPCell(new Phrase("Sede", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Dirección", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Teléfono", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Horario", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Horario (Fin de semana)", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		for(eps eps : listadoEps) {
			celda = new PdfPCell(new Phrase(eps.getSede().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(eps.getDireccion().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(eps.getTelefono().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(eps.getHorario().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(eps.getHorariofin().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
		}
		
		document.add(tablaTitulo);
		document.add(tablaUsuarios);	
	}*/
}
