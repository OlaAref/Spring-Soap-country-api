package com.olaaref.countryinfo.soap

import com.olaaref.countryinfo.soap.response.*
import com.olaaref.countryinfo.stubs.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.ws.client.core.support.WebServiceGatewaySupport

/**
 * A web service client for retrieving information about countries using SOAP-based web services.
 *
 * This class extends Spring's WebServiceGatewaySupport class to provide functionality for calling web services.
 * It is annotated with @Service and @Component to indicate that it is a Spring-managed bean that can be autowired
 * into other Spring components.
 */
@Service
@Component("CountryInfo")
class CountryClient: WebServiceGatewaySupport(){

    @Value("\${country.endpoint.url}")
    val url: String = ""

    /**
     * This function calls a web service to retrieve the capital city of a country by its ISO code.
     * @param code The ISO code of the country.
     * @return The capital city of the country.
     */
    fun getCapitalCity(code: String?): String? {
        val request = CapitalCity()
        request.sCountryISOCode = code
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CapitalCityResponse
        return response.capitalCityResult
    }

    /**
     * This function calls a web service to retrieve a list of countries that use a specific currency.
     * @param currencyCode The ISO code of the currency.
     * @return A list of countries that use the specified currency.
     */
    fun getCountryByCurrency(currencyCode: String): List<CountryInfoByCurrencyResponse>{
        val request = CountriesUsingCurrency()
        request.sisoCurrencyCode = currencyCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CountriesUsingCurrencyResponse
        val result = mutableListOf<CountryInfoByCurrencyResponse>()
        response.countriesUsingCurrencyResult.tCountryCodeAndName.forEach {
            result.add(CountryInfoByCurrencyResponse(it.sisoCode, it.sName))
        }
        return result
    }

    /**
     * This function calls a web service to retrieve the currency of a country by its ISO code.
     * @param countryCode The ISO code of the country.
     * @return The currency of the country.
     */
    fun getCurrency(countryCode: String): CountryInfoCurrencyResponse {
        val request = CountryCurrency()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  CountryCurrencyResponse
        return CountryInfoCurrencyResponse(response.countryCurrencyResult.sisoCode, response.countryCurrencyResult.sName)
    }

    /**
     * This function calls a web service to retrieve the phone code of a country by its ISO code.
     * @param countryCode The ISO code of the country.
     * @return The phone code of the country.
     */
    fun getPhoneCode(countryCode: String): String{
        val request = CountryIntPhoneCode()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  CountryIntPhoneCodeResponse
        return response.countryIntPhoneCodeResult
    }

    /**
     * This function calls a web service to retrieve the ISO code of a country by its name.
     * @param countryName The name of the country.
     * @return The ISO code of the country.
     */
    fun getCountryCode(countryName: String): String{
        val request = CountryISOCode()
        request.sCountryName = countryName
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  CountryISOCodeResponse
        return response.countryISOCodeResult
    }

    /**
     * Returns the country name associated with the given country code.
     *
     * This function calls a web service to retrieve the country name using the given country code.
     *
     * @param countryCode The ISO code for the country.
     * @return The name of the country.
     */
    fun getCountryNameByCode(countryCode: String): String{
        val request = CountryName()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CountryNameResponse
        return response.countryNameResult
    }

    /**
     * Returns the currency name associated with the given currency code.
     *
     * This function calls a web service to retrieve the currency name using the given currency code.
     *
     * @param currencyCode The ISO code for the currency.
     * @return The name of the currency.
     */
    fun getCurrencyByCode(currencyCode: String): String{
        val request = CurrencyName()
        request.sCurrencyISOCode = currencyCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CurrencyNameResponse
        return response.currencyNameResult
    }

    /**
     * Returns the full information about the country associated with the given country code.
     *
     * This function calls a web service to retrieve the full information about the country using the given country code.
     *
     * @param countryCode The ISO code for the country.
     * @return The full information about the country.
     */
    fun getFullCountryInfo(countryCode: String): FullCountryInformationRespone{
        val request = FullCountryInfo()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  FullCountryInfoResponse
        return response.fullCountryInfoResult.let {
            FullCountryInformationRespone(it.sisoCode, it.sName, it.sCapitalCity, it.sPhoneCode,
            it.sContinentCode, it.sCurrencyISOCode, it.sCountryFlag,
                it.languages.tLanguage.map { lang -> LanguageResponse(lang.sisoCode, lang.sName) })
        }

    }

    /**
     * Returns the full information about all countries.
     *
     * This function calls a web service to retrieve the full information about all countries.
     *
     * @return A list of full information about all countries.
     */
    fun getAllCountries(): List<FullCountryInformationRespone>{
        val request = FullCountryInfoAllCountries()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  FullCountryInfoAllCountriesResponse

        return response.fullCountryInfoAllCountriesResult.tCountryInfo.map {countryInfo ->
            FullCountryInformationRespone(countryInfo.sisoCode, countryInfo.sName, countryInfo.sCapitalCity, countryInfo.sPhoneCode,
                countryInfo.sContinentCode, countryInfo.sCurrencyISOCode, countryInfo.sCountryFlag,
                countryInfo.languages.tLanguage.map { lang -> LanguageResponse(lang.sisoCode, lang.sName) })
        }

    }

    /**
     * Returns the ISO code for the language associated with the given language name.
     *
     * This function calls a web service to retrieve the ISO code for the language using the given language name.
     *
     * @param languageName The name of the language.
     * @return The ISO code for the language.
     */
    fun getLanguageCode(languageName: String): String{
        val request = LanguageISOCode()
        request.sLanguageName = languageName
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  LanguageISOCodeResponse
        return response.languageISOCodeResult
    }

    /**
     * Returns the name of the language associated with the given ISO code.
     *
     * This function calls a web service to retrieve the name of the language using the given ISO code.
     *
     * @param languageCode The ISO code for the language.
     * @return The name of the language.
     */
    fun getLanguageName(languageCode: String): String{
        val request = LanguageName()
        request.sisoCode = languageCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as LanguageNameResponse
        return response.languageNameResult
    }

    /**
     * Returns the list of all continents.
     *
     * This function calls a web service to retrieve the list of all continents.
     *
     * @return A list of all continents.
     */
    fun getAllContinents(): List<ContinentResponse>{
        val request = ListOfContinentsByName()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  ListOfContinentsByNameResponse
        return response.listOfContinentsByNameResult.tContinent.map {
            ContinentResponse(it.sCode, it.sName)
        }
    }

    /**
     * Returns the list of all currencies.
     *
     * This function calls a web service to retrieve the list of all currencies.
     *
     * @return A list of all currencies.
     */
    fun getAllCurrencies(): List<CurrencyResponse>{
        val request = ListOfCurrenciesByName()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  ListOfCurrenciesByNameResponse
        return response.listOfCurrenciesByNameResult.tCurrency.map {
            CurrencyResponse(it.sisoCode, it.sName)
        }
    }

    /**
     * Returns the list of all languages.
     *
     * This function calls a web service to retrieve the list of all languages.
     *
     * @return A list of all languages.
     */
    fun getAllLanguages(): List<LanguageResponse>{
        val request = ListOfLanguagesByName()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  ListOfLanguagesByNameResponse
        return response.listOfLanguagesByNameResult.tLanguage.map {
            LanguageResponse(it.sisoCode, it.sName)
        }
    }
}