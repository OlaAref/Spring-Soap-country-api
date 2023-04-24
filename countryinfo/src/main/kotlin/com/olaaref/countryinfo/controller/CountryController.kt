package com.olaaref.countryinfo.controller

import com.olaaref.countryinfo.service.CountryService
import com.olaaref.countryinfo.soap.response.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * A Spring REST controller for exposing endpoints related to country information.
 *
 * This controller handles HTTP requests related to country information and delegates the actual processing
 * to the CountryService class. It is annotated with @RestController to indicate that it is a REST controller
 * that returns data in a serialized format. The @RequestMapping annotation is used to specify the base URL
 * for all requests handled by this controller. The CountryService instance used by this class for retrieving
 * data is provided via dependency injection in the constructor.
 *
 * @param countryService The CountryService instance used for retrieving country information.
 */
@RestController
@RequestMapping("country")
class CountryController @Autowired constructor(private val countryService: CountryService) {

    /**
     * Returns the capital city of the country with the given code.
     *
     * @param code The country code.
     * @return The capital city of the country.
     */
    @GetMapping("/{code}/capital")
    fun getCapitalCity(@PathVariable("code") code: String): String? = countryService.getCapitalCity(code)

    /**
     * Returns a list of countries that use the specified currency code.
     *
     * @param currencyCode The currency code.
     * @return A list of countries that use the specified currency code.
     */
    @GetMapping("/currency-code/{currencyCode}")
    fun getCountryByCurrency(@PathVariable("currencyCode") currencyCode: String): List<CountryInfoByCurrencyResponse>? =
        countryService.getCountryByCurrency(currencyCode)

    /**
     * Returns the currency used by the country with the given code.
     *
     * @param countryCode The country code.
     * @return The currency used by the country.
     */
    @GetMapping("/{code}/currency")
    fun getCurrency(@PathVariable("code") countryCode: String): CountryInfoCurrencyResponse? =
        countryService.getCurrency(countryCode)

    /**
     * Returns the phone code of the country with the given code.
     *
     * @param countryCode The country code.
     * @return The phone code of the country.
     */
    @GetMapping("/{code}/phone")
    fun getPhoneCode(@PathVariable("code") countryCode: String): String? = countryService.getPhoneCode(countryCode)

    /**
     * Returns the ISO country code for the given country name.
     *
     * @param countryName The name of the country.
     * @return The ISO country code for the given country name.
     */
    @GetMapping("/name/{name}")
    fun getCountryCode(@PathVariable("name") countryName: String): String{
        return countryService.getCountryCode(countryName)
    }

    /**
     * Returns the name of the country with the given code.
     *
     * @param countryCode The country code.
     * @return The name of the country with the given code.
     */
    @GetMapping("/{code}/name")
    fun getCountryNameByCode(@PathVariable("code") countryCode: String): String? =
        countryService.getCountryNameByCode(countryCode)

    /**
     * Returns the currency used by countries that use the specified currency code.
     *
     * @param currencyCode The currency code.
     * @return The currency used by countries that use the specified currency code.
     */
    @GetMapping("/currency/currency-code/{currencyCode}")
    fun getCurrencyByCode(@PathVariable("currencyCode") currencyCode: String): String? =
        countryService.getCurrencyByCode(currencyCode)

    /**
     * Returns detailed information about a specific country.
     *
     * @param countryCode The ISO country code for the desired country.
     * @return Detailed information about a specific country.
     */
    @GetMapping("/{code}/full/info")
    fun getFullCountryInfo(@PathVariable("code") countryCode: String): FullCountryInformationRespone? =
        countryService.getFullCountryInfo(countryCode)

    /**
     * Returns a list of all countries in the world, including their names, capital cities, and more.
     *
     * @return A list of all countries in the world.
     */
    @GetMapping("/all")
    fun getAllCountries(): List<FullCountryInformationRespone>? =
        countryService.getAllCountries()

    /**
     * Returns the ISO language code for the given language name.
     *
     * @param languageName The name of the language.
     * @return The ISO language code for the given language name.
     */
    @GetMapping("/language/lang-name/{langName}")
    fun getLanguageCode(@PathVariable("langName") languageName: String): String? =
        countryService.getLanguageCode(languageName)

    /**
     * Returns the name of the language with the given ISO code.
     *
     * @param languageCode The ISO code of the language.
     * @return The name of the language with the given ISO code.
     */
    @GetMapping("/language/lang-code/{langeCode}")
    fun getLanguageName(@PathVariable("langeCode") languageCode: String): String? =
        countryService.getLanguageName(languageCode)

    /**
     * Returns a list of all continents in the world, including their names and codes.
     *
     * @return A list of all continents in the world.
     */
    @GetMapping("/continents")
    fun getAllContinents(): List<ContinentResponse>? =
        countryService.getAllContinents()

    /**
     * Returns a list of all currencies in the world, including their names and codes.
     *
     * @return A list of all currencies in the world.
     */
    @GetMapping("/currencies")
    fun getAllCurrencies(): List<CurrencyResponse>? =
        countryService.getAllCurrencies()

    /**
     * Returns a list of all languages in the world, including their names and codes.
     *
     * @return A list of all languages in the world.
     */
    @GetMapping("/languages")
    fun getAllLanguages(): List<LanguageResponse>? =
        countryService.getAllLanguages()
}