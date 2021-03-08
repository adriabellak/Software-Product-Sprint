package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.ArrayList; 

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    // Create ArrayList and add messages
    ArrayList<String> messages = new ArrayList<String>();
    String msg1 = "message 1";
    String msg2 = "message 2";
    String msg3 = "message 3";
    String msg4 = "message 4";
    String msg5 = "message 5";
    messages.add(msg1);
    messages.add(msg2);
    messages.add(msg3);
    messages.add(msg4);
    messages.add(msg5);

    // Convert to json using Gson
    Gson gson = new Gson();
    String json = gson.toJson(messages);

    //
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}
