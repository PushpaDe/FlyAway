

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String imagePath;
	
	public void init()
	{
		this.imagePath = "/FlyAway/src/main/webapp/Images/FlyAwayTitle.jpg";
	}
	
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String requestedImage = request.getPathInfo();
		if(requestedImage==null)
		{
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
		if(!image.exists())
		{
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		String ContentType = getServletContext().getMimeType(image.getName())
		if(contentType == null || !contentType.startWith("image"))
		{
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		response.reset();
		response.setContentType(ContentType);
		response.setHeader("Content-Length", String.valueOf(image.length()));
		
		Files.copy(image.toPath(), response.getOutputStream());
	}

}
