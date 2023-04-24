package com.olaaref.countryinfo.config

import com.olaaref.countryinfo.soap.CountryClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller

/**
 * A Spring configuration class for configuring beans related to country information.
 *
 * This class provides configuration for the Jaxb2Marshaller and CountryClient beans used for fetching
 * country information via SOAP-based web services. It is annotated with @Configuration to indicate that
 * it is a Spring configuration class, and contains two @Bean methods for configuring the Jaxb2Marshaller
 * and CountryClient beans. The Jaxb2Marshaller bean is used for marshalling and unmarshalling XML data,
 * while the CountryClient bean is used for making SOAP requests to the web service.
 */
@Configuration
class CountryConfiguration {

    /**
     * Configures a Jaxb2Marshaller bean for marshalling and unmarshalling XML data.
     *
     * This method configures a Jaxb2Marshaller bean for use by the CountryClient bean. The base package
     * for the marshaller is set to "com.olaaref.countryinfo.stubs".
     *
     * @return A Jaxb2Marshaller bean.
     */
    @Bean("countryMarshaller")
    fun marshaller(): Jaxb2Marshaller {
        var marshaller = Jaxb2Marshaller()
        marshaller.setPackagesToScan("com.olaaref.countryinfo.stubs")
        return marshaller
    }

    /**
     * Configures a CountryClient bean for making SOAP requests to the web service.
     *
     * This method configures a CountryClient bean for making SOAP requests to the web service. The
     * Jaxb2Marshaller bean used for marshalling and unmarshalling XML data is provided via dependency
     * injection using the @Qualifier annotation. The CountryClient bean is configured with the same
     * marshaller for both marshalling and unmarshalling.
     *
     * @param marshaller The Jaxb2Marshaller bean used for marshalling and unmarshalling XML data.
     * @return A CountryClient bean.
     */
    @Bean
    fun countryClient(@Qualifier("countryMarshaller") marshaller: Jaxb2Marshaller): CountryClient{
        var countryClient =  CountryClient()
        countryClient.marshaller = marshaller
        countryClient.unmarshaller = marshaller
        return countryClient
    }
}