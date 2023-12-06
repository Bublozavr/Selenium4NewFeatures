package Selenium4Tests;

import common.CommonTest;
import common.Log;
import common.netPanel.NetworkCollector;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Response;
import org.openqa.selenium.devtools.v113.network.model.Request;
import org.testng.annotations.Test;
import java.util.Optional;

public class CheckDevTools extends CommonTest {

    DevTools devTools;

    @Test
    public void seleniumTest() {
        // Initialization and creation of DevTools session
        devTools = createDevToolsObject();
        devTools.createSession();

        // Enable network interception using DevTools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        NetworkCollector collector = new NetworkCollector();
        // Add a listener for the "requestWillBeSent" event
        devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
            Request request = requestConsumer.getRequest();
            String requestId = requestConsumer.getRequestId().toString();
            collector.collectUrl(request.getUrl(), requestId);
            collector.collectMethod(request.getMethod(), requestId);
            collector.collectHeaders(request.getHeaders().toString(), requestId);
        });

        devTools.addListener(Network.responseReceived(), requestConsumer -> {
            Response response = requestConsumer.getResponse();
            String requestId = requestConsumer.getRequestId().toString();
            String responseBody = devTools.send(Network.getResponseBody(requestConsumer.getRequestId())).getBody();
            collector.collectStatus(response.getStatus().toString(), requestId);
            collector.collectResponseBody(responseBody, requestId);
        });

        // Open the main entry point of the application
        app().mainPage.openEntryPoint();
        app().mainPage.closeCookiesMessageIfVisible();

        Log.info(String.valueOf(collector.getRequests().size()));

        devTools.close();
    }



}
