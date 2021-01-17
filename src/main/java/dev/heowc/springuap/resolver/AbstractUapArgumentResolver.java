package dev.heowc.springuap.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ua_parser.Parser;

abstract class AbstractUapArgumentResolver<T> implements HandlerMethodArgumentResolver {

    private final Parser parser;

    AbstractUapArgumentResolver(Parser parser) {
        this.parser = parser;
    }

    Parser parser() {
        return parser;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        final String userAgent = nativeWebRequest.getHeader("User-Agent");
        if (userAgent == null) {
            return null;
        }

        return parse(userAgent);
    }

    abstract T parse(String userAgent);
}
