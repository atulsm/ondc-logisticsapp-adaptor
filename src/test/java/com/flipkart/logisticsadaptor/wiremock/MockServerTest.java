package com.flipkart.logisticsadaptor.wiremock;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockServerTest extends TestCase {

    MockServer mockServer = new MockServer();

    @Test
    public static void testMockServer() throws InterruptedException {
        Thread.sleep(50000);
    }
}
