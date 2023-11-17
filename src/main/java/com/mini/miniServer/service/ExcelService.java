package com.mini.miniServer.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mini.miniServer.domain.Common;
import com.mini.miniServer.dto.response.PageRes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExcelService {
	
	// 엑셀 다운로드 요청
	public void reqExcelDownload(HttpServletRequest request, HttpServletResponse response, PageRes<?> data) throws Exception{
		
		String fileName = "tempName";
		OutputStream outs = response.getOutputStream();
		
		String encFileName = fileName;
		log.info("[" + fileName + "] 엑셀 다운로드 시작.");
		
		try {
			Workbook workbook = null;
			
			workbook = excelDownload(data);
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encFileName + ".xlsx\"");
			
			// 엑셀 출력
			workbook.write(outs);
		} catch (Exception e) {
			log.error("[" + fileName + "] 엑셀 다운로드 도중 오류가 발생했습니다. : {}", e);
			e.printStackTrace();
			
			response.reset();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pout = response.getWriter();
			pout.println("<script type=\"text/javascript\">");
			pout.println("alert('[IOException]  [" + fileName
					+ "] 엑셀 다운로드 도중 오류가 발생했습니다.\\n시스템 관리자에게 문의 바랍니다.');history.go(-1);");
			pout.println("</script>");
			pout.flush();
		} finally {
			log.info("[" + fileName + "] 엑셀 다운로드 종료.");
			if (outs != null)
				outs.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
		
	}
	
	public Workbook excelDownload(PageRes<?> data) {
		Workbook workbook = new XSSFWorkbook();
		Row row = null;
		Cell cell = null;
		
		Sheet sheet = workbook.createSheet("시트1");
		String[] headerKey = { "id", "username", "password", "email"};
		
		CellStyle headerStyle = CellStyleSetting(workbook, "header"); 
		CellStyle dataStyle = CellStyleSetting(workbook, "data");
		
		row = sheet.createRow(0);
		
		for (int i = 0; i < headerKey.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerKey[i]);
			cell.setCellStyle(headerStyle);
		}
		
		for (int i = 0; i < data.getList().size(); i++) { // 데이터 구성
			row = sheet.createRow(i + 1);
			int cellIdx = 0; 
			
			Common vo = (Common) data.getList().get(i);
			System.out.println(">>> " + vo);
			cell = row.createCell(cellIdx++);
			cell.setCellValue(vo.getId());
			cell.setCellStyle(dataStyle);
			
			cell = row.createCell(cellIdx++);
			cell.setCellValue(vo.getUsername());
			cell.setCellStyle(dataStyle);
			
			cell = row.createCell(cellIdx++);
			cell.setCellValue(vo.getPassword());
			cell.setCellStyle(dataStyle);
			
			cell = row.createCell(cellIdx++);
			cell.setCellValue(vo.getEmail());
			cell.setCellStyle(dataStyle);
		}
		
		// 셀 넓이 자동 조정
		for (int i = 0; i < headerKey.length; i++) {
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, sheet.getColumnWidth(i));
		}
		
		return workbook;
	}
	
	public CellStyle CellStyleSetting(Workbook workbook, String kind) {
		CellStyle cellStyle = workbook.createCellStyle();

		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		if (kind.equals("header")) {
			// 배경색 회색
			cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}

		// 데이터는 가운데 정렬
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 중앙 정렬

		// 폰트 설정
		Font fontOfGothic = workbook.createFont();
		fontOfGothic.setFontName("맑은 고딕");
		cellStyle.setFont(fontOfGothic);

		return cellStyle;
	}
	
	public void processExcelFile(MultipartFile file) { 
		
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next(); 
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // 셀에서 데이터 추출
                    switch (cell.getCellType()) {
                        case STRING: 
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print((int)cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println(); // 다음 행으로 이동
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
