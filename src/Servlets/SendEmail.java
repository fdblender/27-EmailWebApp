package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean bodyIsHTML = false;

		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.port", 8081);
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.quitwait", "false");
		// NOTE: Session object is part of javax.mail.Session
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props);

		// get input parameters
		String to = request.getParameter("to");
		String from = request.getParameter("from");
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");

		// create the message object and set the subject and the body
		Message message = new MimeMessage(session);
		try {
			message.setSubject(subject);

			if (bodyIsHTML) {
				message.setContent(body, "text/html");
			} else {
				message.setText(body);
			}
			
			// address the message object
			Address fromAddress = new InternetAddress(from);
			Address toAddress = new InternetAddress(to);
			message.setFrom(fromAddress);
			message.setRecipient(Message.RecipientType.TO, toAddress);

			// send the message object
			Transport transport = session.getTransport();
			transport.connect();
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
