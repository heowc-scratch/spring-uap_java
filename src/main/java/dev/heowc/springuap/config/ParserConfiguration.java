package dev.heowc.springuap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import ua_parser.Parser;

@Configuration(proxyBeanMethods = false)
class ParserConfiguration {

    @Bean
    Parser parser(@Value("${uap-java.yaml.path:}") String yamlPath) {
        if (StringUtils.hasText(yamlPath)) {
            return new Parser(ParserConfiguration.class.getResourceAsStream(yamlPath));
        } else {
            return new Parser();
        }
    }

}
