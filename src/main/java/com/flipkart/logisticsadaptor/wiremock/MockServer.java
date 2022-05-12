package com.flipkart.logisticsadaptor.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class MockServer {
    private WireMockServer wireMockServer;
    private static final int PORT = 8089;
    private static final FileSource JSON_PATH = new SingleRootFileSource("src/main/resources/ekart");

    public MockServer(){
        wireMockServer = new WireMockServer(wireMockConfig().port(PORT).fileSource(JSON_PATH));
        wireMockServer.start();
        System.out.println(JSON_PATH.listFilesRecursively());
    }
    @Override
    protected void finalize(){
        wireMockServer.stop();
    }

}
