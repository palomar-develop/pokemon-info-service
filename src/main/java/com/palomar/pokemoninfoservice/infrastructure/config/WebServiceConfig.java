package com.palomar.pokemoninfoservice.infrastructure.config;

import com.palomar.pokemoninfoservice.infrastructure.exception.PokemonNotFoundException;
import com.palomar.pokemoninfoservice.infrastructure.interceptor.SoapIpInterceptor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import java.util.Properties;
import java.util.List;

/**
 * Autor: josue.palomar
 * Fecha de creación: 12/09/25
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    public static final String POKEMON_SOAP_NAMESPACE = "http://pokemon.com/soap";

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public XsdSchema pokemonSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
    }

    @Bean(name = "pokemon")
    public DefaultWsdl11Definition defaultWsdl11DefinitionPokemon(XsdSchema pokemonSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PokemonPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(POKEMON_SOAP_NAMESPACE);
        wsdl11Definition.setSchema(pokemonSchema);
        return wsdl11Definition;
    }

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        SoapFaultMappingExceptionResolver resolver = new SoapFaultMappingExceptionResolver() {
            @Override
            protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
                if (ex instanceof PokemonNotFoundException) {
                    SoapFaultDetail detail = fault.addFaultDetail();
                    detail.addFaultDetailElement(new javax.xml.namespace.QName(POKEMON_SOAP_NAMESPACE, "errorCode"))
                            .addText("404");
                    detail.addFaultDetailElement(new javax.xml.namespace.QName(POKEMON_SOAP_NAMESPACE, "errorMessage"))
                            .addText(ex.getMessage());
                }
            }
        };
        Properties errorMappings = new Properties();
        errorMappings.setProperty(PokemonNotFoundException.class.getName(), "SERVER");
        resolver.setExceptionMappings(errorMappings);
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public EndpointInterceptor soapIpInterceptor() {
        return new SoapIpInterceptor();
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(soapIpInterceptor());
    }
}
