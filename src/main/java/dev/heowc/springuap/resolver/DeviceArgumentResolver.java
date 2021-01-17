package dev.heowc.springuap.resolver;

import org.springframework.core.MethodParameter;
import ua_parser.Device;
import ua_parser.Parser;

public class DeviceArgumentResolver extends AbstractUapArgumentResolver<Device> {

    public DeviceArgumentResolver(Parser parser) {
        super(parser);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Device.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    Device parse(String userAgent) {
        return parser().parseDevice(userAgent);
    }
}
