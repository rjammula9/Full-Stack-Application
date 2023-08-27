import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class Register
*/
//@jakarta.servlet.annotation.WebServlet("/Register")
public class Register extends jakarta.servlet.http.HttpServlet {
private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
 
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}
 
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    PrintWriter out = response.getWriter(); 

	System.out.println(request.getParameter("uname"));
	System.out.println(request.getParameter("password"));
	System.out.println(request.getParameter("email"));	
	System.out.println(request.getParameter("phone"));

    String uname = request.getParameter("uname");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    

    // Perform server-side validation
    if (uname.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
        // Handle validation error
       String errorMessage = "All fields are required.";
        request.setAttribute("error", errorMessage);
//      
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
//        dispatcher.forward(request, response);
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        out.println("<script type='text/javascript'>");
        out.println("alert(" + "'" + errorMessage + "'" + ");</script>");
        out.println("</head><body></body></html>");
        
    } else if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
        // Password validation: At least one number, one uppercase, one lowercase, 8 or more characters
        String errorMessage = "Password must contain at least one number, one uppercase letter, one lowercase letter, and be 8 or more characters long.";
        request.setAttribute("error", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
    } else if (!email.matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
        // Email validation: Must be a valid email format
        String errorMessage = "Invalid email format.";
        request.setAttribute("error", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
    } else if (!phone.matches("\\d{3}\\d{3}\\d{4}")) {
        // Phone validation: Must be in xxx-xxx-xxxx format
        String errorMessage = "Invalid phone number format. Use xxxxxxxxxx format.";
        request.setAttribute("error", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
    } else {
        // Insert data into the database
        RegisterDao registerDao = new RegisterDao();
        Member member = new Member(uname, password, email, phone);
        String result = registerDao.insert(member);

        if (result.equals("Data Entered Successfully")) {
        	response.getWriter().print(result);
        } else {
            String errorMessage = "An error occurred while processing your request.";
            request.setAttribute("error", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }
    }
}

}