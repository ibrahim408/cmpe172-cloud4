package com.Weather.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Weather.Entities.*;
import com.Weather.Services.*;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
	private static final long serialversionUID = 1L;

	public WeatherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("q");
		Root weatherInfoObj = OWMService.getWeatherInfo(input);
		//		if (weatherInfoObj != null) {
		//			System.out.println("works");
		//		} else {
		//			System.out.println("did not work");
		//		}
		if (weatherInfoObj != null) {
			//			List<HeWeatherDataService30> weatherList = weatherInfoObj.getHeWeatherDataService30();
			//			if (weatherList != null) {
			StringBuider outContent = new StringBuilder();
			outContent.append("<html><head><title>Weather Data</title></head>"
					+ "<body>"
					+ "<form action=\"weather\" method=\"GET\">"
					+ "<select name=\"q\">"
					+ "<option value=\"Caracas\">Caracas</option>"
					+ "</select>"
					+ "<input type=\"submit\" value=\"Submit\">"
					+ "</form>");
			outContent.append(weatherList.get(0).getBasic().getCity());
			outContent.append("<br/>");
			outContent.append("</body></html>");ss
		} else {
			System.out.println("broekn");
		}
	}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
}
}
