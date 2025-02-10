package com.example.spring.soap;


import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ScoreEndpoint {

	@PayloadRoot(namespace = "http://soap.spring.example.com/", localPart = "getScoreRequest")
	@ResponsePayload
	public Source  getScore(@RequestPayload GetScoreRequest request) throws IOException {
		
		// Load the XML file as a resource
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(request.getUser()+".xml");
        
        if (inputStream == null) {
            throw new IOException("XML file not found in resources.");
        }
        
        // Create a StreamSource to return the raw XML content as a response
        return new StreamSource(inputStream);
        
       
		
		/*Score score = new Score();
		if (request.getUser().equalsIgnoreCase("Scrumtuous")) {
			score.setWins(100);
		} else {
			score.setWins(99);
			score.setLosses(66);
			score.setTies(7);
		}
		GetScoreResponse response = new GetScoreResponse();
		response.setScore(score);
		return response;
	}*/
	}
}

