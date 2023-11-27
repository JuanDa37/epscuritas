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
import com.proyectonu1.app.entidades.historiaClinica;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("miscitasmedico")
public class ListaHistoriaClinicaUsuarioPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<historiaClinica> listadohistoriaClinica = (List<historiaClinica>) model.get("historiaClinica");
		
		//Fuentes, tamaños y colores para cada sección
		Font fuenteTitulo = FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Color.WHITE);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Color.BLACK);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);
		
		document.setPageSize(PageSize.A3.rotate());
		document.setMargins(-20, -20, -20, -20);
		document.open();
		PdfPCell celda = null;
		
		//Tabla para el titulo del Pdf
		PdfPTable tablaTitulo = new PdfPTable(1);				
				
		celda = new PdfPCell(new Phrase("Historias Clínicas - Listado", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(55, 205, 205));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		//Tabla para mostrar el listado de usuarios
		PdfPTable tablaUsuarios = new PdfPTable(19);
		tablaUsuarios.setWidths(new float[] {1.5f, 2.2f, 2.4f, 2.2f, 1.8f, 2.2f, 2f, 2.2f, 2f, 2.2f, 2.2f, 2.2f, 2f, 2f, 2f, 2f, 2.7f, 2f, 2f});
		
		celda = new PdfPCell(new Phrase("Fecha", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Motivo Consulta", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Cardiovasculares", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Pulmonares", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Digestivos", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Diabetes", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Renales", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Quirúrgicos", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("A. Transfusionales", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Alergías", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Alcoholismo", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Tabaquismo", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Inmunizaciones", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Enfermedad Actual", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Toma Medicamentos", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Medicamentos recomendados", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Recomendaciones", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Paciente", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Doctor", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(237, 237, 237));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(3);
		tablaUsuarios.addCell(celda);
		
		for(historiaClinica HClinica : listadohistoriaClinica) {
			celda = new PdfPCell(new Phrase(HClinica.getFecha().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getMotivoDeLaConsulta().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesCardiobasculares().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesPulmonares().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesDigestivos().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesDiabetes().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesRenales().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesQuirurgicos().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAntecedentesTransfusiones().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAlergicos().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getAlcoholismo().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getTabaquismo().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getInmunizaciones().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getEnfermedadActual().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getMedicamentos().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getMedicamentosRecomendados().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			celda = new PdfPCell(new Phrase(HClinica.getRecomendaciones().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			String nombreCompletoU = HClinica.getUsuario().getNombre() + " " + HClinica.getUsuario().getApellido();
			celda = new PdfPCell(new Phrase(nombreCompletoU, fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
			
			String nombreCompletoM = HClinica.getMedicos().getNombre() + " " + HClinica.getMedicos().getApellido();
			celda = new PdfPCell(new Phrase(nombreCompletoM, fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsuarios.addCell(celda);
		}
		
		document.add(tablaTitulo);
		document.add(tablaUsuarios);	
	}
}
