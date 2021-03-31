package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConversionFiles.Sample;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	RequestProcessor rp;Properties prop;
	
	@Override
		public void init(ServletConfig config) throws ServletException {
		try {
			String file=config.getInitParameter("config");
			String dbfile=config.getInitParameter("dbconfig");
			String path=config.getServletContext().getRealPath(file);
			String dbpath=config.getServletContext().getRealPath(dbfile);
			config.getServletContext().setAttribute("path", path);
			
			//config.getServletContext().setAttribute("dbpath", dbpath);
			prop=new Properties();
			prop.load(new FileInputStream(dbpath));
			Class.forName(prop.getProperty("driver"));
			config.getServletContext().setAttribute("properties", prop);
			
			this.rp=new RequestProcessor();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do get called....");
		this.rp.process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Sample samp = Sample.get();
		String email = samp.getCustEmail();
		String no = samp.getCustNo();
		
		try {
			if(request.getParameter("button1") != null) {
				samp.generatePDF();
			}
			else if(request.getParameter("button2") != null) {
				samp.generateEXCEL();
			}
			else if(request.getParameter("button3") != null) {
				
				samp.sendEmail(email);
			
			}
			else if(request.getParameter("button4") != null) {
				samp.sendSMS(no);
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

