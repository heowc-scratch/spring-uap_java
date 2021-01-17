package dev.heowc.springuap.resolver;

import org.springframework.core.MethodParameter;
import ua_parser.Client;
import ua_parser.Parser;

public class ClientArgumentResolver extends AbstractUapArgumentResolver<Client> {

    public ClientArgumentResolver(Parser parser) {
        super(parser);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Client.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    Client parse(String userAgent) {
        return parser().parse(userAgent);
    }
}
