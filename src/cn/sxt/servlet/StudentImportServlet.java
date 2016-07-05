package cn.sxt.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cn.sxt.service.StudentService;
import cn.sxt.service.impl.StudentServiceImpl;
import cn.sxt.vo.Student;

@WebServlet("/stuImport")
public class StudentImportServlet extends HttpServlet{
	StudentService stuService = new StudentServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload handler = new ServletFileUpload(factory);
		try {
			List<Student> students = new ArrayList<Student>();
			List<FileItem> list = handler.parseRequest(req);
			for(FileItem f:list){
				if(!f.isFormField()){
					InputStream is = f.getInputStream();
					//½âÎö ²¢Ìí¼Ó
					Workbook wb = WorkbookFactory.create(is);
				    Sheet sheet = wb.getSheetAt(0);
				    int rowCount = sheet.getPhysicalNumberOfRows();
				    for(int i=1;i<rowCount;i++){
				    	Row row = sheet.getRow(i);
				    	Student stu = new Student();
				    	
				    	stu.setId((int)row.getCell(0).getNumericCellValue());
				  
				    	stu.setName(row.getCell(1).getStringCellValue());
				    	stu.setAge((int)row.getCell(2).getNumericCellValue());
				    	stu.setSex((int)row.getCell(3).getNumericCellValue());
				    	stu.setStatusId((int)row.getCell(4).getNumericCellValue());
				    	stu.setIdCard(row.getCell(5).getStringCellValue());
				    	stu.setPhone(row.getCell(6).getStringCellValue());
				    	stu.setMayor(row.getCell(7).getStringCellValue());
				    	stu.setEducation(row.getCell(8).getStringCellValue());
				    	stu.setSchool(row.getCell(9).getStringCellValue());
				    	stu.setAddress(row.getCell(10).getStringCellValue());
				    	stu.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse(row.getCell(11).getStringCellValue()));
				    	System.out.println();
				    	students.add(stu);
				    }
				}
				stuService.add(students);
				
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("stu");
	}
}
