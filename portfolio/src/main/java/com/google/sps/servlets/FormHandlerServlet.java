package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String textValue = request.getParameter("text-input");
    String nameValue = request.getParameter("name-input");

    // Print the value so you can see it in the server logs.
    // Write the value to the response so the user can see it.
    // Check if a name was given
    if (nameValue != null && !nameValue.trim().isEmpty()){
      System.out.println(nameValue + " submitted: " + textValue);
      response.getWriter().println(nameValue + ", you submitted: " + textValue);
    }
    else {
      System.out.println("Somebody (anonymously) submitted: " + textValue);
      response.getWriter().println("You submitted: " + textValue);
    }
  }
}