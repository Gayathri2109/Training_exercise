package eyrest;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

@Path("test")
public class HelloWWW {

	@GET
	public void testMethod() {
		System.out.println("test method called...");
	}
	
	@GET
	@Path("test1")
	public void testMethod1() {
		System.out.println("test 1 method called...");
	}
	
	@GET
	@Path("sayHello")
	public Response sayHelloResponse() {
		
		return Response.status(200).entity("<h1>Welcome to REST</h1>").build();
	}
	
	@GET
	@Path("sayHello2/{uname}")
	public Response sayHelloResponse2(@PathParam("uname") String name) {
		
		return Response.status(200).entity("<h1>Welcome to REST</h1>"+name).build();
		
	}
	

	@GET
	@Path("sayHello3/{uname}/{myname}")
	public Response sayHelloResponse3(@PathParam("uname") String name, @PathParam("myname") String myname) {
		
		return Response.status(200).entity("<h1>Welcome to REST</h1>"+name+" "+myname).build();
		
	}
	

	@GET
	@Path("sayHello4")
	public Response sayHelloResponse4(@QueryParam("uname") String name, @QueryParam("myname") String myname) {
		
		return Response.status(200).entity("<h1>Welcome to REST</h1>"+name+" "+myname).build();
		
	}
	
	@GET
	@Path("sayHello5")
	public Response sayHelloResponse5(@Context UriInfo uriinfo) {
		String name = uriinfo.getQueryParameters().getFirst("uname");
		String myname = uriinfo.getQueryParameters().getFirst("myname");
		return Response.status(200).entity("<h1>Welcome to REST</h1>"+name+" "+myname).build();
		
	}
	
	@GET
	@Path("sayHello6")
	public Response sayHelloResponse6(@MatrixParam("jsessionid") String id) {
		
		return Response.status(200).entity("<h1>The id is......</h1>"+id).build();
		
	}
	
	@POST
	@Path("sayHello7")
	public Response sayHelloResponse7(@FormParam("uname") String name, @FormParam("upass") String myname) {
		
		return Response.status(200).entity("<h1>Welcome to REST</h1>"+name+" "+myname).build();
		
	}
	
	@GET
	@Path("/getFile")
	public Response getFileFromServer(@Context ServletContext application,@Context HttpServletRequest request) {
		String filepath=application.getRealPath("/WEB-INF/data.properties");
		File file=new File(filepath);
		ResponseBuilder response=Response.ok((Object)file);
		response.header("Content-Disposition", "attachment;filename=\"datacopy.properties\"");
		return response.build();
	}
	@GET
	@Path("/getImage")
	@Produces("image/jpg")
	public Response getImageFromServer(@Context ServletContext application) {
		String filepath=application.getRealPath("/WEB-INF/OIP.jpg");
		File file=new File(filepath);
		ResponseBuilder response=Response.ok((Object)file);
		response.header("Content-Disposition", "attachment;filename=\"imgcopy.jpg\"");
		return response.build();
	}
	
	@GET
	@Path("/getPdf")
	@Produces("application/pdf")
	
	public Response getPdfFromServer(@Context ServletContext application) {
		String filepath=application.getRealPath("/WEB-INF/sample.pdf");
		File file=new File(filepath);
		ResponseBuilder response=Response.ok((Object)file);
		response.header("Content-Disposition", "attachment;filename=\"pdfcopy.pdf\"");
		return response.build();
	}
}
