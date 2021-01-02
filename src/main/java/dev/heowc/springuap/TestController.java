package dev.heowc.springuap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua_parser.Client;
import ua_parser.Device;
import ua_parser.OS;
import ua_parser.UserAgent;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public boolean test(Client client, UserAgent userAgent, OS os, Device device) {
        logger.info("Client: {}", client);
        logger.info("OS: {}", os);
        logger.info("Device: {}", device);
        logger.info("UserAgent: {}", userAgent);
        return client.os.equals(os) &&
                client.device.equals(device) &&
                client.userAgent.equals(userAgent);
    }
}
