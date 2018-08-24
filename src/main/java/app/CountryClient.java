package app;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {
	
	public GetCountryResponse getCountry(String country) {
		
		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);
		
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		
		return response;
	}
	
}
