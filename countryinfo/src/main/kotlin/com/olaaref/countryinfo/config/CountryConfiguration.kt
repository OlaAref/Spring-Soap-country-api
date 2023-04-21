package com.olaaref.countryinfo.config

import com.olaaref.countryinfo.soap.CountryClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@Configuration
class CountryConfiguration {

    @Bean("countryMarshaller")
    fun marshaller(): Jaxb2Marshaller {
        var marshaller = Jaxb2Marshaller()
        marshaller.setPackagesToScan("com.olaaref.countryinfo.stubs")
        return marshaller
    }

    @Bean
    fun countryClient(@Qualifier("countryMarshaller") marshaller: Jaxb2Marshaller): CountryClient{
        var countryClient =  CountryClient()
        countryClient.marshaller = marshaller
        countryClient.unmarshaller = marshaller
        return countryClient
    }
}