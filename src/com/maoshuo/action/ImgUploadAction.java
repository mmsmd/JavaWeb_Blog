package com.maoshuo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ImgUploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String execute() throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		String callback=request.getParameter("CKEditorFuncNum");
		String expandedName="";
		if(uploadContentType.equals("image/pjpeg")||uploadContentType.equals("image/jpge")) {
			expandedName=".jpg";
		}else if(uploadContentType.equals("image/png")||uploadContentType.equals("image/x-png")) {
			expandedName=".png";
		}else if(uploadContentType.equals("image/gif")) {
			expandedName=".gif";
		}else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction("+callback
					+",'',"+"'文件格式不正确（必须为.jpg/.png/.gif)');");
			out.println("</script>");
			return null;
		}if(upload.length()>600*1024) {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction("+callback
					+",'',"+"'文件大小不得大于600k');");
			out.println("</script>");
			return null;
		}
		InputStream is=new FileInputStream(upload);
		String uploadPath=ServletActionContext.getServletContext().getRealPath("img/uploadImg");
		String fileName =java.util.UUID.randomUUID().toString();
		fileName += expandedName;
		File file=new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
		}
		File toFile=new File(uploadPath,fileName);
		OutputStream os=new FileOutputStream(toFile);
		byte[]buffer=new byte[1024];
		int length=0;
		while((length=is.read(buffer))>0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();
		
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction("+callback
				+",'"+request.getContextPath()+"/img/uploadImg/"+fileName+"','';");
		out.println("</script>");
		return null;
	}
}
