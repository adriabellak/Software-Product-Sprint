package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user-song")
public class SongFromUser extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String title = request.getParameter("title-input");
    String artist = request.getParameter("artist-input");

    response.getWriter().println("Thanks for the recommendation!");

    // Datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Song");
    FullEntity songEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("title", title)
            .set("artist", artist)
            .build();
    datastore.put(songEntity);
  }
}