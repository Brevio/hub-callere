package br.com.bradesco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication()
public class HubGcqiApplication {
	public static void main(String[] args) {

		try {
			String encodeToString = Base64.getEncoder()
					.encodeToString(Files.readAllBytes(Paths.get(new File("./src/main/resources/image_multi.tif").toURI())));
			FileWriter w = new FileWriter(new File("image_multi.txt"));
			w.append(encodeToString);
			w.flush();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpringApplication.run(HubGcqiApplication.class, args);

	}
}
