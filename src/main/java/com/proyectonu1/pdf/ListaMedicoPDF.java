package com.proyectonu1.pdf;

/*import java.awt.Color;
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
import com.proyectonu1.app.entidades.MedicoDocument;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;*/

@Component("lista-medico")
public class ListaMedicoPDF /*extends AbstractPdfView*/ {
	
	/*@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<MedicoDocument> listadoMedicos = (List<MedicoDocument>) model.get("medico");
		
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
				
		celda = new PdfPCell(new Phrase("Médico asociados - Listado", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(55, 205, 205));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		//Tabla para mostrar el listado de medicos
		PdfPTable tablaUsuarios = new PdfPTable(6);
		tablaUsuarios.setWidths(new float[] {1.5f, 2f, 3f, 2.5f, 1.5f, 1.5f});
		
		celda = new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Apellido", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Correo", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Especialidad", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Sede", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Usuario", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsuarios.addCell(celda);
		
		for(MedicoDocument usuario : listadoMedicos) {
			celda = new PdfPCell(new Phrase(usuario.getNombre().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getApellido().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getEmail().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getEspecialidad().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getEps().getSede().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getUsuario().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
		}
		
		document.add(tablaTitulo);
		document.add(tablaUsuarios);	
	}*/
}
