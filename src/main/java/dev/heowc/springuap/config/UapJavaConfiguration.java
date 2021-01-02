package dev.heowc.springuap.config;

import dev.heowc.springuap.resolver.ClientArgumentResolver;
import dev.heowc.springuap.resolver.DeviceArgumentResolver;
import dev.heowc.springuap.resolver.OSArgumentResolver;
import dev.heowc.springuap.resolver.UserAgentArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ua_parser.Parser;

import java.util.List;

@Configuration(proxyBeanMethods = false)
class UapJavaConfiguration implements WebMvcConfigurer {

    private final Parser parser;

    UapJavaConfiguration(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ClientArgumentResolver(parser));
        resolvers.add(new DeviceArgumentResolver(parser));
        resolvers.add(new OSArgumentResolver(parser));
        resolvers.add(new UserAgentArgumentResolver(parser));
    }
}
