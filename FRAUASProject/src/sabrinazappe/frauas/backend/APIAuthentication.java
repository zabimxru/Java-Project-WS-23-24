package sabrinazappe.frauas.backend;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIAuthentication {
	private static final String API_URL = "https://dronesim.facetslaps.com/api/";
	private static final String TOKEN = "25d3818e0d0fb9288a1be8158fa58ecd4efc8ef9";
	
	public static String fetchData (String endpoint) {
		try {
		URL url = new URL(API_URL + endpoint + "?format=json");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Authorization", "Token " + TOKEN);
		
		int responseCode = connection.getResponseCode();
		
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader (new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			
			while((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			
			System.out.println(response.toString());
		} else {
			System.out.println("Error: " + responseCode);
		}
		connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			}
		return null;
		}
}
