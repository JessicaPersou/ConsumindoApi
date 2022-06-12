import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Scanner;

public class ClientHttp {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Scanner apiKey = new Scanner(System.in);
		System.out.println("Informe sua APIKey: ");
		String key = apiKey.next();	
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + key + "/"))
				.timeout(Duration.ofSeconds(5)) //duranção de tempo da resposta
				.build();
		HttpClient client = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(5))//tempo de conexao
				.followRedirects(Redirect.NORMAL) // redirecionamento se não for problema de segurança
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
		//System.out.println(response.statusCode());
		//System.out.println(response.headers());
		//System.out.println(response.version());



	}

}
