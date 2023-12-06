package common.netPanel;

import org.openqa.selenium.devtools.v113.network.model.Response;

import java.util.ArrayList;
import java.util.List;

public class NetworkCollector {

    public List<Request> getRequests() {
        return requests;
    }

    private List<Request> requests = new ArrayList<>();

    public synchronized void collectUrl(String url, String requestId){
        boolean isAlreadyPresent = requests.stream().anyMatch(request -> request.getId().equals(requestId));
        if(!isAlreadyPresent){
            Request newRequest = new Request();
            newRequest.setId(requestId);
            newRequest.setUrl(url);
            requests.add(newRequest);
        } else {
            requests.stream().filter(request -> request.getId().equals(requestId))
                    .findFirst().ifPresent(request -> request.setUrl(url));
        }
    }

    public synchronized void collectResponseBody(String responseBody, String requestId){
        boolean isAlreadyPresent = requests.stream().anyMatch(request -> request.getId().equals(requestId));
        if(!isAlreadyPresent){
            Request newRequest = new Request();
            newRequest.setId(requestId);
            newRequest.setResponseBody(responseBody);
            requests.add(newRequest);
        } else {
            requests.stream().filter(request -> request.getId().equals(requestId))
                    .findFirst().ifPresent(request -> request.setResponseBody(responseBody));
        }
    }

    public synchronized void collectStatus(String status, String requestId){

        boolean isAlreadyPresent = requests.stream().anyMatch(request -> request.getId().equals(requestId));
        if(!isAlreadyPresent){
            Request newRequest = new Request();
            newRequest.setId(requestId);
            newRequest.setStatus(status);
            requests.add(newRequest);
        } else {
            requests.stream().filter(request -> request.getId().equals(requestId))
                    .findFirst().ifPresent(request -> request.setStatus(status));
        }
    }

    public synchronized void collectMethod(String method, String requestId){
        boolean isAlreadyPresent = requests.stream().anyMatch(request -> request.getId().equals(requestId));
        if(!isAlreadyPresent){
            Request newRequest = new Request();
            newRequest.setId(requestId);
            newRequest.setMethod(method);
            requests.add(newRequest);
        } else {
            requests.stream().filter(request -> request.getId().equals(requestId))
                    .findFirst().ifPresent(request -> request.setMethod(method));
        }
    }

    public synchronized void collectHeaders(String headers, String requestId){
        boolean isAlreadyPresent = requests.stream().anyMatch(request -> request.getId().equals(requestId));
        if(!isAlreadyPresent){
            Request newRequest = new Request();
            newRequest.setId(requestId);
            newRequest.setHeaders(headers);
            requests.add(newRequest);
        } else {
            requests.stream().filter(request -> request.getId().equals(requestId))
                    .findFirst().ifPresent(request -> request.setHeaders(headers));
        }
    }
}
