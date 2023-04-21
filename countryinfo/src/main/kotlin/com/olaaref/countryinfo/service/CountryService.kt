package com.olaaref.countryinfo.service

import com.olaaref.countryinfo.soap.CountryClient
import com.olaaref.countryinfo.soap.response.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService @Autowired constructor(private val countryClient: CountryClient){

    fun getCapitalCity(countryCode: String): String? = countryClient.getCapitalCity(countryCode.uppercase())

    fun getCountryByCurrency(currencyCode: String): List<CountryInfoByCurrencyResponse>? =
        countryClient.getCountryByCurrency(currencyCode.uppercase())

    fun getCurrency(countryCode: String): CountryInfoCurrencyResponse? =
        countryClient.getCurrency(countryCode.uppercase())

    fun getPhoneCode(countryCode: String): String? = countryClient.getPhoneCode(countryCode.uppercase())

    fun getCountryCode(countryName: String): String{
        return countryClient.getCountryCode(countryName.lowercase().replaceFirstChar {  it.uppercaseChar() })
    }

    fun getCountryNameByCode(countryCode: String): String? =
        countryClient.getCountryNameByCode(countryCode.uppercase())

    fun getCurrencyByCode(currencyCode: String): String? =
        countryClient.getCurrencyByCode(currencyCode.uppercase())

    fun getFullCountryInfo(countryCode: String): FullCountryInformationRespone? =
        countryClient.getFullCountryInfo(countryCode.uppercase())

    fun getAllCountries(): List<FullCountryInformationRespone>? =
        countryClient.getAllCountries()

    fun getLanguageCode(languageName: String): String? =
        countryClient.getLanguageCode(languageName)

    fun getLanguageName(languageCode: String): String? =
        countryClient.getLanguageName(languageCode)

    fun getAllContinents(): List<ContinentResponse>? =
        countryClient.getAllContinents()

    fun getAllCurrencies(): List<CurrencyResponse>? =
        countryClient.getAllCurrencies()

    fun getAllLanguages(): List<LanguageResponse>? =
        countryClient.getAllLanguages()
}