package dev.heowc.springuap.resolver;

import org.springframework.core.MethodParameter;
import ua_parser.Parser;
import ua_parser.UserAgent;

public class UserAgentArgumentResolver extends AbstractUapArgumentResolver<UserAgent> {

    public UserAgentArgumentResolver(Parser parser) {
        super(parser);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return UserAgent.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    UserAgent parse(String userAgent) {
        return parser().parseUserAgent(userAgent);
    }
}
