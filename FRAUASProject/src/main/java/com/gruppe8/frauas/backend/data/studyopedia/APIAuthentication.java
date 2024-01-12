package studyopedia;
//Import of necessary Java classes for handling input/output and networking 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Define a class named APIAuthentication
public class APIAuthentication {
	
	//Define constants for the API URL, which acts as a base, and authentication token
	private static final String API_URL = "https://dronesim.facets-labs.com/api/";
	private static final String TOKEN = "25d3818e0d0fb9288a1be8158fa58ecd4efc8ef9";
	
	//Method to fetch data from the API given a specific endpoint
	public static String fetchData(String endpoint) {
		try {
			//Setup URL for ApI request by combining the base API URL, endpoint and specifying JSON format
			URL url = new URL(API_URL + endpoint + "?format=json");
			//Open a connection to the specified URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//Getter methode
			connection.setRequestMethod("GET");
			
			//Set Auth. header with token for the authentication
			connection.setRequestProperty("Authorization", "Token " + TOKEN);
			//Get HTTP Response code after request
			int responseCode = connection.getResponseCode();
			
			//Check if request was successful (HTTP_OK)
			if(responseCode == HttpURLConnection.HTTP_OK) {
				//Read response
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				
				//Read each line of the response and append it to StringBuilder
				while((line = reader.readLine()) != null) {
					response.append(line);
				}
				
				reader.close();
				//Process teh JSON response as needed
				System.out.println(response.toString());
			} else {
				//Error handling
				System.out.println("Error: " + responseCode);
			}
			//Cut Connection
			connection.disconnect();
			
		} catch (Exception e) {
			//Print the stack trace in case of any exception during the execution
			e.printStackTrace();
		}
		return null;
	}
}
