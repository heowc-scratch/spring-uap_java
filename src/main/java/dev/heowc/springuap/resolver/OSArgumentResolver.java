package dev.heowc.springuap.resolver;

import org.springframework.core.MethodParameter;
import ua_parser.OS;
import ua_parser.Parser;

public class OSArgumentResolver extends AbstractUapArgumentResolver<OS> {

    public OSArgumentResolver(Parser parser) {
        super(parser);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return OS.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    OS parse(String userAgent) {
        return parser().parseOS(userAgent);
    }
}
