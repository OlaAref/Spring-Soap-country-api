package com.olaaref.countryinfo.service

import com.olaaref.countryinfo.soap.CountryClient
import com.olaaref.countryinfo.soap.response.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * A service class for retrieving information about countries using SOAP-based web services.
 *
 * This class provides a high-level interface for retrieving country information by acting as a wrapper around
 * the CountryClient class. It is annotated with @Service to indicate that it is a Spring-managed bean that can be
 * autowired into other Spring components. The CountryClient instance used by this class for retrieving data is
 * provided via dependency injection in the constructor.
 *
 * @param countryClient The CountryClient instance used for retrieving country information.
 */
@Service
class CountryService @Autowired constructor(private val countryClient: CountryClient){

    /**
     * Returns the capital city of the specified country.
     *
     * @param countryCode The ISO code of the country.
     * @return The capital city of the specified country, or null if not found.
     */
    fun getCapitalCity(countryCode: String): String? = countryClient.getCapitalCity(countryCode.uppercase())

    /**
     * Returns a list of countries that use the specified currency.
     *
     * @param currencyCode The ISO currency code.
     * @return A list of countries that use the specified currency, or null if not found.
     */
    fun getCountryByCurrency(currencyCode: String): List<CountryInfoByCurrencyResponse>? =
        countryClient.getCountryByCurrency(currencyCode.uppercase())

    /**
     * Returns the currency used by the specified country using ISO code of the country.
     *
     * @param countryCode The ISO code of the country.
     * @return The currency used by the specified country, or null if not found.
     */
    fun getCurrency(countryCode: String): CountryInfoCurrencyResponse? =
        countryClient.getCurrency(countryCode.uppercase())

    /**
     * Returns the phone code of the specified country using ISO code of the country.
     *
     * @param countryCode The ISO code of the country.
     * @return The phone code of the specified country, or null if not found.
     */
    fun getPhoneCode(countryCode: String): String? = countryClient.getPhoneCode(countryCode.uppercase())

    /**
     * Returns the ISO code of the specified country using country name.
     *
     * @param countryName The name of the country.
     * @return The ISO code of the specified country, or null if not found.
     */
    fun getCountryCode(countryName: String): String{
        return countryClient.getCountryCode(countryName.lowercase().replaceFirstChar {  it.uppercaseChar() })
    }

    /**
     * Returns the name of the specified country using ISO code of the country.
     *
     * @param countryCode The ISO code of the country.
     * @return The name of the specified country, or null if not found.
     */
    fun getCountryNameByCode(countryCode: String): String? =
        countryClient.getCountryNameByCode(countryCode.uppercase())

    /**
     * Returns the currency used by the currency code.
     *
     * @param currencyCode The ISO currency code.
     * @return The currency used by the currency code, or null if not found.
     */
    fun getCurrencyByCode(currencyCode: String): String? =
        countryClient.getCurrencyByCode(currencyCode.uppercase())

    /**
     * Returns full information about a specific country using its ISO code.
     *
     * @param countryCode The ISO code of the country.
     * @return Full information about a specific country using its ISO code, or null if not found.
     */
    fun getFullCountryInfo(countryCode: String): FullCountryInformationRespone? =
        countryClient.getFullCountryInfo(countryCode.uppercase())

    /**
     * Returns all countries and their information.
     *
     * @return A list of all countries and their information, or null if not found.
     */
    fun getAllCountries(): List<FullCountryInformationRespone>? =
        countryClient.getAllCountries()

    /**
     * Returns the ISO language code for a given language by its name.
     *
     * @param languageName The name of a language
     * @return The ISO language code for a given language name, or null if not found.
     */
    fun getLanguageCode(languageName: String): String? =
        countryClient.getLanguageCode(languageName)

    /**
     * Returns the name of a specified language by its ISO code.
     *
     * @param languageCode The ISO language of a language
     * @return The name of a specified language by its ISO code, or null if not found.
     */
    fun getLanguageName(languageCode: String): String? =
        countryClient.getLanguageName(languageCode)

    /**
     * Returns a list of all continents in the world, including their names and codes.
     *
     * @return A list of all continents, or null if not found.
     */
    fun getAllContinents(): List<ContinentResponse>? =
        countryClient.getAllContinents()

    /**
     * Returns a list of all currencies in the world, including their names and codes.
     *
     * @return A list of all currencies, or null if not found.
     */
    fun getAllCurrencies(): List<CurrencyResponse>? =
        countryClient.getAllCurrencies()

    /**
     * Returns a list of all languages in the world, including their names and codes.
     *
     * @return A list of all languages, or null if not found.
     */
    fun getAllLanguages(): List<LanguageResponse>? =
        countryClient.getAllLanguages()
}