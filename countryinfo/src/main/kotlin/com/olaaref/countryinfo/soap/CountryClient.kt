package com.olaaref.countryinfo.soap

import com.olaaref.countryinfo.soap.response.*
import com.olaaref.countryinfo.stubs.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.ws.client.core.support.WebServiceGatewaySupport

@Service
@Component("CountryInfo")
class CountryClient: WebServiceGatewaySupport(){

    @Value("\${country.endpoint.url}")
    val url: String = ""

    fun getCapitalCity(code: String?): String? {
        val request = CapitalCity()
        request.sCountryISOCode = code
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CapitalCityResponse
        return response.capitalCityResult
    }

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

    fun getCurrency(countryCode: String): CountryInfoCurrencyResponse {
        val request = CountryCurrency()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  CountryCurrencyResponse
        return CountryInfoCurrencyResponse(response.countryCurrencyResult.sisoCode, response.countryCurrencyResult.sName)
    }

    fun getPhoneCode(countryCode: String): String{
        val request = CountryIntPhoneCode()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  CountryIntPhoneCodeResponse
        return response.countryIntPhoneCodeResult
    }

    fun getCountryCode(countryName: String): String{
        val request = CountryISOCode()
        request.sCountryName = countryName
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  CountryISOCodeResponse
        return response.countryISOCodeResult
    }

    fun getCountryNameByCode(countryCode: String): String{
        val request = CountryName()
        request.sCountryISOCode = countryCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CountryNameResponse
        return response.countryNameResult
    }

    fun getCurrencyByCode(currencyCode: String): String{
        val request = CurrencyName()
        request.sCurrencyISOCode = currencyCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as CurrencyNameResponse
        return response.currencyNameResult
    }

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

    fun getAllCountries(): List<FullCountryInformationRespone>{
        val request = FullCountryInfoAllCountries()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  FullCountryInfoAllCountriesResponse

        return response.fullCountryInfoAllCountriesResult.tCountryInfo.map {countryInfo ->
            FullCountryInformationRespone(countryInfo.sisoCode, countryInfo.sName, countryInfo.sCapitalCity, countryInfo.sPhoneCode,
                countryInfo.sContinentCode, countryInfo.sCurrencyISOCode, countryInfo.sCountryFlag,
                countryInfo.languages.tLanguage.map { lang -> LanguageResponse(lang.sisoCode, lang.sName) })
        }

    }

    fun getLanguageCode(languageName: String): String{
        val request = LanguageISOCode()
        request.sLanguageName = languageName
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  LanguageISOCodeResponse
        return response.languageISOCodeResult
    }

    fun getLanguageName(languageCode: String): String{
        val request = LanguageName()
        request.sisoCode = languageCode
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as LanguageNameResponse
        return response.languageNameResult
    }

    fun getAllContinents(): List<ContinentResponse>{
        val request = ListOfContinentsByName()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  ListOfContinentsByNameResponse
        return response.listOfContinentsByNameResult.tContinent.map {
            ContinentResponse(it.sCode, it.sName)
        }
    }

    fun getAllCurrencies(): List<CurrencyResponse>{
        val request = ListOfCurrenciesByName()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  ListOfCurrenciesByNameResponse
        return response.listOfCurrenciesByNameResult.tCurrency.map {
            CurrencyResponse(it.sisoCode, it.sName)
        }
    }

    fun getAllLanguages(): List<LanguageResponse>{
        val request = ListOfLanguagesByName()
        val response = webServiceTemplate.marshalSendAndReceive(url, request) as  ListOfLanguagesByNameResponse
        return response.listOfLanguagesByNameResult.tLanguage.map {
            LanguageResponse(it.sisoCode, it.sName)
        }
    }
}