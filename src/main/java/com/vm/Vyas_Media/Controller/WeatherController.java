package com.vm.Vyas_Media.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vm.Vyas_Media.Entity.Weather;

@RestController
public class WeatherController {
	public String content;


	@GetMapping("/weather/current")
	@CrossOrigin(origins = "http://localhost:3000")
	public Weather current(@RequestParam(value = "location") String location) {
		String content;
		try {

			String url = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="
					+ "4e9c21c54475e8d23e01ea64fb2f7539";
			URL obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			content = response.toString();

		} catch (Exception e) {
			System.out.print("ERROR : " + e);
			return new Weather("Not Found", "Not Found", "Not Found", "Not Found", 0);
		}
		JSONObject root = new JSONObject(content);
		// coordinates
		// temperature-humidity-pressure
		JSONObject main = root.getJSONObject("main");
		// system
		JSONObject sys = root.getJSONObject("sys");
		// weather
		JSONArray wea = root.getJSONArray("weather");
		JSONObject weas = wea.getJSONObject(0);

		return new Weather(weas.getString("main"), weas.getString("description"), sys.getString("country"),
				root.getString("name"), main.getInt("temp") - 273);
	}

}
